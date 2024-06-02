package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	private final CourseJdbcRepository repository; 
	private final CourseJpaRepository repository;
	
//	private final CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Spring JDBC, JPA사용한거
		repository.insert(new Course(1,"Learn AWS jpa","in28minutes"));
		repository.insert(new Course(2,"Learn Azure jpa","in28minutes"));
		repository.insert(new Course(3,"Learn DevOps jpa","in28minutes"));
		
		// Spring Data JPA를 사용한거
//		repository.save(new Course(1,"Learn AWS jpa","in28minutes"));
//		repository.save(new Course(2,"Learn Azure jpa","in28minutes"));
//		repository.save(new Course(3,"Spring Data jpa","WeSeongGu"));
		
		repository.deleteById(2);
		System.out.println(repository.findById(1));
		System.out.println(repository.findById(3));
		
//		System.out.println(repository.findAll());
//
//		System.out.println(repository.findByAuthor("WeSeongGu"));
//		System.out.println(repository.findByName("Learn AWS jpa"));
	}
}
