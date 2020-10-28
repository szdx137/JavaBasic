package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private int principal;
    private int periodYear;
    private float yearlyRate;
    private float monthlyRate;
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;
    private double mortageInterest;
    Scanner scanner = new Scanner(System.in);
    public void setPrincipal(){
        System.out.println("Enter Principal:");
        this.principal = scanner.nextInt();
        while(checkInput(principal, 100_000, 200_000)) {
            this.principal = scanner.nextInt();

        }
    }
    public void setPeriodYear(){
        System.out.println("Enter Period in years:");
        this.periodYear = scanner.nextInt();
        while (checkInput(periodYear, 4, 40)) {
            this.periodYear = scanner.nextInt();

        }
        this.periodYear = this.periodYear * 12;
    }

    public void setRate(){
        System.out.println("Enter Interest rate:");
        this.yearlyRate = scanner.nextFloat();
        while(checkInput(yearlyRate,5 , 50)){
            this.yearlyRate = scanner.nextFloat();
        }

        this.monthlyRate = yearlyRate/MONTHS_IN_YEAR/PERCENT;

    }
    public int getPrincipal(){
        return principal;
    }


    public int getPeriodYear() {
        return periodYear;
    }

    public float getYearlyRate() {
        return yearlyRate;
    }

    public double getMortgageInretest(){
        return mortageInterest;
    }

    public boolean checkInput(double value, double min, double max){

            if (value < min && value > max) {
                System.out.println("Enter between " + min + "and " + max);
                return true;
            }
            return false;

    }

    public void calculateMortgage(){

        double numerator = principal* monthlyRate *Math.pow((1+ monthlyRate),periodYear);
        double denominator = (double) Math.pow((1+ monthlyRate),periodYear);
        denominator -=1;
        this.mortageInterest = numerator/ denominator;

    }

    public void calculateEveryBalance(){
        double n1,n2,pay;
        String payFormat;
        for (int i = 0; i <this.periodYear ; i++) {
            n1 = principal*( Math.pow((1+monthlyRate),periodYear) - Math.pow((1+monthlyRate),i+1));
            n2 =  Math.pow((1+monthlyRate),periodYear) - 1;
            pay = n1/n2;
            payFormat = NumberFormat.getCurrencyInstance().format(pay);
            System.out.println("Month "+ (i+1) + "----->" + payFormat);

        }
    }

}
