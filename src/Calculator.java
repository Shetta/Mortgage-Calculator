//Steps:
//M is your monthly payment
//P is your principle
//r is your is your monthly interest rate, calculated by dividing your annual interest rate by 12.
//n is your number of payments (the number of months you will be paying the loan)
// M = P x (r(1+r)^n)/((1+r)^n)-1

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args){

        //Initialize your variables
        float Rate = 0;
        byte years = 0;
        int Principle = 0;

        //USER INPUT
        Scanner input = new Scanner(System.in);

        //First, you need to ask the user to input their Principle
        System.out.print("Principle ($1K - $1M): ");
        Principle = (int) readNumber("Principle: ", 1000, 1_000_000);

        //Secondly, you need to ask the user for the "R" Annual interest rate.
        System.out.print("Annual Interest Rate: ");
        Rate = (float)readNumber("Annual Interest Rate: ", 0, 30);

        //Thirdly, you need to ask for the period.
        System.out.print("Period (Years): ");
        years = (byte) readNumber("Period (Years): ", 1, 30);

        //Calling the Methods
        printMortgage(Rate, years, Principle);
        printPaymentSchedule(Rate, years, Principle);
    }

    //Printing the Mortgage
    public static void printMortgage(float rate, byte years, int principle) {
        double M = calculateMortgage(principle, rate, years);
        //Formatting into Currency
        String Mortgage = NumberFormat.getCurrencyInstance().format(M);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + Mortgage);
    }

    //Printing the Schedule
    public static void printPaymentSchedule(float rate, byte years, int principle) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double Balance = calculateBalance(principle, rate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(Balance));
        }
    }

    //A Method for validating the input
    public static double readNumber(String prompt, double min, double max){
        Scanner input = new Scanner(System.in);
        double value;
        while (true)
        {
            System.out.print(prompt);
            value = input.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.print("Please enter a value between " + min + " and " + max);
        }
        return value;
    }

    //The Calculation steps
    public static double calculateMortgage(
            int Principle,
            float Rate,
            byte years){
            short Period = (short)(years * MONTHS_IN_YEAR);
            float MRate = Rate / PERCENT / MONTHS_IN_YEAR;

            double M = Principle *
                (MRate * Math.pow(1 + MRate, Period))
                / (Math.pow(1 + MRate, Period)-1);

            return M;
    }

    //Calculate the balance
    public static double calculateBalance(
            int Principle,
            float Rate,
            byte years,
            short Payments){

                short Period = (short)(years * MONTHS_IN_YEAR);
                float MRate = Rate / PERCENT / MONTHS_IN_YEAR;

                double Balance = Principle
                        * (Math.pow(1 + MRate, Period) - Math.pow(1 + MRate, Payments))
                        / (Math.pow(1 + MRate, Period) - 1);

                return Balance;

    }
}
