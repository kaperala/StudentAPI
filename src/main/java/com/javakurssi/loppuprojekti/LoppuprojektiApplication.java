package com.javakurssi.loppuprojekti;
import java.io.FileNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoppuprojektiApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(LoppuprojektiApplication.class, args);

		CourseService cs = new CourseService();
		
	}

}
