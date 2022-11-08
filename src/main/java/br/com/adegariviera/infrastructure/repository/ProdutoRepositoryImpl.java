package br.com.adegariviera.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.adegariviera.domain.model.Produto;
import br.com.adegariviera.domain.repository.ProdutoRepository;

public class ProdutoRepositoryImpl implements ProdutoRepository
{
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Produto> listar() 
	{
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}

	@Override
	public Produto buscar(Long id) 
	{
		return manager.find(Produto.class, id);
	}

	@Override
	public Produto salvar(Produto produto) 
	{
		return manager.merge(produto);
	}

	@Override
	public Produto editar(Produto produto) 
	{
	// TODO criar lógica para editar um produto
		return null;
	}

	@Override
	public void remover(Produto produto) 
	{
		produto = buscar(produto.getId());
		manager.remove(produto);
	}
	
}
