package com.dxjunkyard.reststarter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Rest Starter",
        description = "REST API project for hackathon",
        version = "v1"),
        servers = {@Server(url = "https://rest-starter.herokuapp.com/", description = "demo"),}
)
public class RestStarterApplication {
    public static void main(final String[] args) {
        SpringApplication.run(RestStarterApplication.class, args);
    }
}
