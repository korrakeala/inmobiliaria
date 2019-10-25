package ar.com.ada.api.inmobiliaria.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.Usuario;


/**
 * JWTUserDetailsService
 */
@Service
public class JWTUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario u = usuarioService.buscarPorId(username);

        if (u != null) {
            return new User(u.getUserName(), u.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

	public UserDetails loadUserByUsername(Object username) {
		return null;
	}

}