package com.espatula.principal.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.espatula.principal.security.enums.RolNombre;
import com.espatula.principal.security.model.Rol;
import com.espatula.principal.security.service.RolService;

@Component
public class CreateData implements CommandLineRunner {
	
    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
     /**Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolBan = new Rol(RolNombre.ROLE_BAN);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        rolService.save(rolBan);*/
    }

}
