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
import br.com.alessandro.model.bean.Fornecedor;

public class FornecedorDAO {
    public FornecedorDAO() {
    }

    public static void inserirForn(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (razaosocial, nomefantasia, cnpj_cpf, ie, endereco, cep,bairro, estado, telefone, pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getRazaosocial());
            stmt.setString(2, fornecedor.getNomefantasia());
            stmt.setString(3, fornecedor.getCnpj_cpf());
            stmt.setString(4, fornecedor.getIe());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getCep());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getEstado());
            stmt.setString(9, fornecedor.getTelefone());
            stmt.setString(10, fornecedor.getPessoa());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE,null, e);
        }
    }

    public List<Fornecedor> getList() {
        List<Fornecedor> fornecedores = new ArrayList();
        String sql = "SELECT * FROM fornecedor";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setId_fornecedor(rs.getInt("id_fornecedor"));
                forn.setRazaosocial(rs.getNString("razaosocial"));
                forn.setNomefantasia(rs.getString("nomefantasia"));
                forn.setCnpj_cpf(rs.getString("cnpj_cpf"));
                forn.setIe(rs.getNString("ie"));
                forn.setEndereco(rs.getNString("endereco"));
                forn.setCep(rs.getNString("cep"));
                forn.setBairro(rs.getNString("bairro"));
                forn.setEstado(rs.getNString("estado"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setPessoa(rs.getString("pessoa"));
                fornecedores.add(forn);
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return fornecedores;
    }

    public boolean deletarForn(Fornecedor fornecedor) {
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, fornecedor.getId_fornecedor());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean alteraForn(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET razaosocial = ?, nomefantasia = ?, cnpj_cpf = ?, ie = ?, endereco = ?, cep = ?, bairro = ?, estado = ?, telefone = ?, pessoa = ? WHERE id_fornecedor = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getRazaosocial());
            stmt.setString(2, fornecedor.getNomefantasia());
            stmt.setString(3, fornecedor.getCnpj_cpf());
            stmt.setString(4, fornecedor.getIe());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getCep());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getEstado());
            stmt.setString(9, fornecedor.getTelefone());
            stmt.setString(10, fornecedor.getPessoa());
            stmt.setInt(11, fornecedor.getId_fornecedor());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}

