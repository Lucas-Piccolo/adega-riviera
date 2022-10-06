package br.com.adegariviera.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Produto 
{
	@Id
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@Column(name = "preco_Compra")
	private BigDecimal precoCompra;
	
	@Column(name = "preco_Venda")
	private BigDecimal precoVenda;
	
	@Column(name = "qtd_Estoque")
	private Integer qtdEstoque;
	
	@Column(name = "qtd_Vendido")
	private Integer qtdVendido;

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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
}
