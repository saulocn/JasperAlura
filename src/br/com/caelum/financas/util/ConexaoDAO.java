package br.com.caelum.financas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

//Cria a conexão com o banco Postgresql
public class ConexaoDAO {
	
	
	public ConexaoDAO() {
	}

	// Função que abre a conexão com o banco
	public static Connection abreConexao()  {
		
		
		Connection conexao = null;
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection("jdbc:postgresql://150.163.12.229/institucional_schema", "postgres",	"admin");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return conexao;

	}

	public static void fechaConexao(Connection conexao) {
		try {
			if(conexao != null)
			{
				conexao.close();
			}
			conexao = null;
		} catch (SQLException e) {
			System.out.println("Erro ao fechar a conexão. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
