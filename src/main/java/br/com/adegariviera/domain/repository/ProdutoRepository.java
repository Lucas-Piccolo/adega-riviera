package br.com.adegariviera.domain.repository;

import java.util.List;

import br.com.adegariviera.domain.model.Produto;

public interface ProdutoRepository 
{
	List<Produto> listar();
	Produto buscar(Long id);
	Produto salvar(Produto produto);
	Produto editar(Produto produto);
	void remover(Produto produto);
}
