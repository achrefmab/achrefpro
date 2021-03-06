package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Commande;


@CrossOrigin("http://localhost:4200")
@Repository

public interface CommandeRepos extends JpaRepository<Commande, Long>{

}
