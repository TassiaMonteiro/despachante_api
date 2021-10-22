package br.com.despachante.despachante_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Protocolo;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long>  {

	List<Protocolo> findByVeiculoVeiculoId(Long veiculoId);

}
