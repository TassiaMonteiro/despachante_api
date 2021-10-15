package br.com.despachante.despachante_api.controller.form;

import br.com.despachante.despachante_api.modelo.Nivel;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.repository.NivelRepository;

public class UsuarioForm {

	private String nome;
	private String login;
	private String email;
	private String nomeNivel;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public Usuario converter(NivelRepository nivelRepository) {
		Nivel nivel = nivelRepository.findByNome(nomeNivel);
		return new Usuario(nome, login, email, nivel);
	}

}
