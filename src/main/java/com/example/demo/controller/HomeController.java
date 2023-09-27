package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Alien;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("in home");
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		System.out.println("aid " + alien.getAid());
		return "home.jsp";
	}

}
