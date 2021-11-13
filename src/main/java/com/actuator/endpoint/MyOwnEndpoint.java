package com.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "hey")
public class MyOwnEndpoint {

    @ReadOperation    //same as GET
    public String readingEndpoint(){ return "This is my endpoint";}

    @WriteOperation   //same as POST
    public void writingEndPoint(){  };

    @DeleteOperation
    public void deletingEndpoint(){};

}
