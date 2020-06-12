package com.hanen.site.de.vente.priv.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.repos.ClientRepos;


@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	ClientService clientService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(email);
		Client client = clientService.findByEmail(email);
		return new MyUserPrincipal(client);
	}

}