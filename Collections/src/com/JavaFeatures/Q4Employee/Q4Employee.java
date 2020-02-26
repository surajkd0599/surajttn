package com.JavaFeatures.Q4Employee;

public class Q4Employee {
    public static void main(String[] args) {
        ConstRef constRef=Employee::new;
        Employee e1=constRef.getEmp("Suraj",22,"Ghaziabad");
        System.out.println(e1);
    }
}
