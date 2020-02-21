package com.CollectionExercises.Q5Employee;

public class Employee {
    private double age;
    private double Salary;
    private String Name;

    public Employee(double age, double salary, String name) {
        this.age = age;
        this.Salary = salary;
        this.Name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", Salary=" + Salary +
                ", Name='" + Name + '\'' +
                '}';
    }
}
