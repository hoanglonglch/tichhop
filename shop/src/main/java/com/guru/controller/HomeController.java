package com.guru.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.model.Role;
import com.guru.repository.RoleRepository;

@Controller
public class HomeController {
	
	@Autowired
	RoleRepository repositoryRole;
    private static Logger logger = Logger.getLogger(HomeController.class);
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home1() {
		return "homePage";

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String executeSecurity(ModelMap model,Principal principal) {
		String author= principal.getName();
		model.addAttribute("message", "Spring Security Hello World");
		model.addAttribute("author", author);
		return "welcome";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPae(ModelMap model) {
		model.addAttribute("message", "this is admin page");
		model.addAttribute("author", "adminPage");
		return "welcome";

	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,String error, String logout) {
//		if Having error parameter, will add error to view
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logout(ModelMap model) {
	 
	  return "login";
	 
	 }
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	 public String accessDenied(ModelMap model, Principal principal) {
	  String username = principal.getName();
	  model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
	  return "403";
	 }
	
	@RequestMapping(value = "/listRole", method = RequestMethod.GET)
	 public String listRole(ModelMap model, Principal principal) {
		List<Role> roles= repositoryRole.findAll();
		logger.info("role la"+roles.get(0).getName());
		model.addAttribute("roles",roles);
		return "listRole";
		 }
	
}