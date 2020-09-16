package com.taringa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.taringa.entity"})
@EnableJpaRepositories(basePackages = {"com.taringa.repository"})
public class DemoTaringaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTaringaApplication.class, args);
	}

}
