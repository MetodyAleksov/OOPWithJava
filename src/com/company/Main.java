package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        System.out.print("Period (Years): ");

        byte years = scanner.nextByte();

        MortgageCalculator mc = new MortgageCalculator(principal, annualInterest, years);

        System.out.println("Class mortgage: " + mc.getFormattedMortgage());
    }
}
