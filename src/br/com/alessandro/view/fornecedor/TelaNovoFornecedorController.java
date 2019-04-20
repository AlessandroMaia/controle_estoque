package br.com.alessandro.view.fornecedor;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;
import br.com.alessandro.model.dao.FornecedorDAO;

public class TelaNovoFornecedorController {
    FornecedorDAO FornecedorDAO = new FornecedorDAO();
    Fornecedor fornecedor = new Fornecedor();
    TelaInicial ti = new TelaInicial();
    @FXML
    private TextField lblRazaoSocial;
    @FXML
    private TextField lblNomeFantasia;
    @FXML
    private TextField lblCnpj;
    @FXML
    private TextField lblIe;
    @FXML
    private TextField lblEnderecoForn;
    @FXML
    private TextField lblBairroForn;
    @FXML
    private TextField lblTelefoneForn;
    @FXML
    private TextField lblEstadoForn;
    @FXML
    private TextField lblCepForn;
    public String pessoa;

    public TelaNovoFornecedorController() {
    }

    @FXML
    void RadioPessoaFisica(ActionEvent event) {
        this.pessoa = "Física";
    }

    @FXML
    void RadioPessoaJuridica(ActionEvent event) {
        this.pessoa = "Júridica";
    }

    @FXML
    void btnCadastrarFornecedor(ActionEvent event) {
        Alert a;
        if (this.lblRazaoSocial.getText().isEmpty() && this.lblNomeFantasia.getText().isEmpty() && this.lblCnpj.getText().isEmpty() && this.lblIe.getText().isEmpty() && this.lblEnderecoForn.getText().isEmpty() && this.lblBairroForn.getText().isEmpty() && this.lblTelefoneForn.getText().isEmpty() && this.lblEstadoForn.getText().isEmpty() && this.lblCepForn.getText().isEmpty() && this.pessoa == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos para cadastro!");
            a.show();
        } else if (this.lblRazaoSocial.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Razão Social!");
            a.show();
        } else if (this.lblNomeFantasia.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Nome Fantasia!");
            a.show();
        } else if (this.lblCnpj.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CNPJ!");
            a.show();
        } else if (this.lblIe.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo IE!");
            a.show();
        } else if (this.lblEnderecoForn.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Endereço!");
            a.show();
        } else if (this.lblBairroForn.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Bairro!");
            a.show();
        } else if (this.lblTelefoneForn.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Telefone!");
            a.show();
        } else if (this.lblEstadoForn.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Estado!");
            a.show();
        } else if (this.lblCepForn.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CEP!");
            a.show();
        } else if (this.pessoa == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, Selelecione a opção de tipo de pessoa!");
            a.show();
        } else {
            this.fornecedor.setRazaosocial(this.lblRazaoSocial.getText());
            this.fornecedor.setNomefantasia(this.lblNomeFantasia.getText());
            this.fornecedor.setCnpj_cpf(this.lblCnpj.getText());
            this.fornecedor.setIe(this.lblIe.getText());
            this.fornecedor.setEndereco(this.lblEnderecoForn.getText());
            this.fornecedor.setBairro(this.lblBairroForn.getText());
            this.fornecedor.setTelefone(this.lblTelefoneForn.getText());
            this.fornecedor.setEstado(this.lblEstadoForn.getText());
            this.fornecedor.setCep(this.lblCepForn.getText());
            this.fornecedor.setPessoa(this.pessoa);
            br.com.alessandro.model.dao.FornecedorDAO.inserirForn(this.fornecedor);
            TelaNovoFornecedor.getStage().close();

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaNovoFornecedorController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @FXML
    void btnCancelarFornecedor(ActionEvent event) {
        TelaNovoFornecedor.getStage().close();

        try {
            this.ti.start(new Stage());
        } catch (Exception var3) {
            Logger.getLogger(TelaNovoFornecedorController.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }
}
