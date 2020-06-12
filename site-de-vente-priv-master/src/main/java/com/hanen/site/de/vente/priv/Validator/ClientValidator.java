package com.hanen.site.de.vente.priv.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.services.ClientService;

@Component
public class ClientValidator implements Validator {
    @Autowired
    private ClientService clientService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (client.getEmail().length() < 6 || client.getEmail().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (clientService.findByEmail(client.getEmail()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (client.getMdp().length() < 8 || client.getMdp().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }


    }
}