package com.CollectionExercises;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2UniqueCharacters {
    public static void uniqueValue (String string) {
        String [] str = string.split("");
        Set<String> unique = new HashSet<String>(Arrays.asList(str));
        String uniqueChar = "";

        for (String value:unique) {
            int count = 0;
            for ( int i= 0; i<str.length; i++) {
                if (value.equals(str[i])) {
                    count++;
                }
            }
            if(count == 1) {
                uniqueChar += value;
            }
        }
        System.out.println("Umique Character in String is : "+uniqueChar);
    }
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String  input = scan.next();
        uniqueValue(input);
    }
}
