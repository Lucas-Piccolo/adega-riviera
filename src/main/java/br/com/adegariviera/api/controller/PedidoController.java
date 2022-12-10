package br.com.adegariviera.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adegariviera.domain.model.Pedido;
import br.com.adegariviera.domain.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController 
{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<Pedido> listar()
	{
		return pedidoRepository.listar();
	}
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long pedidoId)
	{
		Pedido pedido = pedidoRepository.buscar(pedidoId);
		
		if (pedido != null) 
		{
			return ResponseEntity.status(HttpStatus.OK).body(pedido);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public void salvar(@RequestBody Pedido pedido) 
	{
		pedidoRepository.salvar(pedido);
	}
}
