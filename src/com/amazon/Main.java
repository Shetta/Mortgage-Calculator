package com.amazon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //First, you need to ask the user to input their Principle
        int Principle = (int) Console.readNumber("Principle: ", 1000, 1_000_000);

        //Secondly, you need to ask the user for the "R" Annual interest rate.
        float Rate = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);

        //Thirdly, you need to ask for the period.
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        //Calling the Methods
        var calculator = new Calculator (Principle, Rate, years);
        var report = new PrintMortgage(calculator);
        report.Mortgage();
        report.printPaymentSchedule();
    }

}
