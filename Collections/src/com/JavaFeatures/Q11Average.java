package com.JavaFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
public class Q11Average {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,4,6,8,3);
        OptionalDouble op=list.stream().map(e->e*2).mapToInt(e->e).average();
        System.out.println("Average is: "+op.getAsDouble());
    }
}
