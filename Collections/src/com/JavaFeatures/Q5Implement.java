package com.JavaFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Q5Implement {
    public static void printList(List<Integer> list1,Consumer<Integer> con)
    {
        for(int i: list1)
            con.accept(i);
    }
    public static void main(String[] args) {
        //part1
        System.out.println("Consumer Printed: " );
        Consumer<Integer> consumer=i-> System.out.print(" "+i);
        List<Integer> list= Arrays.asList(2,6,7,9,5);
        printList(list,consumer);
        System.out.println();
        //part2
        Supplier<Double> supplier=()->Math.random();
        System.out.println("Supplier returned : "+supplier.get());
        //part3
        System.out.println("Predicate");
        Predicate<Integer> predicate=i->(i>10);
        System.out.println("Is number 40 more than 10?: "+predicate.test(40));
        //part 4
        System.out.println("Function");
        Function<Integer,Integer> add = x -> x + 1;
        Integer two = add.apply(7);
        System.out.println("Function: "+two);
    }

}