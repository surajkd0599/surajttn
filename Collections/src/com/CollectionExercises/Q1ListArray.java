package com.CollectionExercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q1ListArray {
    public static void main(String[] args) {
        List<Float> array = new ArrayList<>();

        array.add(5.25f);
        array.add(6.34f);
        array.add(8.25f);
        array.add(9.12f);
        array.add(1.34f);

        float sum = 0.0f;

        Iterator<Float> itr = array.iterator();

        while(itr.hasNext()){
            sum = sum + itr.next();
        }

        System.out.println("Sum of number is : "+sum);

    }
}
