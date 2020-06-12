package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Facture;

@CrossOrigin("http://localhost:4200")
@Repository

public interface FactureRepos extends JpaRepository<Facture, Long>{

}
