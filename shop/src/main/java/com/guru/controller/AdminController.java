package com.guru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.model.Category;
import com.guru.model.ParentCate;
import com.guru.repository.CategoryRepository;
import com.guru.repository.ParentCateRepository;

@Controller
@RequestMapping(value="admin")
@Transactional
public class AdminController {
	
	@Autowired
	CategoryRepository repositoryCate;
	
	@Autowired
	ParentCateRepository repositoryParent;
	
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
		repositoryParent.save(parentCate);
		int idParent= repositoryParent.findByParentName(parentCate.getParentName()).getId();
		category.setParentCate(repositoryParent.findById(idParent));
		repositoryCate.save(category);
		
		return "category";
	}
	
	
}
