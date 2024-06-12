package com.example.demo;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.repo.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlDemoApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
				var author1 = authorRepository.save(new Author("venkat"));
				var author2 = authorRepository.save(new Author("Ravi"));

				bookRepository.save(new Book("Effective Java", 2001, author1));
				bookRepository.save(new Book("Spring Book Up & Running", 2021, author2));
		};
	}

}
