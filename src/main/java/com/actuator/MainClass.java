package com.actuator;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainClass {


    @Bean
    public TimedAspect timedAspect(MeterRegistry meterRegistry){
        return new TimedAspect(meterRegistry);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }
}
