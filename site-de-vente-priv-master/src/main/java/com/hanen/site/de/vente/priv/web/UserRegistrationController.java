package com.hanen.site.de.vente.priv.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanen.site.de.vente.priv.services.UserService;

import com.hanen.site.de.vente.priv.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    

    
    public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
    
    
    public  String   registerUserAccount (@ModelAttribute("user") UserRegistrationDto registration) {
        userService.save(registration);
        return "redirect:/registration?success";
    }

}
