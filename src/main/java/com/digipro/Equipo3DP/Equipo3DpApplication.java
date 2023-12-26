package com.digipro.Equipo3DP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.digipro.Equipo3DP.DL")
public class Equipo3DpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Equipo3DpApplication.class, args);
	}    
}
