package com.MultithreadingExercise;

public class Q2RunnableInterface {

    private class RunnableImp implements Runnable{
        public void run()
        {
            System.out.println(Thread.currentThread().getName()
                    + ", executing run() method!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread is- "
                + Thread.currentThread().getName());
        Thread t1 = new Thread(new Q2RunnableInterface().new RunnableImp());
        t1.start();
    }
}


