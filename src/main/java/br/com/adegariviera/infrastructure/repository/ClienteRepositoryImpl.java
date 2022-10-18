package br.com.adegariviera.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.adegariviera.domain.model.Cliente;
import br.com.adegariviera.domain.repository.ClienteRepository;

public class ClienteRepositoryImpl implements ClienteRepository
{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> listar() 
	{
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@Override
	public Cliente buscar(Long id) 
	{
		return manager.find(Cliente.class, id);
	}

	@Transactional
	@Override
	public Cliente salvar(Cliente cliente) 
	{
		return manager.merge(cliente);
	}

	@Transactional
	@Override
	public void remover(Cliente cliente) 
	{
		cliente = buscar(cliente.getId());
		manager.remove(cliente);
	}
	
}
