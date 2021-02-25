package com.example.fan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.fan.service.FanFunctionality;


//@EnableJpaRepositories(basePackages = "com.example.stock.dbservice.repository")
@SpringBootApplication
public class Application {
	


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

			}

}
