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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.guru.model.Category;
import com.guru.model.New;
import com.guru.model.User;
import com.guru.repository.CategoryRepository;
import com.guru.repository.NewRepository;
import com.guru.repository.UserRepository;

@Controller
@RequestMapping(value = "user")
@Transactional
public class UserController {
	@Autowired
	NewRepository repositoryNew;
	@Autowired
	UserRepository repositoryUser;
	@Autowired
	CategoryRepository repositoryCate;
	private static Logger logger = Logger.getLogger(AdminController.class);
	
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
	

	@RequestMapping(value = "createNew", method = RequestMethod.GET)
	public String createNew(Model model) {
		model.addAttribute("newForm", new New());
		return "createNew";
	}

	@RequestMapping(value = "createNew", method = RequestMethod.POST)
	public String createNew(@ModelAttribute("newForm") New newForm, @RequestParam CommonsMultipartFile[] listFile,
			HttpServletRequest request, Principal principal) throws ParseException, IllegalStateException, IOException {

		/*
		 * get image1 then get category and principal
		 */

		String saveDirectory = request.getServletContext().getRealPath("/") + "/resources/images/";
		boolean ok = true;
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
				Category category = repositoryCate.findOne(Integer.parseInt(newForm.getCategory().getName()));

				String pattern = "yyyy-MM-dd hh:mm:ss";
				DateFormat df = new SimpleDateFormat(pattern);
				Date date = new Date();
				String day = df.format(date);
				Date date1 = df.parse(day);
				newForm.setDate(date1);
				newForm.setCategory(category);
				User user = repositoryUser.findByUsername(principal.getName());
				newForm.setUser(user);
				newForm.setCount(1);

				repositoryNew.save(newForm);

				return "redirect:/home";
			}
		}

		return "createNew";
	}
}
