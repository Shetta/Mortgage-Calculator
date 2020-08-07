package com.amazon;

import java.util.Scanner;

public class Console {
    //A Method for validating the input
   private static Scanner input = new Scanner(System.in);

   public double readNumber(String prompt){
        return input.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max){
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
}
