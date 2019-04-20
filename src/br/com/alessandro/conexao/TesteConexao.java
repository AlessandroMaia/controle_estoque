package br.com.alessandro.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public TesteConexao() {
    }

    public static void main(String[] args) throws SQLException {
        Connection con = Conexao.getConnection();
        System.out.println("Conectado!");
        con.close();
    }
}
