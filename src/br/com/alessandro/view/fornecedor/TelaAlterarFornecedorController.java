package br.com.alessandro.view.fornecedor;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;
import br.com.alessandro.model.dao.FornecedorDAO;

public class TelaAlterarFornecedorController implements Initializable {
    Fornecedor fornecedor = new Fornecedor();
    FornecedorDAO fda = new FornecedorDAO();
    TelaInicial ti = new TelaInicial();

    @FXML
    private TextField lblAlteraRazaoSocial;
    @FXML
    private TextField lblAlteraNomeFantasia;
    @FXML
    private TextField lblAlteraCnpj;
    @FXML
    private TextField lblAlteraIe;
    @FXML
    private TextField lblAlteraEndereco;
    @FXML
    private TextField lblAlteraBairro;
    @FXML
    private TextField lblAlteraTelefone;
    @FXML
    private TextField lblAlteraEstado;
    @FXML
    private RadioButton checkPessoaJ;
    @FXML
    private RadioButton checkPessoaF;
    @FXML
    private TextField lblAlteraCep;
    private static Fornecedor forn1;
    private String pessoaforn;

    public TelaAlterarFornecedorController() {
    }

    public static Fornecedor getForn1() {
        return forn1;
    }

    public static void setForn1(Fornecedor aForn1) {
        forn1 = aForn1;
    }

    @FXML
    void checkPessoaFis(ActionEvent event) {
        this.pessoaforn = "Física";
        this.checkPessoaJ.setSelected(false);
    }

    @FXML
    void checkPessoaJur(ActionEvent event) {
        this.pessoaforn = "Júridica";
        this.checkPessoaF.setSelected(false);
    }

    @FXML
    void btnAlterarFornecedor(ActionEvent event) {
        Alert a;
        if (this.lblAlteraRazaoSocial.getText().isEmpty() && this.lblAlteraNomeFantasia.getText().isEmpty() && this.lblAlteraCnpj.getText().isEmpty() && this.lblAlteraIe.getText().isEmpty() && this.lblAlteraEndereco.getText().isEmpty() && this.lblAlteraBairro.getText().isEmpty() && this.lblAlteraTelefone.getText().isEmpty() && this.lblAlteraEstado.getText().isEmpty() && this.lblAlteraCep.getText().isEmpty() && this.pessoaforn == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos para cadastro!");
            a.show();
        } else if (this.lblAlteraRazaoSocial.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Razão Social!");
            a.show();
        } else if (this.lblAlteraNomeFantasia.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Nome Fantasia!");
            a.show();
        } else if (this.lblAlteraCnpj.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CNPJ!");
            a.show();
        } else if (this.lblAlteraIe.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo IE!");
            a.show();
        } else if (this.lblAlteraEndereco.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Endereço!");
            a.show();
        } else if (this.lblAlteraBairro.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Bairro!");
            a.show();
        } else if (this.lblAlteraTelefone.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Telefone!");
            a.show();
        } else if (this.lblAlteraEstado.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Estado!");
            a.show();
        } else if (this.lblAlteraCep.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CEP!");
            a.show();
        } else if (this.pessoaforn == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, Selelecione a opção de tipo de pessoa!");
            a.show();
        } else {
            this.fornecedor.setId_fornecedor(getForn1().getId_fornecedor());
            this.fornecedor.setRazaosocial(this.lblAlteraRazaoSocial.getText());
            this.fornecedor.setNomefantasia(this.lblAlteraNomeFantasia.getText());
            this.fornecedor.setCnpj_cpf(this.lblAlteraCnpj.getText());
            this.fornecedor.setIe(this.lblAlteraIe.getText());
            this.fornecedor.setEndereco(this.lblAlteraEndereco.getText());
            this.fornecedor.setBairro(this.lblAlteraBairro.getText());
            this.fornecedor.setTelefone(this.lblAlteraTelefone.getText());
            this.fornecedor.setEstado(this.lblAlteraEstado.getText());
            this.fornecedor.setCep(this.lblAlteraCep.getText());
            this.fornecedor.setPessoa(this.pessoaforn);
            this.fda.alteraForn(this.fornecedor);
            TelaAlterarFornecedor.getStage().close();

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaAlterarFornecedorController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void initiAlteForn() {
        this.lblAlteraRazaoSocial.setText(getForn1().getRazaosocial());
        this.lblAlteraNomeFantasia.setText(getForn1().getNomefantasia());
        this.lblAlteraCnpj.setText(getForn1().getCnpj_cpf());
        this.lblAlteraIe.setText(getForn1().getIe());
        this.lblAlteraEndereco.setText(getForn1().getEndereco());
        this.lblAlteraBairro.setText(getForn1().getBairro());
        this.lblAlteraTelefone.setText(getForn1().getTelefone());
        this.lblAlteraEstado.setText(getForn1().getEstado());
        this.lblAlteraCep.setText(getForn1().getCep());
        String var1 = forn1.getPessoa();
        int var2 = 0;

        if (var1.equals("Física")) {
            var2 = 0;
        }

        if (var1.equals("Júridica")) {
            var2 = 1;
        }

        switch(var2) {
            case 0:
                this.checkPessoaF.setSelected(true);
                break;
            case 1:
                this.checkPessoaJ.setSelected(true);
                break;
        }

    }

    @FXML
    void btnCancelarAlterarFornecedor(ActionEvent event) {
        TelaAlterarFornecedor.getStage().close();

        try {
            this.ti.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(TelaAlterarFornecedorController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        this.initiAlteForn();
    }
}
