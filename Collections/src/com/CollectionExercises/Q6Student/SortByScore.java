package com.CollectionExercises.Q6Student;


import java.util.Comparator;

public class SortByScore implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if(s1.getScore() != s2.getScore()){
            return Double.compare(s1.getScore(),s2.getScore());
        }
        else{
            return s1.getName().compareTo(s2.getName());
        }
    }
}

