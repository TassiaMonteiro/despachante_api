package br.com.despachante.despachante_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.despachante.despachante_api.controller.dto.UsuarioDto;
import br.com.despachante.despachante_api.controller.form.UsuarioForm;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.repository.NivelRepository;
import br.com.despachante.despachante_api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private NivelRepository nivelRepository;

	@GetMapping
	public List<UsuarioDto> listarUsuario() {
		List<Usuario> usuarios = usuarioRepository.findAll();	
		return UsuarioDto.converter(usuarios);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioForm.converter(nivelRepository);
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getUsuarioId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
}
