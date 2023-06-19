package com.example.checkchap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Checkchap OpenApi", version = "1", description = "API desenvolvida para fins acadêmicos"))
@SpringBootApplication
public class CheckchapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckchapApplication.class, args);
	}

}
