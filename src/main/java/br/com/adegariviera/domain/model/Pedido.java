package br.com.adegariviera.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido 
{
	@Id
	private Long id;
	
	private Date data;
	
	private Cliente cliente;
	
	// TODO Colocar list de produtos
	
	@Column(name = "valor_Total")
	private BigDecimal valorTotal;
	
	@Column(name = "qtd_Produtos")
	private Integer qtdProdutos;
	
	@Column(name = "taxa_Entrega")
	private BigDecimal taxaEntrega;

	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
