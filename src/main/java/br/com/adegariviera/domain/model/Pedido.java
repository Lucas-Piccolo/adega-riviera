package br.com.adegariviera.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
public class Pedido 
{
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date data;
	
	private Cliente cliente;
	
	private List<Produto> produtos;
	
	@Column(name = "valor_Total")
	private BigDecimal valorTotal;
	
	@Column(name = "qtd_Produtos")
	private Integer qtdProdutos;
	
	@Column(name = "taxa_Entrega")
	private BigDecimal taxaEntrega;
}