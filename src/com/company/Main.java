package com.company;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Widely used arraylist and linked list (vector,stack)
        //making new list without any type
        List list = new ArrayList();

        //adding values in list
        list.add("1");  //adding string
        list.add(4);    //adding integer
        list.add("2");
        list.add(3,4);  //adding int with index
        list.add(1);
        list.add("super");
        list.add(true);     //adding boolean
        list.add(3.13);     //adding double (default is double)

        System.out.println(list);

        //remove object from list
        //list.remove(1);

        //getting an object from list (may need casting sometimes)
        Object ob = list.get(7);
        System.out.println(ob.getClass().getName());  //print the type of variable

        //setting index 1 as override in list
        list.set(1,"override");


        //getting size of list
        int size = list.size();


        //getting all objects in list
        //method 1 (using iterator)

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //method 2 (using for each loop)

        for (Object obj : list) {
            System.out.println(obj);

        }

        //method 3 (using for loop) (slow)
        for(int i = 0; i < list.size(); i++){
            Object obj = list.get(i);

        }

        //removing all the elements in list
        //list.clear();


        //making generic list with type string
        List<String> mylist = new ArrayList<String >();
        mylist.add("String 1");
        mylist.add("String 2");


        //making list of Student class objects
        Student std1 = new Student("Josh",131);
        Student std2 = new Student("Jenn",321);


        List<Student> studentList = new ArrayList<Student>();
        studentList.add(std1);
        studentList.add(std2);

        for (Student st : studentList) {
            System.out.println("Hello "+ st.getName() +" , roll "+ st.getRoll());
        }



    }


    public static double mortgageCalculate(double principal, double rate, double time){
        double numerator = principal*rate*Math.pow((1+rate),time);
        double denominator = (double) Math.pow((1+rate),time);
        denominator -=1;
        double res = numerator/ denominator;
        double n1,n2,pay;
        String payFormat;
        System.out.println("You need to pay mortgage for "+(int)time +" months");
        System.out.println("-------------------------------------------");
        for(int i =0 ; i<time;i++){
            n1 = principal*( Math.pow((1+rate),time) - Math.pow((1+rate),i+1));
            n2 =  Math.pow((1+rate),time) - 1;
            pay = n1/n2;
            payFormat = NumberFormat.getCurrencyInstance().format(pay);
            System.out.println("Month "+ (i+1) + "----->" + payFormat);

        }
        return (res);
    }

    public static void getInputForMortgageCalculate(){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = (int)getInputValues("Principal: ",200000,100000);
        float annualRate = getInputValues("Annual Interest Rate: ",40,4);
        float monthlyRate = annualRate/MONTHS_IN_YEAR/PERCENT;
        short year = (short)(getInputValues("Period (Year): ",50,5)*12);
        double result = mortgageCalculate(principal,monthlyRate,year);
        String formattedResult = NumberFormat.getCurrencyInstance().format(result);
        System.out.println("Mortgage: "+ formattedResult);


    }


    public static float getInputValues( String inputDisplay, int upperRange, int lowerRange ){
        float dataValue;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(inputDisplay);
            dataValue = scanner.nextFloat();
            if(dataValue<=upperRange && dataValue>=lowerRange)
                break;
            System.out.println("enter values between "+lowerRange + " and" + upperRange);
        }
        return dataValue;
    }




}