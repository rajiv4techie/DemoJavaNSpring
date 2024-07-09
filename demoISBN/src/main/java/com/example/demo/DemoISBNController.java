package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoISBNController {

	@GetMapping("/api/isbninfo")
	public String getBookInfoByIsbn(@RequestParam String isbn) {
		// Add Logic Here 
		RestTemplate restTemplate = new RestTemplate();
		
		// Use following URL to test in the local Browser such as :
		// http://localhost:8080/api/isbninfo?isbn=123456789
		// http://localhost:8080/api/isbninfo?isbn=0070676224

    	String externalURLString = "https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=data&format=json";

    	String response = restTemplate.getForObject(externalURLString, String.class);
    	
		return response;
	}
}
