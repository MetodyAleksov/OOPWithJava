package com.company;

import java.text.NumberFormat;

public class MortgageCalculator {
    //Constants
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private float monthlyInterest;
    private byte years;
    private int numberOfPayments;

    private double mortgage;

    public MortgageCalculator(int principal, float annualInterest, byte years){
        this.setPrincipal(principal);
        this.setAnnualInterest(annualInterest);
        this.setYears(years);
        this.setMonthlyInterest();
        this.setNumberOfPayments();
        this.setMortgage();
    }

    public String getFormattedMortgage(){
        return NumberFormat.getCurrencyInstance().format(mortgage);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("----------------");
        sb.append("\nTotal Mortgage: " + getFormattedMortgage());
        sb.append("\nNumber of payments: " + getNumberOfPayments());
        sb.append("\n----------------");

        return sb.toString();
    }

    //Setters and getters
    private int getPrincipal() {
        return principal;
    }

    private void setPrincipal(int principal) {
        if(principal <= 0){
            throw new IllegalArgumentException("Principal cannot be less than or equal to 0!");
        }
        this.principal = principal;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    private void setAnnualInterest(float annualInterest) {
        if(annualInterest <= 0){
            throw new IllegalArgumentException("Annual interest cannot be less than or equal to 0!");
        }
        this.annualInterest = annualInterest;
    }

    private float getMonthlyInterest() {
        return monthlyInterest;
    }

    private void setMonthlyInterest() {
        this.monthlyInterest = getAnnualInterest() / MONTHS_IN_YEAR / PERCENT;
    }

    private byte getYears() {
        return years;
    }

    private void setYears(byte years) {
        if(years <= 0 || years > 100){
            throw new IllegalArgumentException("Years must be between 1 and 100");
        }
        this.years = years;
    }

    private int getNumberOfPayments() {
        return numberOfPayments;
    }

    private void setNumberOfPayments() {
        this.numberOfPayments = getYears() * MONTHS_IN_YEAR;
    }

    public double getMortgage() {
        return mortgage;
    }

    private void setMortgage() {
        this.mortgage = principal *
                (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);;
    }
}
