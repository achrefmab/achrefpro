package com.hanen.site.de.vente.priv.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.Role;
import com.hanen.site.de.vente.priv.model.User;
import com.hanen.site.de.vente.priv.repos.UserRepository;

import com.hanen.site.de.vente.priv.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    

  

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }





	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     User user = userRepository.findByEmail(username);
     if(user==null) {
         throw new UsernameNotFoundException("Invalid username or password.");
     }
     return new org.springframework.security.core.userdetails.User(user.getEmail(),  //we have created a user object provided by spring security
             user.getPassword(),mapRolesToAuthorities(user.getRoles()));
             
 }
	
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){ //donner une authorization a Role avec spring security//
    	return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))   // we collect stream into a list
                .collect(Collectors.toList());
	}
    }



	


	
