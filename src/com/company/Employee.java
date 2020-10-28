package com.company;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;



    //Creating constructor to make use of setter , then set setter to private to increase abstraction
    public Employee(int baseSalary, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    //constructor overloading
    //calling a constructor using constructor by "this" keyword
    public Employee(int baseSalary){
        this(baseSalary,0);
    }


    public static void printNumberOfEmployees(){
        System.out.println(numberOfEmployees);

        //creating instance of Employee class (create object) so that we can access
        //members of this class. we can't directly call the other
        //members of the class.
        //Static methods require no objects to be called
        new Employee(1000).calculateWage(10);
    }



    public int calculateWage(int extraHours)
    {
        return baseSalary + (hourlyRate * extraHours);
    }

    // method overloading, just to show example
    // dont use overloaing for minor advantage
    public int calculateWage()
    {
        return calculateWage(0);
    }

    //Making setter private [abstraction]
    private void setBaseSalary(int baseSalary){
        if(baseSalary <= 0)
            //throw exception
            throw new IllegalArgumentException("Salary can be 0 or less");
        this.baseSalary = baseSalary;
    }


    //Making setter private [abstraction]
    private void setHourlyRate(int hourlyRate){
        if(hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate can not be 0 or less");
        this.hourlyRate = hourlyRate;
    }

    // make getter private if its not used
    public int getBaseSalary(){
        return baseSalary;
    }

    public int getHourlyRate(){
        return  hourlyRate;

    }


}
