package br.com.despachante.despachante_api.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
