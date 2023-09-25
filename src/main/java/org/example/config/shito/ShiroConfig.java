package org.example.config.shito;


import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

@Configuration
public class ShiroConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Bean
    public RedisManager redisManager() {
        return new RonnieRedisManager(redisTemplate);
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setKeyPrefix("shiro:cache:");
        cacheManager.setExpire(1000);
        cacheManager.setRedisManager(redisManager());
        return cacheManager;
    }

//    @Autowired
//    CustomRedisSessionDAO customRedisSessionDAO;
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        CustomRedisSessionDAO sessionDAO = new CustomRedisSessionDAO();
        sessionDAO.setExpire(1000);
        sessionDAO.setKeyPrefix("shiro:sessionRedis:");
        sessionDAO.setRedisManager(redisManager());
        return sessionDAO;
    }

//    @Bean
//    public RedisManager redisManager() {
//        RedisManager redisManager = new RedisManager();
//        redisManager.setSerializer(new SomeSerializer()); // 這裡設置序列化器
//        // ... 其他配置
//        return redisManager;
//    }


    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1000*1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1); // Session的生命周期，-1表示随浏览器关闭
        simpleCookie.setPath("/");
        return simpleCookie;
    }

    @Autowired
    RonnieRealm ronnieRealm;

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(cacheManager());
        List<Realm> realms = new ArrayList<>();
        ronnieRealm.setCachingEnabled(true);
        realms.add(ronnieRealm);

        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        // ... 其他配置，例如URL過濾規則等
        shiroFilter.setLoginUrl("/auth/login");
        shiroFilter.setSuccessUrl("/index");
        shiroFilter.setUnauthorizedUrl("/unauthorized");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/test/**","roles[admin]");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }
}
