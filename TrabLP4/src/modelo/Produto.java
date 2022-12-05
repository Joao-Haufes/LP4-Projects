package modelo;
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
	private int idProduto;
	
	@Column
	private String nome;
	
	@Column
	private double valor;
	
	@Column
	private double saldoEstoque;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
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

	public Produto(int idProduto, String nome, double valor, double saldoEstoque) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.valor = valor;
		this.saldoEstoque = saldoEstoque;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
