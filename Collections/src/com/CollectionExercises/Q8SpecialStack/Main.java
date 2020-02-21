package com.CollectionExercises.Q8SpecialStack;

public class Main {
    public static void main(String[] args)
    {
        StackOperations s = new StackOperations();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(5);
        System.out.println("Minimum Element is : "+s.getMin());

        System.out.println("Popped Element is : "+s.pop());

      s.isFull();

    }
}
