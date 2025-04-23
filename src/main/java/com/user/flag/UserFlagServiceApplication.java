package com.user.flag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "User Flag Service API", version = "1.0", description = "API documentation for the User Flag Service"))
@SpringBootApplication
public class UserFlagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserFlagServiceApplication.class, args);
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
