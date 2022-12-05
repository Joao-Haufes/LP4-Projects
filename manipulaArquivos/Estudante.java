package manipulaArquivos;

public class Estudante {
	
	private String Nome;
	private int Tel; 
	private int Idade; 
	private int RA; 
	private int Turma;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		this.Tel = tel;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		this.Idade = idade;
	}
	public int getRA() {
		return RA;
	}
	public void setRA(int RA) {
		this.RA = RA;
	}
	public int getTurma() {
		return Turma;
	}
	public void setTurma(int turma) {
		this.Turma = turma;
	}
}