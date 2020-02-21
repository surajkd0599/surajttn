package com.MultithreadingExercise;

class Syncblock extends Thread{
    int n=3;
    public void change() {
        synchronized (this) { // synchronized block
            n++;
        }
        System.out.println(n);
    }
    public void run(){
        change();
    }
}
class Sync{
    synchronized public void Printvalue() // Synchronized method
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
class Sync2 extends Thread{
    Sync sy;
    Sync2(Sync sy)
    {
        this.sy = sy;
    }
    public void run()
    {
        sy.Printvalue();
    }
}

public class Q3Sync {
    public static void main(String[] args)
    {
        Sync obj = new Sync();
        Sync2 t1 = new Sync2(obj);
        Sync2 t2 = new Sync2(obj);
        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        }
        catch(InterruptedException e){}
        Syncblock s1 = new Syncblock();
        Syncblock s2 = new Syncblock();
        s1.start();
        s2.start();
    }
}
