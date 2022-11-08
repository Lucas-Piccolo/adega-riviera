package br.com.adegariviera.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.adegariviera.domain.model.Pedido;
import br.com.adegariviera.domain.repository.PedidoRepository;

public class PedidoRepositoryImpl implements PedidoRepository
{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Pedido> listar() 
	{
		return manager.createQuery("from Pedido", Pedido.class).getResultList();
	}

	@Override
	public Pedido buscar(Long id) 
	{
		return manager.find(Pedido.class, id);
	}

	@Override
	public Pedido salvar(Pedido pedido) 
	{
		return manager.merge(pedido);
	}

}
