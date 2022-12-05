package manipulaArquivos;

import java.io.IOException;
import java.util.Scanner;

public class Cadastro {
	private Scanner leitorS = new Scanner (System.in); 
	private Scanner leitor = new Scanner (System.in); 

	
	public void cadastrarAluno(String caminho, Estudante est){
		try {
			String dado = "";
			System.out.println("\n::. Cadastro do Aluno .::");
			System.out.print("\nInsira o nome: ");
			est.setNome(leitorS.next());
			dado = "\nNome: " + est.getNome() ;
			ManipuladorArquivos.writer(caminho, dado);
			System.out.print("Insira o telefone: ");
			est.setTel(leitor.nextInt());
			dado = "Tel: " + est.getTel();
			ManipuladorArquivos.writer(caminho, dado);
			System.out.print("Insira a idade: ");
			est.setIdade(leitorS.nextInt());
			dado = "Idade: " + est.getIdade();
			ManipuladorArquivos.writer(caminho, dado);
			System.out.print("Insira o RA: ");
			est.setRA(leitorS.nextInt());
			dado = "RA: " + est.getRA();
			ManipuladorArquivos.writer(caminho, dado);
			System.out.print("Insira a turma: ");
			est.setTurma(leitorS.nextInt());
			dado = "Turma: " + est.getTurma() + "\n";
			ManipuladorArquivos.writer(caminho, dado);
		}catch(IOException e) {
			System.out.println("\nerro ao acessar arquivo");
		}catch(Exception e) {
			System.out.println("\nerro");

		}
		
	}
	
	public void lerArquivo(String caminho) {
		try {
			System.out.println("\n.::Imprimindo Arquivo.::");
			ManipuladorArquivos.reader(caminho);

		}catch(IOException e) {
			System.out.println("\nerro ao acessar arquivo");
		}catch(Exception e) {
			System.out.println("\nerro");
		}
	}
}
