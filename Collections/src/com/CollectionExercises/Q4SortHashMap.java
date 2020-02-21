package com.CollectionExercises;

import java.util.*;

public class Q4SortHashMap {

    public static Map<Integer, String> sortByValue(Map<Integer, String> hm)
    {
        List<Map.Entry<Integer, String> > list =
                new LinkedList<Map.Entry<Integer, String> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() {
            public int compare(Map.Entry<Integer, String> o1,
                               Map.Entry<Integer, String> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<Integer, String> temp = new LinkedHashMap<Integer, String>();
        for (Map.Entry<Integer, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(4,"Suraj");
        map.put(5,"Vishal");
        map.put(6,"Ashutosh");

        Map<Integer, String> hm1 = sortByValue(map);

        for (Map.Entry<Integer,String> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }





}
