package ar.com.ada.api.inmobiliaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;
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

    public Usuario crearUsuario(String password, String email, ITieneUsuario tieneUsuario) {
        Usuario u = new Usuario();
        u.setPassword(password);
        u.setEmail(email);
        u.setUsername(u.getEmail());
        u.setTipoUsuario(tieneUsuario.getClass().getName());
        repo.save(u);

        return u;

    }

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = repo.findById(id);
        if (u.isPresent())
            return u.get();
        return null;

    }

    public Usuario updateUsuario(int id, String userName, String email) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(userName);
        u.setEmail(email);
        repo.save(u);
        return u;
    }

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }
}
