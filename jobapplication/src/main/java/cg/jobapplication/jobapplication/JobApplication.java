package cg.jobapplication.jobapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class JobApplication 
{
	public static void main(String[] args) {
		
		SpringApplication.run(JobApplication .class, args);
	}

}
