package br.com.adegariviera.domain.repository;

import java.util.List;

import br.com.adegariviera.domain.model.Cliente;

public interface ClienteRepository 
{
	List<Cliente> listar();
	Cliente buscar(Long id);
	Cliente salvar(Cliente cliente);
	void remover(Cliente cliente);
}
