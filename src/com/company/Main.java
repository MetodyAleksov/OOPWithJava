package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        MortgageCalculator mc = new MortgageCalculator();

        while(true) {
            System.out.print("Principal: ");
            int principal = scanner.nextInt();

            try{
                mc.setPrincipal(principal);
                break;
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();

            try{
                mc.setAnnualInterest(annualInterest);
                break;
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        while(true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();

            try{
                mc.setYears(years);
                break;
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(mc.toString());
    }
}
