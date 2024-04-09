package org.example.api.controller.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestControllerTest {

    String localUrl = "http://localhost:8080";

    @Test
    void login() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> map = new HashMap<>();
        map.put("username","ronnie");
        map.put("password","1234");

        HttpEntity<Map<String, String>> request =
        new HttpEntity<>(map, headers);

        String loginResult = restTemplate.postForObject(localUrl+"/auth/login",request,String.class);
        System.out.println("loginResult = " + loginResult);

//        Map<String, String> map = new HashMap<>();
//        map.put("say", "zimug 发布文章第二篇");
//        // 组装请求体
//        HttpEntity<Map<String, String>> request =
//                new HttpEntity<>(map, headers);
//
//        Object response = restTemplate.postForObject(localUrl+"/test/hello",request, Object.class);
//
//        System.out.println(response.toString());
    }

    @Test
    public void testHello(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> map = new HashMap<>();
        map.put("say", "helllllllllo ");
        // 组装请求体
        HttpEntity<Map<String, String>> request =
                new HttpEntity<>(map, headers);

        Object response = restTemplate.postForObject(localUrl+"/test/hello",request, Object.class);

        System.out.println(response.toString());
    }
}