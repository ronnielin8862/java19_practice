package org.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST,value = "/hello")
    public String helloWorld(@RequestBody String say){
        System.out.println(say);
// test
        return "World";
    }
}
