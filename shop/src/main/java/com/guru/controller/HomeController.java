package com.guru.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.guru.repository.NewRepository;
import com.guru.repository.ParentCateRepository;
import com.guru.repository.RoleRepository;

@Controller
@RequestMapping(value="/")
@Transactional
public class HomeController {
	
	@Autowired
	ParentCateRepository repositoryParent;
	
	@Autowired
	NewRepository repositoryNew;
	
	@ModelAttribute("parentCates")
	public List<ParentCate> getCategories(){
		return repositoryParent.findAll(); 
	}
	
	@Autowired
	RoleRepository repositoryRole;
    private static Logger logger = Logger.getLogger(HomeController.class);
    
    @RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String home1(Model model) {
    	/*lisstThethao=find list new from cate truyen id
    	model.add (the) thao
    	
    	listThoisu 
    	model.addAllAttributes(thoisu);*/
    	
		return "homePage";

	}
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
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
	
	
//	load detail page
	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	 public String detailPage(ModelMap model,@PathVariable("id") String idNew) {
		// request get id and return a detail page of new
		logger.info("long dep trai");
		New newObj=repositoryNew.findOne(Integer.parseInt(idNew));
		model.addAttribute("newObj",newObj);
		return "detail";
		 }
	
	/*@RequestMapping(value = "/timeline/{page}", method = RequestMethod.GET)
	public String timeLine(Model model, HttpServletRequest request,@PathVariable("page")int page) {
		String name = (String) request.getSession().getAttribute("userName");
		User user = userReponsitory.findByUserName(name);
		logger.info("ten user do la"+user.getUserName());
		int idUser = user.getId();
		
		List<Image> images = imageReponsitory.findByUserM_Id(idUser);
		for (Image image : images) {
			if(image.getCategoryM().getId() ==1){
				model.addAttribute("image",image);
			}
			if(image.getCategoryM().getId()==2){
				
			}
		}*/
	
	
}
