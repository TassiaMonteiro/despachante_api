package br.com.despachante.despachante_api.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.despachante.despachante_api.modelo.Protocolo;

public class ProtocoloDto {

	private Long protocoloId;
	private String servicos;
	private BigDecimal valorRecebido;
	private LocalDate dataAquisicao;
	private LocalDate dataRegistro;
	private LocalDate dataEntrega;
	private String situacao;
	private String nomeVendedor;
	private String documentoVendedor;
	private String observacoes;
	private Long veiculoId;
	private String placa;
	private Long clienteId;
	private String nomeCliente;
	private Long usuarioId;
	private String nomeUsuario;

	public ProtocoloDto(Protocolo protocolo) {
		this.protocoloId = protocolo.getProtocoloId();
		this.servicos = protocolo.getServicos();
		this.valorRecebido = protocolo.getValorRecebido();
		this.dataAquisicao = protocolo.getDataAquisicao();
		this.dataRegistro = protocolo.getDataRegistro();
		this.dataEntrega = protocolo.getDataEntrega();
		this.situacao = protocolo.getSituacao();
		this.nomeVendedor = protocolo.getNomeVendedor();
		this.documentoVendedor = protocolo.getDocumentoVendedor();
		this.observacoes = protocolo.getObservacoes();
		this.veiculoId = protocolo.getVeiculo().getVeiculoId();
		this.placa = protocolo.getVeiculo().getPlaca();
		this.clienteId = protocolo.getVeiculo().getCliente().getClienteId();
		this.nomeCliente = protocolo.getVeiculo().getCliente().getNome();
		this.usuarioId = protocolo.getUsuario().getUsuarioId();
		this.nomeUsuario = protocolo.getUsuario().getNome();
	}

	public Long getProtocoloId() {
		return protocoloId;
	}

	public String getServicos() {
		return servicos;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public String getDocumentoVendedor() {
		return documentoVendedor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public String getPlaca() {
		return placa;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public static List<ProtocoloDto> converter(List<Protocolo> protocolos) {
		return protocolos.stream().map(ProtocoloDto::new).collect(Collectors.toList());
	}

}
