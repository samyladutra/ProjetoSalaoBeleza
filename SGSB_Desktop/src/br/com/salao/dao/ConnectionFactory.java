package br.com.salao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection conexao;

	static {
		System.out.println("Conectando ao banco");
		try {
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/salao_de_beleza2", "root", "");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao SGBD");
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		return conexao;
	}

}
