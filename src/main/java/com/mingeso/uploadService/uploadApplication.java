package com.mingeso.uploadService;

import com.mingeso.uploadService.services.UploadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class uploadApplication implements CommandLineRunner {
	@Resource
	UploadService uploadService;

	public static void main(String[] args) {
		SpringApplication.run(uploadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		uploadService.deleteAll();
		uploadService.init();
	}
}
