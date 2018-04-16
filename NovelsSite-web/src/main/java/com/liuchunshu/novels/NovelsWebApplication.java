package com.liuchunshu.novels;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liuchunshu.novels.dao")
public class NovelsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovelsWebApplication.class, args);
	}
}
