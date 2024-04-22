package com.example.ProgramTechCP_Filtration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProgramTechCpFiltrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramTechCpFiltrationApplication.class, args);
		System.out.print("Server started " + LocalDateTime.now());
	}

}
