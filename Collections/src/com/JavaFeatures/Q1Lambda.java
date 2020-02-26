package com.JavaFeatures;

//part1
interface greaterNumber
{
    boolean findGreater(int a,int b);
}
//part2
interface IncrementNumber
{
    int incrementNumber(int a);
}
//part3
interface ConcatString
{
    String Concat(String s1,String s2);
}
//part4
interface ToUpper
{
    String toUpper(String s);
}
public class Q1Lambda {
    public static void main(String[] args) {
        //part1
        greaterNumber gn = (int x, int y) -> {
            if (x > y)
                return true;
            else
                return false;
        };
        System.out.println("First Number>Second Number? : " + gn.findGreater(6, 2));
        //part2
        IncrementNumber in = x -> {
            return x + 1;
        };
        System.out.println("Value after increment: " + in.incrementNumber(8));
        //part3
        ConcatString cs = (String s1, String s2) -> s1.concat(s2);
        System.out.println("String after concatenation: " + cs.Concat("hello", "World"));
        //part4
        ToUpper tu = s -> {
            return s.toUpperCase();
        };
        System.out.println("String in upper case: "+tu.toUpper("suraj dubey"));
    }
}