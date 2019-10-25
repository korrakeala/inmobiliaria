package ar.com.ada.api.inmobiliaria.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Locatario;
import ar.com.ada.api.inmobiliaria.entities.Usuario;
import ar.com.ada.api.inmobiliaria.interfaces.ITieneUsuario;
import ar.com.ada.api.inmobiliaria.repo.UsuarioRepository;
import ar.com.ada.api.inmobiliaria.security.Crypto;

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

    public Usuario crearUsuario(String password, String email, ITieneUsuario tieneUsuario, String estadoUsuario, Date fechaAltaUsuario) {
        Usuario u = new Usuario();
        u.setPassword(password);
        u.setEmail(email);
        u.setUsername(u.getEmail());
        u.setTipoUsuario(tieneUsuario.toString());
        Date f = new Date();
        u.setFechaAltaUsuario(f);
        u.setEstadoUsuario("Activo");


        repo.save(u);

        return u;

    }

    public Usuario buscarPorId(String username) {
        Optional<Usuario> u = repo.findById(username);
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

    public Usuario bajaUsuario(int id){

        Usuario u = this.buscarPorId(id);
        u.setEstadoUsuario("Baja");
        Date f = new Date();
        u.setFechaBajaUsuario(f);
        repo.save(u);

        return u;
    }

    private Usuario buscarPorId(int id) {
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }

	public int crearUsuario(ITieneUsuario password, String email, ITieneUsuario password2) {
		return 0;
	}

	public Usuario crearUsuario(String nombre, String dni, int edad, String password, String email, Locatario l,
			String estadoUsuario, Date fechaAltaUsuario) {
		return null;
	}
    public void login(String username, String password) {

        Usuario u = repo.findByUserName(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt((String) password, u.getUserName()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}