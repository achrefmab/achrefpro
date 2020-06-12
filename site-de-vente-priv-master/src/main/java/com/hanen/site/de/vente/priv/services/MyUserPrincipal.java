package com.hanen.site.de.vente.priv.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hanen.site.de.vente.priv.model.Client;



public class MyUserPrincipal extends Client implements UserDetails {

  
	public MyUserPrincipal(final Client client) {
		super();
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		String role = getRole();
		List<String> roles = new ArrayList<>();
		roles.add(role);
//		SimpleGrantedAuthority k = new SimpleGrantedAuthority("Role_"+role);
		
		
		return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r)).collect(Collectors.toList());

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getMdp();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getRole() {
		return super.getRole();
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
