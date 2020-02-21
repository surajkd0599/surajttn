package com.MultithreadingExercise;

public class Q2ExtendThread extends Thread {

        public void run(){
            System.out.println("thread is running...");
        }
        public static void main(String args[]){
            Q2ExtendThread t1=new Q2ExtendThread();
            t1.start();
        }

}
