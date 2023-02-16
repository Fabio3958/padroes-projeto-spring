package com.example.dioprojetopadroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioProjetoPadroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioProjetoPadroesApplication.class, args);
	}

}
