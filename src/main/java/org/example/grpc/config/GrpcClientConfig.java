package org.example.grpc.config;

import org.example.grpc.interceptor.GrpcClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorConfigurer;

@Configuration
public class GrpcClientConfig {

    @Bean
    public GlobalClientInterceptorConfigurer globalClientInterceptorConfigurerAdapter(GrpcClientInterceptor grpcClientInterceptor) {
        System.out.println("註冊攔截器");
        return registry -> registry.add(grpcClientInterceptor);
    }
}
