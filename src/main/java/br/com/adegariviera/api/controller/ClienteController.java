package br.com.adegariviera.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adegariviera.domain.model.Cliente;
import br.com.adegariviera.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController 
{
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar()
	{
		return clienteRepository.listar();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) 
	{
		Cliente cliente = clienteRepository.buscar(clienteId);
		
		if (cliente != null) 
		{
			return ResponseEntity.status(HttpStatus.OK).body(cliente);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public void adicionar (@RequestBody Cliente cliente) 
	{
		clienteRepository.salvar(cliente);
	}
	
	@DeleteMapping("/{cliente}")
	public void deletar (@PathVariable Cliente cliente) 
	{
		clienteRepository.remover(cliente);
	}
}
