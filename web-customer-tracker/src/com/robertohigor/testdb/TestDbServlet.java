package com.robertohigor.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 * @author Higor
 *
 *Classe responsável por testar a conexão com o banco de dados.
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// variáveis de conexão
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Conectar ao banco de dados
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCESS!!!");
			
			myConn.close();			
		}catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}finally {
			
		}
	}

}
