package com.JavaFeatures;

interface interface1
{
    default void show()
    {
        System.out.println("Default interface of interface1");
    }
}
interface interface2
{
    default void show()
    {
        System.out.println("Default interface of interface2");
    }
}
public class Q8MultipleInheritance implements interface1,interface2{
    public void show()
    {
        interface1.super.show();
        interface2.super.show();
    }
    public static void main(String[] args) {
        Q8MultipleInheritance q8=new Q8MultipleInheritance();
        q8.show();
    }
}
