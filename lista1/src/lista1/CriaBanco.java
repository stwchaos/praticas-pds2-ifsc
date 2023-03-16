package lista1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriaBanco {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/";
		String usuario = "root";
		String senha = "aluno";

		try {
			Connection conexao = DriverManager.getConnection(url,usuario,senha);
			Statement statement = conexao.createStatement();
			String bd = "Banco";
			String criaBanco = "CREATE DATABASE IF NOT EXISTS " + bd;
			statement.executeUpdate(criaBanco);
			
			criaBanco = "USE " + bd;
			statement.executeUpdate(criaBanco);			
			
			String criaTabela = "CREATE TABLE IF NOT EXISTS pessoa " + "usuario VARCHAR(100) NOT NULL " + "nome VARCHAR(100) "
					+ "PRIMARY KEY (usuario))";
			statement.executeUpdate(criaTabela);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}