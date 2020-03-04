package com.example.demo;

public class DemoService implements ExecuteService {

    public void createDemo()
    {
        System.out.println("demo created...");
    }

    @Override
    public void executeDemo() {
        System.out.println("Execute demo created...");
    }
}
