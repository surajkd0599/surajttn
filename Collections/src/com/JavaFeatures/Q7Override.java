package com.JavaFeatures;

interface Myinterface
{
    default void show()
    {
        System.out.println("Default interface of interface1");
    }
}
public class Q7Override implements Myinterface{
    public void show()
    {
        System.out.println("Method Overrided");
    }
    public static void main(String[] args) {
        Q7Override q7=new Q7Override();
        q7.show();
    }
}