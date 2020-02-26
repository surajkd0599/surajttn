package com.JavaFeatures;

interface TestInterface
{
    static void square(int a)
    {
        System.out.println("Inside Static method!!");
        System.out.println("Square is: "+a*a);
    }
    default void show()
    {
        System.out.println("Inside Default Method!!");
    }
}
public class Q6Access implements TestInterface{
    public static void main(String[] args) {
        Q6Access q6=new Q6Access();
        TestInterface.square(5);
        q6.show();
    }
}