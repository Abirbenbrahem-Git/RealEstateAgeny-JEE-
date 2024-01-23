package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.client.Client;
public class GestionClient {

			public Connection connexionBase()
			{
			Connection con = null;
			String username = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/mabase?allowPublicKeyRetrieval=true&useSSL=false";
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println ("La connection avec la base de donnée est établie.");
			} catch (Exception e){
			System.out.print(e);
			}
			return con;
			}

			public Client connexionUtilisateur(String login, String pwd) {
				// TODO Auto-generated method stub
				return null;
			}
}
