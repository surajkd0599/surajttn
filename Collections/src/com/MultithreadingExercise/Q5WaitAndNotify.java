package com.MultithreadingExercise;

class First
{
    public void myProducer() throws InterruptedException {
        synchronized (this)
        {
            System.out.println("By Producer");
            wait();
            System.out.println("The item is consumed and resumed");
        }
    }
    public void myConsumer() throws InterruptedException {
        synchronized (this)
        {
            Thread.sleep(300);
            System.out.println("By Consumer");
            notify();
        }
    }
}
public class Q5WaitAndNotify {
    public static void main(String[] args) {
        First f1=new First();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f1.myProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f1.myConsumer();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
