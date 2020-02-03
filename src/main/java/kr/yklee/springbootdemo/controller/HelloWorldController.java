package kr.yklee.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController {
		
	@GetMapping("/hello")
	public String getHelloWorld() throws InterruptedException {
		log.info("req hello world");
		Thread.sleep(2000);
		return "hello world";
	}
	
	@GetMapping("/hello2")
	public String getHelloWorld2(String param) throws InterruptedException {
		log.info("req hello world2");
		Thread.sleep(2000);
		return param + " + hello world2";
	}

}
