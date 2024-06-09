package com.project.todo;

import com.project.todo.aop.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Autowired
	private BusinessService businessService;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello AOP "+ businessService.calculateSum());
	}
}
