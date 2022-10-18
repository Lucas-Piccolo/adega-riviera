package br.com.adegariviera.domain.repository;

import java.util.List;

import br.com.adegariviera.domain.model.Pedido;

public interface PedidoRepository 
{
	List<Pedido> listar();
	Pedido buscar(Long id);
	Pedido salvar(Pedido pedido);
}
