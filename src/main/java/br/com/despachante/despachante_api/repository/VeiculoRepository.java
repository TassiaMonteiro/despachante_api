package br.com.despachante.despachante_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByPlaca(String placa);

}
