package br.com.despachante.despachante_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
