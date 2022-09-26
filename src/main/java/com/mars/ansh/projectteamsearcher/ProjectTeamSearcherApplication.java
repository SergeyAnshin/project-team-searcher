package com.mars.ansh.projectteamsearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProjectTeamSearcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTeamSearcherApplication.class, args);
	}

}
