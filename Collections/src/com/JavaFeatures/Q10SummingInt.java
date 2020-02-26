package com.JavaFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Q10SummingInt {
    public static void main(String[] args) {
        List<Integer> list4= Arrays.asList(1,20,3,5,10,6);
        System.out.println(list4
                .stream()
                .filter(e->e>5)
                .collect(Collectors.summingInt(e->e)));
    }
}
