package br.com.alura.strch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class StrchApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrchApplication.class, args);


	}

}
