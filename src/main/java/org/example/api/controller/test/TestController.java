package org.example.api.controller.test;

import org.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(method = RequestMethod.POST,value = "/hello")
    @ResponseBody
    public String helloWorld(@RequestBody Map<String,String> say){
        System.out.println(say);
        String value = "World";
        String redisReturn = "temp";
        redisUtil.set(say.get("say"),value);

        System.out.println("redisReturn = " + redisReturn);
        return redisReturn.toString();
    }

//    @PostMapping("/testAuthorization")
//    public ResponseEntity testAuthorization(@RequestBody String arg){
//        System.out.println("testAuthorization arg= " + arg);
//
//    }
}
