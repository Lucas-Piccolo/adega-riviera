package br.com.adegariviera.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.adegariviera.domain.model.Produto;
import br.com.adegariviera.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController 
{
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listar()
	{
		return produtoRepository.listar();
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId)
	{
		Produto produto = produtoRepository.buscar(produtoId);
		
		if (produto != null) 
		{
			return ResponseEntity.status(HttpStatus.OK).body(produto);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public void salvar (@RequestBody Produto produto) 
	{
		produtoRepository.salvar(produto);
	}
	
	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> editar (@PathVariable Long produtoId, @RequestBody Produto produto)
	{
		Produto produtoAtual = produtoRepository.buscar(produtoId);
		
		if (produtoAtual != null) 
		{
			BeanUtils.copyProperties(produto, produtoAtual, "id");
			
			produtoAtual = produtoRepository.salvar(produtoAtual);
			return ResponseEntity.ok(produtoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public void remover(Produto produto) 
	{
		produtoRepository.remover(produto);
	}
}
