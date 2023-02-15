package me.study.hellooauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class HelloOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloOauthApplication.class, args);
	}

}
