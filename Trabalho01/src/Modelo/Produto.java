package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = "seq", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class Produto {

	@Id
	@GeneratedValue(generator="seq")
	private Long idProduto; 
	
	@Column
	private String nome;
	
	@Column
	private double valor;
	
	@Column
	private double saldoEstoque;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldoEstoque() {
		return saldoEstoque;
	}

	public void setSaldoEstoque(double saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}
	
}
