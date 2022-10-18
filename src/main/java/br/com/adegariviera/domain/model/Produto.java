package br.com.adegariviera.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto 
{
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	private Categoria categoria;
}