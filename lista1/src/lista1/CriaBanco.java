package lista1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriaBanco {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String pwd = "aluno";

		try {
			Connection conexao = DriverManager.getConnection(url,user,pwd);
			Statement statement = conexao.createStatement();
			String bd = "Banco";
			String criaBanco = "CREATE DATABASE IF NOT EXISTS " + bd;
			statement.executeUpdate(criaBanco);
			
			criaBanco = "USE " + bd;
			statement.executeUpdate(criaBanco);			
			
			String criaTabela = "CREATE TABLE IF NOT EXISTS produtos (codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT, produto VARCHAR(45), preco BIGINT, cidade VARCHAR(45));";
			statement.executeUpdate(criaTabela);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}