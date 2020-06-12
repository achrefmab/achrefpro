package com.hanen.site.de.vente.priv.services;




import java.util.List;

import java.util.Optional;

import com.hanen.site.de.vente.priv.model.Client;




public interface ClientService {
	
	public abstract List<Client> findAll();
    public abstract void add(Client client);
    public abstract Client get(Long id);
   // public abstract void update(Long id);
    public abstract void delete(Long id);
    
    //added
    public Client findByEmail(String email);

}
