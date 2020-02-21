package com.CollectionExercises.Q6Student;

public class Student {
    private String Name;
    private double Score;
    private double Age;

    public Student(String name, double score, double age) {
        this.Name = name;
        this.Score = score;
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public double getAge() {
        return Age;
    }

    public void setAge(double age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Score=" + Score +
                ", Age=" + Age +
                '}';
    }
}
