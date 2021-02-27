package com.kaustubh.moviereviews.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@PropertySource(value={"classpath:messages.properties"})
public class MovieReviewsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewsServerApplication.class, args);
	}

}
