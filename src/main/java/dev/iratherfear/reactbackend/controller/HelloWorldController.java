package dev.iratherfear.reactbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.iratherfear.reactbackend.beans.HelloWorld;



@RestController
public class HelloWorldController {
    
    @GetMapping("/basicauth")
    public String basicAuthCheck() {
        return "SUCCESS";
    }

    @GetMapping("/hello-world")
    public String getHelloString() {
        return new String("Hello World String");
    }
    
    @GetMapping("/hello-world-bean")
    public HelloWorld getHelloBean() {
        return new HelloWorld("Hello World");
    }
    
    @GetMapping("/hello-world-bean/{user}")
    public String getHelloBeanWithPath(@PathVariable String user) {
        return new String(user);
    }
}
