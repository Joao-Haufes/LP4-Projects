package manipulaArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivos {
	
	public static void writer(String caminho, String dado) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter (caminho, true));
		String linha = dado;

		
		escritor.append(linha + "\n");
		escritor.close();
	}
	public static void reader(String caminho) throws IOException {
		BufferedReader leitor = new BufferedReader(new FileReader (caminho));
		String linha = "";

		while(linha != null) {
			System.out.println(linha);
			linha = leitor.readLine();
		}
		leitor.close();
	}
}