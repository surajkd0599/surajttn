package com.CollectionExercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q3CharacterNumber {
    public static void characterCount (String string) {
        String [] str = string.split("");
        Set<String> characters = new HashSet<String>(Arrays.asList(str));

        for (String value:characters) {
            int count = 0;
            for ( int i= 0; i<str.length; i++) {
                if (value.equals(str[i])) {
                    count++;
                }
            }
            System.out.println("Character of "+value+" are : ");
                System.out.println(value + "\t" + count);

        }
    }
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String  input = scan.next();
        characterCount(input);
    }
}
