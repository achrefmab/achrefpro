package com.hanen.site.de.vente.priv.controllers;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.services.ClientService;

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class ClientControlleur {
	
	@Autowired
	private ClientService clientService;
	
	 @RequestMapping(value = "/client", method = RequestMethod.GET)
	    public String getClient(@AuthenticationPrincipal final UserDetails userDetails, Model model) {
	    	
	    	String Email = userDetails.getUsername();
	    	String pw = userDetails.getPassword();
	    	
	    	Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
	    	GrantedAuthority  theRole = roles.stream().findFirst().get(); 
	    	String role = theRole.toString();
	    	
	    	if(role.equalsIgnoreCase("ROLE_ADMIN")) {
	        List<Client> clients = clientService.findAll();
	        model.addAttribute("clients", clients);
	        return "client/clientList";
	    	}
	    	else {
	    		return "redirect:/home";
	    	}
	    }

	    @RequestMapping(value = "/client/add", method = RequestMethod.GET)
	    public String addUserForm(Model model) {
	        model.addAttribute("user", new Client());
	        return "client/addClient";
	    }
	    @RequestMapping(value = "/client/add", method = RequestMethod.POST)
	    public String addUser(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {

	        if(result.hasErrors()){
	            model.addAttribute("errors",result.getAllErrors());
	            return "user/addUser";
	        }
	        client.setRole("USER");
	        clientService.add(client);
	        
	       // return "redirect:/users";
	        
	        return "redirect:/products";
	    }

	    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	    public String deleteUser(@PathVariable Long id) {
	        clientService.delete(id);
	        return "redirect:/users";
	    }

	    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	    public String updateUser(@PathVariable Long id, Model model) {
	        //System.out.println("Edit");
	        model.addAttribute("client", clientService.get(id));
	        //productService.add(user);
	        return "user/updateUser";
	    }
	}
