//package org.example.config.shito;
//
//import org.apache.shiro.session.Session;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//
//@Component
//public class CustomRedisSessionDAO extends RedisSessionDAO {
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        System.out.println("Attempting to read session with ID: " + sessionId);
//        Session session = super.doReadSession(sessionId);
//        if (session != null) {
//            System.out.println("Successfully retrieved session from Redis.");
//        } else {
//            System.out.println("Failed to retrieve session from Redis.");
//        }
//        return session;
//    }
//}
// 測試是否有正常從redis取出
