package br.com.tlp4.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@SequenceGenerator(name = "seq", sequenceName = "seq_aluno", allocationSize = 1, initialValue = 1)
public class Aluno {
	
	@Id
	@GeneratedValue(generator="seq")
	private Long idAluno;
	private String nome;
	private String cpf;
	private String ra;
	private Date nascimento;
	private boolean estaVinculado;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;	
	
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public boolean isEstaVinculado() {
		return estaVinculado;
	}
	public void setEstaVinculado(boolean estaVinculado) {
		this.estaVinculado = estaVinculado;
	}
	
	
}
