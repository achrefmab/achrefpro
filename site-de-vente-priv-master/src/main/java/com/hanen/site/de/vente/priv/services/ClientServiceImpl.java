package com.hanen.site.de.vente.priv.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.repos.ClientRepos;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepos clientrepos;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public List<Client> findAll(){
        return clientrepos.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void add(Client client){
        clientrepos.save(client);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Client get(Long id){
        Optional<Client> opt = clientrepos.findById(id);
        return opt.orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void delete(Long id) {
        clientrepos.deleteById(id);
    }
    
    //added
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Client findByEmail(String email) {
    	return this.clientrepos.findByEmail(email);
    }
}
