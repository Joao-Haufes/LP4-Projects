package manipulaArquivos;

public class Teste {
	static String caminho = "/Users/joao Pedro/eclipse-workspace/Workplace LP3/src/manipulaArquivos/arquivo.txt";


	public static void main (String []args) {
		Estudante estudante1 = new Estudante();
		Estudante estudante2 = new Estudante();
		Estudante estudante3 = new Estudante();

		Cadastro start = new Cadastro();

		start.cadastrarAluno(caminho, estudante1);
		start.cadastrarAluno(caminho, estudante2);
		start.cadastrarAluno(caminho, estudante3);
		
		start.lerArquivo(caminho);
		
	}
}
