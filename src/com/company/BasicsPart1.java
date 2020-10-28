package com.company;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class BasicsPart1 {

    public static double mortgageCalculate(double principal, double rate, double time){
        double numerator = principal*rate*Math.pow((1+rate),time);
        double denominator = (double) Math.pow((1+rate),time);
        denominator -=1;
        double res = numerator/ denominator;
        return (res);

    }

    public static void getInputForMortgageCalculate(){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualRate = scanner.nextFloat();
        float monthlyRate =annualRate/PERCENT/MONTHS_IN_YEAR;
        System.out.print("Period (Year):");
        byte year = scanner.nextByte();
        double result = mortgageCalculate(principal,monthlyRate,year);
        String formattedResult = NumberFormat.getCurrencyInstance().format(result);
        System.out.println("Mortgage: "+ formattedResult);
    }

    public static void main(String[] args) {
        //for class PascalNamingConvention
        //for functions, methods, variables camelNamingConvention
        //for constants all uppercase eg: final float PI=3.14F;

        //Primitive type

        int myAge=23;
        float price=33.3F; //L for long
        byte manAge=30;
        int viewCount = 200_000; // using "_" to separate digits in large number

        //Reference type

        Date now = new Date();
        Point point1 = new Point(1,2);
        Point point2 = point1;
        String myName = "Sajid Shrestha" + "!";
        boolean nameContainsS = myName.startsWith("S");
        int nameLength = myName.length();
        int nameContains = myName.indexOf("a"); //gives -1 if doesn't contain, we can use collection of characters as well
        String modName = myName.replace("S","Z");
        //mostly used in string, toupper, to lower, trim
        String specialString = "Hello \n world \t apart \"ooh\" ";
        String location = "c\\ProgramFiles\\";
        //System.out.println(specialString);

        //Arrays
        int[] numberArray = {1,2,3,4,5};
        int[] nextNumberArray = new int[5];
        nextNumberArray[0]=1;
        nextNumberArray[1]=7;
        //System.out.println(Arrays.toString(numberArray)); //to print 1D array

        int[][] num = new int[2][3];
        int[][] numb ={{1,2,3},{5,6,7}};
        //System.out.println(Arrays.deepToString(numb)); //to print multidimensional array

        //constants
        final float PI = 3.14F;


        //Arithmetic operations

        int result1 = 10/2;
        double result2 = (double)10/(double) 3;
        int x = 1;
        int y = 2;
        x++;// postfix
        ++x;//prefix
        x += 1;
        //implicit cast
        int x1 = 2;
        float x2 = x1;
        //explicit cast
        int x3 = (int)x2;
        String x4 = "123";
        int x5 = Integer.parseInt(x4);
        double x6 = Double.parseDouble(x4);

        //Math class
        int result = (int)Math.ceil(1.1F);
        int res = Math.max(1,2);
        double randomFloatValue = Math.random();
        int randomIntValue =(int) Math.round(Math.random()*100);
        // OR (int) (Math.random()*100);

        //System.out.println(randomIntValue);

        //formatting numbers

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String money = currency.format(12345.678);  //number format returns "string"


        String percent = NumberFormat.getPercentInstance().format(0.12);
        //System.out.println(percent);


        //Reading input
        System.out.print("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine().trim(); //use .next for one string
        System.out.println("Hello " + inputName);

        //to use mortgage calculator
        getInputForMortgageCalculate();
    }
}
