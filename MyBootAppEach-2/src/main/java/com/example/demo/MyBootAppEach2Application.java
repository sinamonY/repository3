package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootAppEach2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyBootAppEach2Application.class, args);
		System.out.println("てすと");
		System.out.println("てすとてすと");
		System.out.println("てすとてすとちゃん");
		System.out.println("ジェネリックアカに戻してみたよ");
		System.out.println("ハブをプライベートに戻してみたよ");
	}

}
