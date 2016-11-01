package com.guru.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.guru.model.Category;
import com.guru.model.New;
import com.guru.model.ParentCate;
import com.guru.model.User;
import com.guru.repository.CategoryRepository;
import com.guru.repository.NewRepository;
import com.guru.repository.ParentCateRepository;
import com.guru.repository.UserRepository;
import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

@Controller
@RequestMapping(value="admin")
@Transactional
public class AdminController {
	
	@Autowired
	CategoryRepository repositoryCate;
	
	@Autowired
	ParentCateRepository repositoryParent;
	
	@Autowired
	NewRepository repositoryNew;
	
	@Autowired
	UserRepository repositoryUser;
	
	 private static Logger logger = Logger.getLogger(AdminController.class);
//	this will load parentCate and category for dropdownList
	/*@ModelAttribute("parentCate")
	List<ParentCate> getParentCate(){
		return repositoryParent.findAll(); 
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("message", "this is admin page");
		model.addAttribute("author", "adminPage");
		return "welcome";
	}
	
	@RequestMapping(value = "/newParent", method = RequestMethod.GET)
	public String managerCate(Model model) {
		model.addAttribute("categoryForm",new Category());
		List<Category> categories = repositoryCate.findAll();
		model.addAttribute("categories",categories);
		return "category";
	}
	
	@RequestMapping(value = "/newParent", method = RequestMethod.POST)
	public String managerCate(ModelMap model,@ModelAttribute("categoryForm")Category category) {
		ParentCate parentCate= new ParentCate(category.getParentCate().getParentName());
		if(repositoryParent.findByParentName(category.getParentCate().getParentName()) == null){
			repositoryParent.save(parentCate);
		}
		int idParent= repositoryParent.findByParentName(parentCate.getParentName()).getId();
		category.setParentCate(repositoryParent.findById(idParent));
		repositoryCate.save(category);
		return "redirect:/admin/newParent";
	}
	
	@RequestMapping(value="createNew", method = RequestMethod.GET)
	public String createNew(Model model){
		model.addAttribute("newForm",new New());
		return "createNew";
	}
	
	@RequestMapping(value="createNew", method = RequestMethod.POST)
	public String createNew1(Model model,@ModelAttribute("newForm")New newForm, 
			@RequestParam CommonsMultipartFile[] listFile,HttpServletRequest request,
			Principal principal) throws IllegalStateException, IOException{
		String saveDirectory = request.getServletContext().getRealPath("/") + "/resources/images/";
		boolean ok =true;
		String image = "";
		if(listFile != null && listFile.length!=0){
			for (CommonsMultipartFile aFile : listFile) {
				image = aFile.getName();
				logger.info("image name la"+image);
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory +aFile.getOriginalFilename()));
					
					//user,category chua co
					if(ok){
						User user=repositoryUser.findByUsername(principal.getName());
						Category category= repositoryCate.findByName(newForm.getCategory().getName());
						newForm.setUser(user);
						newForm.setCategory(category);
						newForm.setImage1(aFile.getOriginalFilename());
						ok=false;
					}else{
						newForm.setImage2(aFile.getOriginalFilename());
						repositoryNew.save(newForm);
					}
				}
			}
			logger.info("save directory "+saveDirectory);
			
		}
		return "redirect:/home";
	}
	
	
}
