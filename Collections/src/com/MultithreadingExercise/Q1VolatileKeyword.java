package com.MultithreadingExercise;

import java.util.Scanner;

    class Processor extends Thread {

        private volatile int x = 10;

        public void run() {

            while(x==10) {
                System.out.println("Running....."+x);

                try {
                    Thread.sleep(1000 );
                } catch (InterruptedException e) {
                    // TODO Auzto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            x++;
        }
    }

public class Q1VolatileKeyword  {

        public static void main(String[] args) {
            Processor pro = new Processor();
            pro.start();

            // Wait for the enter key
            new Scanner(System.in).next();

            pro.shutdown();
        }

    }




