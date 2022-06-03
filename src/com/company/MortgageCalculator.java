package com.company;

import java.text.NumberFormat;

public class MortgageCalculator {
    //Constants
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(){}

    public MortgageCalculator(int principal, float annualInterest, byte years){
        this.setPrincipal(principal);
        this.setAnnualInterest(annualInterest);
        this.setYears(years);
    }

    public String getFormattedMortgage(){
        return NumberFormat.getCurrencyInstance().format(getMortgage());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("------------------");
        sb.append("\nTotal Mortgage: " + getFormattedMortgage());
        sb.append("\nMonthly payment amount: " + NumberFormat.getCurrencyInstance().format(getMonthlyPayment()));
        sb.append("\nNumber of payments: " + getNumberOfPayments());
        sb.append("\n------------------");

        for (int i = getNumberOfPayments(); i >= 0; i--){
            sb.append("\n" + NumberFormat.getCurrencyInstance().format(getPayment(i)));
        }

        return sb.toString();
    }

    private double getPayment(int paymentNumber){
        return getMonthlyPayment() * paymentNumber;
    }

    //Setters and getters
    private int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        if(principal <= 0){
            throw new IllegalArgumentException("Principal cannot be less than or equal to 0!");
        }
        this.principal = principal;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        if(annualInterest <= 0){
            throw new IllegalArgumentException("Annual interest cannot be less than or equal to 0!");
        }
        this.annualInterest = annualInterest;
    }

    public float getMonthlyInterest() {
        return getAnnualInterest() / MONTHS_IN_YEAR / PERCENT;
    }

    private byte getYears() {
        return years;
    }

    public void setYears(byte years) {
        if(years <= 0 || years > 100){
            throw new IllegalArgumentException("Years must be between 1 and 100");
        }
        this.years = years;
    }

    public int getNumberOfPayments() {
        return getYears() * MONTHS_IN_YEAR;
    }

    public double getMortgage() {
        return principal *
                (getMonthlyInterest() * Math.pow(1+getMonthlyInterest(),getNumberOfPayments()))
                /(Math.pow(1+getMonthlyInterest(),getNumberOfPayments())-1);
    }

    public double getMonthlyPayment(){
        return getMortgage() / getNumberOfPayments();
    }
}
