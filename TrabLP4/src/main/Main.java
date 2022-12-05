package main;

import java.sql.SQLException;
import dao.DAO;
import modelo.Produto;

public class Main{

	public static void main(String[] args) {
		Produto p = new Produto();

		p.setNome("Arroz");
		p.setValor(80.0);
		p.setSaldoEstoque(30);
		
		DAO dao;
		try {
			dao = new DAO();
			dao.adicionar(p);
			System.out.println("Produto salvo com sucesso.");
		} catch (SQLException ex) {
			System.out.println("Problemas ao salvar o produto.");
			ex.printStackTrace();
		}
	}
}