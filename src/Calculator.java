import java.text.NumberFormat;
import java.util.Scanner;
import java.util.*;
import java.util.InputMismatchException;


public class Calculator {
    public static void main(String[] args){

        //Define Months and Percentages
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        //Variables
        //M is your monthly payment
        //P is your principle
        //r is your is your monthly interest rate, calculated by dividing your annual interest rate by 12.
        //n is your number of payments (the number of months you will be paying the loan)
        // M = P x (r(1+r)^n)/((1+r)^n)-1

        //USER INPUT
        Scanner input = new Scanner(System.in);

        //First, you need to ask the user to input their Principle
        System.out.print("Principle: ");
        int Principle = input.nextInt();

        //Secondly, you need to ask the user for the "R" Annual interest rate.
        System.out.print("Annual Interest Rate: ");
        float Rate = input.nextFloat();
        float MRate = Rate / PERCENT / MONTHS_IN_YEAR;

        //Thirdly, you need to ask for the period.
        System.out.print("Period (Years): ");
        int Period = input.nextInt();
        Period = Period * MONTHS_IN_YEAR;

        //Equation
        double M = Principle *
                (MRate * Math.pow(1 + MRate, Period))
                        / (Math.pow(1+MRate, Period)-1);

        //Formatting into Currency
        String Mortgage = NumberFormat.getCurrencyInstance().format(M);
        System.out.println("Mortgage: " + Mortgage);


    }
}
