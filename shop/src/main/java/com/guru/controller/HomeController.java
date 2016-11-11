package com.guru.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.model.New;
import com.guru.model.ParentCate;
import com.guru.model.Role;
import com.guru.model.User;
import com.guru.repository.NewRepository;
import com.guru.repository.ParentCateRepository;
import com.guru.repository.RoleRepository;
import com.guru.repository.UserRepository;

@Controller
@RequestMapping(value="/")
@Transactional
public class HomeController {
	
	@Autowired
	ParentCateRepository repositoryParent;
	
	@Autowired
	NewRepository repositoryNew;
	
	@Autowired
	UserRepository repositoryUser;
	
	@Autowired
	RoleRepository repositoryRole;
	
	@ModelAttribute("parentCates")
	public List<ParentCate> getCategories(){
		return repositoryParent.findAll(); 
	}
	
    private static Logger logger = Logger.getLogger(HomeController.class);
    
    @RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String home1(Model model) {
    	/*lisstThethao=find list new from cate truyen id
    	model.add (the) thao
    	
    	listThoisu 
    	model.addAllAttributes(thoisu);*/
    	
		return "homePage";

	}
    
    @RequestMapping(value = "/managerHome", method = RequestMethod.GET)
  	public String home(Model model) {
      	
  		return "managerHome";

  	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String executeSecurity(ModelMap model,Principal principal) {
		String author= principal.getName();
		model.addAttribute("message", "Spring Security Hello World");
		model.addAttribute("author", author);
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	 public String register(ModelMap model) {
		model.addAttribute("formUser",new User());
		return "register";
		 }
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	 public String register(ModelMap model,@ModelAttribute("formUser")User user) {
		 Set<Role> roles= new HashSet<Role>(repositoryRole.findAll());
		 Set<Role> roleUser= new HashSet<Role>();
		 for (Role role : roles) {
			 roleUser.add(role);
			 break;
		}
		 user.setRoles(roleUser);
		repositoryUser.save(user);
		return "register";
		 }
	
	
//	load detail page
	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	 public String detailPage(ModelMap model,@PathVariable("id") String idNew) {
		// request get id and return a detail page of new
		logger.info("long dep trai");
		New newObj=repositoryNew.findOne(Integer.parseInt(idNew));
		model.addAttribute("newObj",newObj);
		return "detail";
		 }
	///////////////////////////////////////////////////
	
	/*version 2 with load exactly one news*/
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	 public String Home(ModelMap model) {
		Page<New> pageNew= repositoryNew.findByCategory_Id(1, new PageRequest(0,4));
		List<New> news= pageNew.getContent();
		model.addAttribute("listNew",news);
		return "managerHome1";
		 }
	
	
	
	
}
