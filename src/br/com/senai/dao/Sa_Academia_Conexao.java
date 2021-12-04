package br.com.senai.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sa_Academia_Conexao {    
   
    public static Connection abrirConexao() throws Exception {
        Class.forName("org.postgresql.Driver");        
        return DriverManager.getConnection("jdbc:postgresql://localhost:5433/Academia", "postgres", "7923754z");
    }
}
