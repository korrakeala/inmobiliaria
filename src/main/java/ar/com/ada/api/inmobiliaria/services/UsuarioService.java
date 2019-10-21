package ar.com.ada.api.inmobiliaria.services;

import java.util.Optional;

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

    public void crearUsuario(String userName, String password, String email) {
        Usuario user = new Usuario();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        userRepo.save(user);

    }

    public Usuario buscarPorId(int id){
        Optional<Usuario> u = userRepo.findById(id);
        
        if (u.isPresent())
            return u.get();
        return null;

    }

}