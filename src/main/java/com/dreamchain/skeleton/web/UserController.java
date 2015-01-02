package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.dao.CountryDAO;
import com.dreamchain.skeleton.dao.RegionDAO;
import com.dreamchain.skeleton.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(UserController.URL)
public class UserController {

	static final String URL = "/countries";
	
	@Autowired
    CountryDAO countryDAO;

    @Autowired
    RegionDAO regionDAO;

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model, @ModelAttribute Country userCommand) {
        model.addAttribute("xxx", "przemek");
        model.addAttribute("countryList", countryDAO.getAll());
        model.addAttribute("regionList", regionDAO.getAll());
        model.addAttribute("country", new Country());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model, @ModelAttribute("country") @Valid Country userCommand, BindingResult result) {
		if (result.hasErrors()) {
            return URL;
		}
        countryDAO.add(userCommand);
        model.addAttribute("countryList", countryDAO.getAll());
		return "redirect:" + URL;
	}

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(value = "id") String id) {
        System.out.println("REMOVING");
        Country c = new Country();
        c.setCountryId(id);
        countryDAO.remove(c);

        return "redirect:" + URL;
    }

}
