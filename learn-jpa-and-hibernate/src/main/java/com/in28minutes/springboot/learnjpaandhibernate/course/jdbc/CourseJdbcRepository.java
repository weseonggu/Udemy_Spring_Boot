package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Repository
public class CourseJdbcRepository {
	
	private final JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY=
			"""
			insert into course(id, name, author)
				values(?,?,?);
			""";
	private static String DELETE_QUERY=
			"""
			delete from course where id=?
			""";
	private static String SELECT_QUERY=
			"""
			select * from course where id = ?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,
				course.getId(), 
				course.getName(),
				course.getAuthor());
	}
	
	public void delete() {
		springJdbcTemplate.update(DELETE_QUERY,"2");
	}
	
	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), 
				id);
	}
}
