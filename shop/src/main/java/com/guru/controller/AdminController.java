package com.guru.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	 
//	 this will load category for dropdownlist
	 @ModelAttribute("listCategory")
	 Map<String,String> getListCategory(){
		 List<Category> categories=repositoryCate.findAll();
		 Map<String,String> listCategory= new LinkedHashMap<String,String>();
		 int i=1;
		 for (Category category : categories) {
			listCategory.put(i+"", category.getName());
			i++;
		}
		 return listCategory;
	 }
	
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
	public String createNew(@ModelAttribute("newForm")New newForm,@RequestParam CommonsMultipartFile[] listFile,HttpServletRequest request,
			Principal principal) throws ParseException, IllegalStateException, IOException{
		
	/*	get image1
		then get category and principal*/
		
		String saveDirectory = request.getServletContext().getRealPath("/") + "/resources/images/";
		boolean ok =true;
		String image = "";
		if (listFile != null && listFile.length > 0) {
			for (CommonsMultipartFile aFile : listFile) {
				image = aFile.getOriginalFilename();
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
				newForm.setImage1(image);
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				logger.info("thu muc ten " + saveDirectory);
				Category category=repositoryCate.findOne(Integer.parseInt(newForm.getCategory().getName()));
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String day=df.format(newForm.getDate());
				logger.info("day is "+day);
				Date date1=df.parse(day);
				newForm.setDate(date1);
				newForm.setCategory(category);
				User user=repositoryUser.findByUsername(principal.getName());
				newForm.setUser(user);
				
				repositoryNew.save(newForm);
				
				return "redirect:/admin/listNew" ;
			}
		}
		
		return "createNew";
	}
	
	
	
	
	@RequestMapping(value="listNew", method = RequestMethod.GET)
	public String listNew(Model model){
		List<ParentCate> parentCates= repositoryParent.findAll();
		model.addAttribute("parentCates",parentCates);
		model.addAttribute("messeage","hello");
		return "listNew";
	}
	
}
