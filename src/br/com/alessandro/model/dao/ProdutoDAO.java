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
import br.com.alessandro.model.bean.Produto;

public class ProdutoDAO {
    public ProdutoDAO() {
    }

    public static boolean inserirProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, marca, quantidade, nomefantasia) VALUES (?, ?, ?, ?)";
        String sql2 = "UPDATE produto p JOIN fornecedor f ON p.nomefantasia = f.nomefantasia SET p.fornecedor_FK = f.id_fornecedor";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getNomefantasia());
            stmt.executeUpdate();

            con.close();
            stmt.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, e);
            return false;
        }
    }

    public static List<Produto> getList() {
        List<Produto> produtos = new ArrayList();
        String sql = "SELECT p.id_produto, p.nome, p.marca, p.quantidade, p.fornecedor_FK, f.nomefantasia FROM produto p inner join fornecedor f on f.id_fornecedor = p.fornecedor_FK";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto pro = new Produto();
                pro.setId_produto(rs.getInt("id_produto"));
                pro.setNome(rs.getString("nome"));
                pro.setMarca(rs.getString("marca"));
                pro.setQuantidade(rs.getInt("quantidade"));
                pro.setFornecedor_FK(rs.getInt("fornecedor_FK"));
                pro.setNomefantasia(rs.getString("nomefantasia"));
                produtos.add(pro);
            }

            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public static List<Produto> ComboBox() {
        List<Produto> prod = new ArrayList();
        String sql = "SELECT nomefantasia FROM fornecedor";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Produto produ = new Produto();
                produ.setNomefantasia(rs.getString("nomefantasia"));
                prod.add(produ);
            }

            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, e);
        }

        return prod;
    }

    public boolean deletarPro(Produto produto) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getId_produto());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;

        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public static boolean alterarPro(Produto produto) {
        String sql = "UPDATE funcionario SET nome = ?, marca = ?, quantidade = ?, nomefantasia = ? WHERE id_produto = ?";

        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(5, produto.getId_produto());
            stmt.executeUpdate();

            Conexao.closeConnection(con, stmt);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
