package com.stminds.dubbo;

import com.stminds.dubbo.api.DubboTest;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableDubbo
public class App {

    @DubboReference
    DubboTest dubboTest;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        System.out.println(dubboTest.sayHi());
    }
}
