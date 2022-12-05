package Main;

import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDAO;
import Modelo.Produto;

public class Main {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		
		// ADICIONANDO VALORES AO PRODUTO.
		produto.setNome("ESP8266");
		produto.setValor(25);
		produto.setSaldoEstoque(20);
		
		//PERSISTINDO PRODUTO NO BANCO DE DADOS.
		ProdutoDAO produtoDAO;
		try {
			produtoDAO = new ProdutoDAO();
			produtoDAO.adicionar(produto);
			System.out.println("Produto salvo com sucesso.");
		} catch (SQLException e) {
			System.out.println("ERRO ao salvar o produto.");
			System.err.print("ERRO:");
			e.printStackTrace();
		}
		
		//MOSTRANDO OS INTENS NO BANCO DE DADOS
		try {
			produtoDAO = new ProdutoDAO();
			List<Produto> produtoLista = produtoDAO.mostarProdutos();
			for(Produto p:produtoLista) {
				System.out.println("\nID: " + p.getIdProduto());
				System.out.println("Nome: " + p.getNome());
				System.out.println("Valor: " + p.getValor());
				System.out.println("Saldo estoque: " + p.getSaldoEstoque());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// TROCANDO VALORES DO PRODUTO.
		produto.setIdProduto(1l);
		produto.setNome("ESP8266-2");
		produto.setValor(35);
		produto.setSaldoEstoque(5);
		
		//ALTERANDO PRODUTO NO BANCO DE DADOS.
		try {
			produtoDAO = new ProdutoDAO();
			produtoDAO.alterar(produto);
			System.out.println("Produto alterado com sucesso.");
		} catch (SQLException e) {
			System.out.println("ERRO ao alterar o produto.");
			System.err.print("ERRO:");
			e.printStackTrace();
		}
		
		//MOSTRANDO OS INTENS NO BANCO DE DADOS
		try {
			produtoDAO = new ProdutoDAO();
			List<Produto> produtoLista = produtoDAO.mostarProdutos();
			for(Produto p:produtoLista) {
				System.out.println("\nID: " + p.getIdProduto());
				System.out.println("Nome: " + p.getNome());
				System.out.println("Valor: " + p.getValor());
				System.out.println("Saldo estoque: " + p.getSaldoEstoque());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// INFORMANDO O PRODUTO À SER REMOVIDO.
		produto.setIdProduto(1l);
		
		//DELETANDO PRODUTO NO BANCO DE DADOS.
		try {
			produtoDAO = new ProdutoDAO();
			produtoDAO.deletar(produto);
			System.out.println("Produto deletado com sucesso.");
		} catch (SQLException e) {
			System.out.println("ERRO ao deletar o produto.");
			System.err.print("ERRO:");
			e.printStackTrace();
		}
		
		//MOSTRANDO OS INTENS NO BANCO DE DADOS
		try {
			produtoDAO = new ProdutoDAO();
			List<Produto> produtoLista = produtoDAO.mostarProdutos();
			for(Produto p:produtoLista) {
				System.out.println("\nID: " + p.getIdProduto());
				System.out.println("Nome: " + p.getNome());
				System.out.println("Valor: " + p.getValor());
				System.out.println("Saldo estoque: " + p.getSaldoEstoque());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
