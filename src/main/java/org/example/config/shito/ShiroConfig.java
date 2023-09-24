package org.example.config.shito;


import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
        cacheManager.setExpire(120);
        cacheManager.setRedisManager(redisManager());
        return cacheManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setExpire(120);
        sessionDAO.setKeyPrefix("shiro:sessionRedis:");
        sessionDAO.setRedisManager(redisManager());
        return sessionDAO;
    }

    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setGlobalSessionTimeout(120*1000);
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
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

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/test/**","authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }
}
