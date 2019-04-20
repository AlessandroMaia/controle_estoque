package br.com.alessandro.view.produto;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Produto;
import br.com.alessandro.model.dao.ProdutoDAO;

public class TelaAlterarProdutoController implements Initializable {
    @FXML
    private TextField lblAlteraNome;
    @FXML
    private TextField lblAlteraMarca;
    @FXML
    private TextField Altera_nome_forn_em_produto;
    @FXML
    private TextField lblAlteraQuantidade;
    @FXML
    private Label lblID;
    @FXML
    private Label lblIDforn;
    public static Produto prod;
    TelaInicial ti = new TelaInicial();
    Produto produtos = new Produto();

    public TelaAlterarProdutoController() {
    }

    public static Produto getProdu() {
        return prod;
    }

    public static void setProdu(Produto aProd) {
        prod = aProd;
    }

    @FXML
    void btnAlterarProduto(ActionEvent event) {
        Alert a;
        if (this.lblAlteraNome.getText().isEmpty() && this.lblAlteraMarca.getText().isEmpty() && this.lblAlteraQuantidade.getText().isEmpty() && this.Altera_nome_forn_em_produto.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos!");
            a.show();
        } else if (this.lblAlteraNome.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo nome!");
            a.show();
        } else if (this.lblAlteraMarca.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo marca!");
            a.show();
        } else if (this.lblAlteraQuantidade.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo quantidade!");
            a.show();
        } else if (this.Altera_nome_forn_em_produto.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione uma opção válida!");
            a.show();
        } else {
            this.produtos.setNome(this.lblAlteraNome.getText());
            this.produtos.setMarca(this.lblAlteraMarca.getText());
            this.produtos.setQuantidade(Integer.parseInt(this.lblAlteraQuantidade.getText()));
            this.produtos.setNomefantasia(this.Altera_nome_forn_em_produto.getText());
            ProdutoDAO.alterarPro(this.produtos);

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaAlterarProdutoController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    public void initiAlteraProduto() {
        this.lblID.setText(String.valueOf(getProdu().getId_produto()));
        this.lblAlteraMarca.setText(getProdu().getMarca());
        this.lblAlteraNome.setText(getProdu().getNome());
        this.lblAlteraQuantidade.setPrefColumnCount(getProdu().getQuantidade());
        this.Altera_nome_forn_em_produto.setText(getProdu().getNomefantasia());
        this.lblIDforn.setText(String.valueOf(getProdu().getFornecedor_FK()));
    }

    @FXML
    void btnCancelarAlterarProduto(ActionEvent event) {
        try {
            this.ti.start(new Stage());
            TelaAlterarProduto.getStage().close();
        } catch (Exception e) {
            Logger.getLogger(TelaAlterarProdutoController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void initialize(URL url, ResourceBundle rs) {
        this.initiAlteraProduto();
    }
}

