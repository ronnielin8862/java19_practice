package org.example;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Java19App
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(Java19App.class)
                .bannerMode(Banner.Mode.OFF)
                .run();
    }
}
