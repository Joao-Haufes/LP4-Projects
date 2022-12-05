package br.com.tlp4.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "curso")
@SequenceGenerator(name = "seq", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class Curso {

	@Id
	@GeneratedValue(generator="seq")
	private Long idCurso; 
	
	@Column
	private String nome;
	
	@Column
	private int quantidadeVagas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="curso")	
	private List<Aluno> alunos;
	
	public Curso() {
		super();
	}

	public Curso(String nome, int quantidadeVagas) {
		super();
		this.nome = nome;
		this.quantidadeVagas = quantidadeVagas;
	}
	
	public Long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}
	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  nome;
	}
	
}
