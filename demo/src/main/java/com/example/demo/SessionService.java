package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionService implements ExecuteService{




//    @Autowired                  //bean injection method 1
    DemoService demoService;


//   @Autowired
//   SessionService(DemoService demoService){         //bean injection method 2 by constructor
//       this.demoService=demoService;
//   }

   @Autowired //by setter method
   void setDemoService(DemoService demoService) {
       this.demoService = demoService;
   }
   public void createSession(){
        System.out.println("ServiceSession created");
        demoService.createDemo();
    }

    @Override
    public void executeDemo() {
        System.out.println("demosession created....");
    }
}
