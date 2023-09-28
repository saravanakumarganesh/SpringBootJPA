package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.dao.AlienRestRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@Autowired
	AlienRestRepo restRepo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("in home");
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		System.out.println("stored aid " + alien.getAid());
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByTech("java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSortByName("java"));
		
		mv.addObject(alien);
		mv.setViewName("showAlien.jsp");
	
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
		return restRepo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienRest(@PathVariable int aid) {
		return restRepo.findById(aid);
		
	}

}
