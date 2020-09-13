package com.taringa.rest;


import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {
	
	@GetMapping("/")
	public String testRest() {
		return "Soy un servicio Rest desde Spring boot "+ new Date();
	}

}
