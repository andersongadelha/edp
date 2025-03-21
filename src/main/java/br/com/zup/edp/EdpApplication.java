package br.com.zup.edp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EdpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdpApplication.class, args);
	}

}
