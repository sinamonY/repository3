package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Each {

	@RequestMapping(value="/")
	public String index() {
		return "Helo yuriko";
	}
}
