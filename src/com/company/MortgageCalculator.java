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



        return sb.toString();
    }

    //Setters and getters
    private int getPrincipal() {
        return principal;
    }

    private void setPrincipal(int principal) {
        this.principal = principal;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    private void setAnnualInterest(float annualInterest) {
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
