package com.suyad;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.suyad.entity.Book;
import com.suyad.repo.BookRepo;

@SpringBootApplication
public class Application
{
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext cxt = SpringApplication.run(Application.class, args);
		System.out.println("Application has been Started Successfully........");
		BookRepo r = cxt.getBean(BookRepo.class);
		PageRequest of = PageRequest.of(2, 3);
		Page<Book> all = r.findAll(of);
		all.get().forEach(System.out::println);
		System.out.println("---------------------------");
		System.out.println("Action performed Successfully..........");
	}

}
