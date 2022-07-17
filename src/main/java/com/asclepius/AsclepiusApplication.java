package com.asclepius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author luolinyuan
 */
@EnableCaching
@EnableScheduling
@SpringBootApplication
@MapperScan("com.asclepius.mapper")
public class AsclepiusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsclepiusApplication.class, args);
	}

}
