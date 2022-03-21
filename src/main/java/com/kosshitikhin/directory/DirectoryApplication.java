package com.kosshitikhin.directory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@MapperScan("com.kosshitikhin.directory")
@PropertySources({
        @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true),
})
@EnableCaching
public class DirectoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectoryApplication.class, args);
    }

}
