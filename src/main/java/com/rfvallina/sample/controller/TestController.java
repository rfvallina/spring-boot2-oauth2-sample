package com.rfvallina.sample.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

	@GetMapping
	public ResponseEntity<Map<String, String>> test() {

		Map<String, String> out = new HashMap<String, String>() {

			private static final long serialVersionUID = 5456806040857622917L;

			{
				put("id", String.valueOf(serialVersionUID));
				put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			}
		};

		return new ResponseEntity<>(out, HttpStatus.OK);
	}

}
