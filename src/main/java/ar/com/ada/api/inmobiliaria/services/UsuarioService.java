package ar.com.ada.api.inmobiliaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.repo.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository userRepo;

    public void grabar(Usuario user) {
        this.userRepo.save(user);
    }

    public void CrearUser(String userName, String password, String email) {
        Usuario user = new Usuario();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        userRepo.save(user);

    }

}