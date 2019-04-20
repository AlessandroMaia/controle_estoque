package br.com.alessandro.view.produto;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;
import br.com.alessandro.model.bean.Produto;
import br.com.alessandro.model.dao.ProdutoDAO;

public class TelaNovoProdutoController implements Initializable {
    TelaInicial ti = new TelaInicial();
    Produto produtos = new Produto();
    Fornecedor fornecedor = new Fornecedor();
    @FXML
    private TextField lblNome;
    @FXML
    private TextField lblMarca;
    @FXML
    private ComboBox<Produto> nome_forn_em_produto;
    @FXML
    private TextField lblQuantidade;

    public TelaNovoProdutoController() {
    }

    public void initialize(URL url, ResourceBundle rs) {
        this.CBnome();
    }

    @FXML
    void btnCadastrarProduto(ActionEvent event) {
        Alert a;
        if (this.lblNome.getText().isEmpty() && this.lblMarca.getText().isEmpty() && this.lblQuantidade.getText().isEmpty() && this.nome_forn_em_produto.getSelectionModel().getSelectedItem() == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos!");
            a.show();
        } else if (this.lblNome.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo nome!");
            a.show();
        } else if (this.lblMarca.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo marca!");
            a.show();
        } else if (this.lblQuantidade.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo quantidade!");
            a.show();
        } else if (this.nome_forn_em_produto.getSelectionModel().getSelectedItem() == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione uma opção válida!");
            a.show();
        } else {
            this.produtos.setNome(this.lblNome.getText());
            this.produtos.setMarca(this.lblMarca.getText());
            this.produtos.setQuantidade(Integer.parseInt(this.lblQuantidade.getText()));
            this.produtos.setNomefantasia(String.valueOf(((Produto)this.nome_forn_em_produto.getValue()).toString()));
            ProdutoDAO.inserirProduto(this.produtos);
            TelaNovoProduto.getStage().close();

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaNovoProdutoController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    public void CBnome() {
        this.nome_forn_em_produto.setItems(this.atualizaCombo());
    }

    public ObservableList<Produto> atualizaCombo() {
        return FXCollections.observableArrayList(ProdutoDAO.ComboBox());
    }

    @FXML
    void btnCancelarProduto(ActionEvent event) {
        TelaNovoProduto.getStage().close();

        try {
            this.ti.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(TelaNovoProdutoController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
