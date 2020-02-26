package com.JavaFeatures;

@FunctionalInterface
interface Number
{
    int Num(int a,int b);
}
public class Q2ReturnNumber {
    public static void main(String[] args) {
        Number number=(int a,int b)->{
            if(a>b)
                return a;
            else
                return b;
        };
        System.out.println("Returned integer: "+number.Num(60,45));
    }
}