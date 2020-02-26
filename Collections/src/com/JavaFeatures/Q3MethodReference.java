package com.JavaFeatures;

interface addNumber{
    void add(int a,int b);
}
interface subtractNumber{
    void subtract(int a,int b);
}
interface multiplyNumber{
    void multiply(int a);
}
public class Q3MethodReference {
    void addMethod(int a,int b)
    {
        System.out.println("Addition: "+(a+b));
    }
    void subtractMethod(int a,int b)
    {
        System.out.println("Subtraction: "+(a-b));
    }
    static void multiplyMethod(int a)
    {
        System.out.println("Multiplication: "+(a*5));
    }
    public static void main(String[] args) {
        addNumber addNum= new Q3MethodReference()::addMethod;
        addNum.add(4,8);
        subtractNumber subtractNum=new Q3MethodReference()::subtractMethod;
        subtractNum.subtract(20,7);
        multiplyNumber multiplyNum=Q3MethodReference::multiplyMethod;
        multiplyNum.multiply(6);
    }
}