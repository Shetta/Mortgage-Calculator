package com.amazon;

import java.text.NumberFormat;

public class PrintMortgage {
    //Printing the Mortgage

    private Calculator calculator;
    private final NumberFormat currency;

    public PrintMortgage(Calculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void Mortgage() {
        double M = calculator.calculateMortgage();
        //Formatting into Currency
        String Mortgage = NumberFormat.getCurrencyInstance().format(M);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + Mortgage);
    }

    //Printing the Schedule
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
    }

