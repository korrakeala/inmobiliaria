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
    UsuarioRepository repo;

    public void grabar(Usuario u) {
        this.repo.save(u);
    }

    public Usuario crearUsuario(String userName, String password, String email, String tipoUsuario) {
        Usuario u = new Usuario();
        u.setUsername(userName);
        u.setPassword(password);
        u.setEmail(email);
        u.setTipoUsuario(tipoUsuario);
        repo.save(u);

        return u;

    }

    public Usuario buscarPorId(int id){
        Optional<Usuario> u = repo.findById(id);
        
        if (u.isPresent())
            return u.get();
        return null;

    }

}