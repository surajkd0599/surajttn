package com.JavaFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class Q12EvenGREATERthree {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,4,6,7,2,7,1);
        Optional<Integer> op= list.stream().filter((e)->e%2==0).filter((e)->e>3).findFirst();
        System.out.println(op.get());
    }
}