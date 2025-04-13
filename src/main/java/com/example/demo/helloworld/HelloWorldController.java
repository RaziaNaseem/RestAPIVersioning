package com.example.demo.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
	private MessageSource messageSourcesDource;

	public HelloWorldController(MessageSource messageSourcesDource) {
		this.messageSourcesDource = messageSourcesDource;
	}

	@GetMapping(path = "/helloworld")
	public String helloWorld(){
		return "Hello World";
	}

	@GetMapping(path = "/helloworld-bean")
	public helloWorldBean helloWorldBean(){
		return new helloWorldBean("Hello World");
	}

	@GetMapping(path = "/helloworld/path-variable/{name}")
	public helloWorldBean helloWorldBean(@PathVariable String name){
		return new helloWorldBean("Hello World, " +name);
	}

	@GetMapping(path = "/helloworld-internationalized")
	public String helloWorldInternationalized(){
		Locale locale = LocaleContextHolder.getLocale();
		return messageSourcesDource.getMessage("good.morning.message",null,"Default Message",locale);

	}



}
