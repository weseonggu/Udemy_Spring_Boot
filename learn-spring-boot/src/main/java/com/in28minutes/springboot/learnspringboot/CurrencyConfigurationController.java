package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// /courses
// Course: id, name, author
//[
// {
//	 "id":1,
//	 "name": "Learn AWS",
//	 "author":"in28minutes"
// }
//]

@RequiredArgsConstructor
@RestController
public class CurrencyConfigurationController {
	
	private final CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveAllCourse(){
		return configuration;
	}
}
