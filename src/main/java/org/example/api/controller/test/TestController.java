package org.example.api.controller.test;

import org.example.model.AddStaffBo;
import org.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
        String redisReturn = "temp";
        try {

            System.out.println(say);
            String value = "World";
            redisUtil.set(say.get("say"),value);

            System.out.println("redisReturn = " + redisReturn);
        }catch (Exception e){
            System.out.println("ERROR LAAAAAAAAAAAAAAAA");
        }
        return redisReturn.toString();
    }

    @PostMapping("/addStaff")
    public int addStaffData(@Validated @RequestBody AddStaffBo bo){
        System.out.println("1");
        System.out.println(bo);
        return 1;
    }
}
