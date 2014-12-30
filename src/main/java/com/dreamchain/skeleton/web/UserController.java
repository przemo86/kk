package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.dao.CountryDAO;
import com.dreamchain.skeleton.model.Country;
import com.dreamchain.skeleton.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping(UserController.URL)
public class UserController {

	static final String URL = "/user";
	
	@Autowired
    CountryDAO userService;

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model, @ModelAttribute Country userCommand) {
        model.addAttribute("xxx", "przemek");
        model.addAttribute("userGrid", userService.getAll());
        model.addAttribute("country", new Country());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, @ModelAttribute("country") @Valid Country userCommand, BindingResult result) {
		if (result.hasErrors()) {
			return URL;
		}

        userService.add(userCommand);
        model.addAttribute("userGrid", userService.getAll());
		return "redirect:" + URL;
	}

	
}
