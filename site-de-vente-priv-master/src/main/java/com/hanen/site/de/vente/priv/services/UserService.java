package com.hanen.site.de.vente.priv.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.hanen.site.de.vente.priv.model.User;
import com.hanen.site.de.vente.priv.web.dto.UserRegistrationDto;

public interface UserService  extends UserDetailsService {

    User save(UserRegistrationDto registration);
}