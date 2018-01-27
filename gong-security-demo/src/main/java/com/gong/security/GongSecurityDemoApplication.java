package com.gong.security;

import com.gong.security.core.properties.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GongSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GongSecurityDemoApplication.class, args);
	}

}
