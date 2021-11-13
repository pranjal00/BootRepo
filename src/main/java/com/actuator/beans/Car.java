package com.actuator.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "car")
public class Car {

    private String carName;
    private String carNo;

}
