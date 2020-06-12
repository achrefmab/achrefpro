package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Client;

@CrossOrigin("http://localhost:4200")

@Repository
public interface ClientRepos extends JpaRepository<Client, Long> {
	Client findByEmail(String email);


}
