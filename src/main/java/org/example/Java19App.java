package org.example;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Java19App
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(Java19App.class)
                .bannerMode(Banner.Mode.OFF)
                .run();
        System.out.println("＝＝＝ start ＝＝＝");
    }
}
