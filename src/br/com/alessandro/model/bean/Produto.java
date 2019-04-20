package br.com.alessandro.model.bean;

public class Produto {
    private int id_produto;
    private String nome;
    private String marca;
    private int quantidade;
    private int fornecedor_FK;
    private String nomefantasia;

    public Produto() {
    }

    public int getId_produto() {
        return this.id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFornecedor_FK() {
        return this.fornecedor_FK;
    }

    public void setFornecedor_FK(int fornecedor_FK) {
        this.fornecedor_FK = fornecedor_FK;
    }

    public String getNomefantasia() {
        return this.nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }
}
