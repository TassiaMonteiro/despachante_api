package br.com.despachante.despachante_api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.despachante.despachante_api.controller.form.VeiculoForm;
import br.com.despachante.despachante_api.modelo.Veiculo;
import br.com.despachante.despachante_api.repository.ClienteRepository;
import br.com.despachante.despachante_api.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Veiculo> listarVeiculo(String placa) {
		if (placa == null) {
			List<Veiculo> veiculos = veiculoRepository.findAll();
			return veiculos;
		} else {
			List<Veiculo> veiculos = veiculoRepository.findByPlaca(placa);
			return veiculos;
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody @Valid VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = veiculoForm.converter(clienteRepository);
		veiculoRepository.save(veiculo);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getVeiculoId()).toUri();
		return ResponseEntity.created(uri).body(veiculo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> detalharVeiculo(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(veiculo.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Veiculo> editarVeiculo(@PathVariable Long id, @RequestBody VeiculoForm veiculoForm){
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if (optional.isPresent()) {
			Veiculo veiculo = veiculoForm.editar(id, veiculoRepository, clienteRepository);
			return ResponseEntity.ok(veiculo);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerVeiculo(@PathVariable Long id){
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if (optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
