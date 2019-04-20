package br.com.alessandro.model.dao;

import br.com.alessandro.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.alessandro.model.bean.Funcionario;

public class FuncionarioDAO {
    public FuncionarioDAO() {
    }

    public static void inserirFunc(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, endereco, bairro, telefone, estado, login, senha, sexo, cep, data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getBairro());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEstado());
            stmt.setString(7, funcionario.getLogin());
            stmt.setString(8, funcionario.getSenha());
            stmt.setString(9, funcionario.getSexo());
            stmt.setString(10, funcionario.getCep());
            stmt.setDate(11, funcionario.getData());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public List<Funcionario> getList() {
        List<Funcionario> funcionarios = new ArrayList();
        String sql = "SELECT * FROM funcionario";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId_funcionario(rs.getInt("id_funcionario"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setSexo(rs.getString("sexo"));
                func.setTelefone(rs.getString("telefone"));
                func.setBairro(rs.getNString("bairro"));
                func.setEndereco(rs.getNString("endereco"));
                func.setEstado(rs.getNString("estado"));
                func.setLogin(rs.getNString("login"));
                func.setCep(rs.getNString("cep"));
                func.setSenha(rs.getNString("senha"));
                func.setData(rs.getDate("data"));
                funcionarios.add(func);
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE,null, e);
        }
        return funcionarios;
    }

    public boolean alterarFunc(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, endereco = ?, bairro = ?, telefone = ?, estado = ?, login = ?, senha = ?, cep = ?, sexo = ?, data = ? WHERE id_funcionario = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getBairro());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEstado());
            stmt.setString(7, funcionario.getLogin());
            stmt.setString(8, funcionario.getSenha());
            stmt.setString(9, funcionario.getCep());
            stmt.setString(10, funcionario.getSexo());
            stmt.setDate(11, funcionario.getData());
            stmt.setInt(12, funcionario.getId_funcionario());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public boolean deletarFunc(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, funcionario.getId_funcionario());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean loginFunc(String login, String senha) {
        String sql = "SELECT * FROM funcionario WHERE login = ? AND senha = ?";
        Boolean check = false;

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rrs = stmt.executeQuery();

            if (rrs.next()) {
                check = true;
            }

            con.close();
            stmt.close();
            rrs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Error funcionario dao", e);
        }
        return check;
    }
}

