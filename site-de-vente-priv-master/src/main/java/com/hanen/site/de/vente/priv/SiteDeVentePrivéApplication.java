package com.hanen.site.de.vente.priv;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.hanen.site.de.vente.priv.Config.SecurityConfig;
import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.repos.ClientRepos;



@SpringBootApplication
@ComponentScan({"com.hanen.site.de.vente.priv.controllers","com.hanen.site.de.vente.priv.services"})
public class SiteDeVentePrivéApplication extends SecurityConfig {
	
	

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
   
    
    
	public static void main(String[] args) {
		SpringApplication.run(SiteDeVentePrivéApplication.class, args);
	}







	
}
 