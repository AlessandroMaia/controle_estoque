package br.com.alessandro.view.funcionario;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Funcionario;
import br.com.alessandro.model.dao.FuncionarioDAO;

public class TelaAlterarFuncionarioController implements Initializable {
    FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();
    TelaInicial ti = new TelaInicial();
    @FXML
    private TextField lblAlteraNome;
    @FXML
    private TextField lblAlteraCpf;
    @FXML
    private TextField lblAlteraDtNasc;
    @FXML
    private TextField lblAlteraEndereco;
    @FXML
    private TextField lblAlteraBairro;
    @FXML
    private TextField lblAlteraTelefone;
    @FXML
    private RadioButton checkMasc;
    @FXML
    private RadioButton checkFem;
    @FXML
    private TextField lblAlteraLogin;
    @FXML
    private PasswordField lblAlteraSenha;
    @FXML
    private TextField lblAlteraEstado;
    @FXML
    private TextField lblAlteraCep;
    @FXML
    private Label lblVerID;
    public static Funcionario func;
    public String sexo;

    public TelaAlterarFuncionarioController() {
    }

    public static Funcionario getFunc() {
        return func;
    }

    public static void setFunc(Funcionario aFunc) {
        func = aFunc;
    }

    @FXML
    void checkFemA(ActionEvent event) {
        this.sexo = "F";
        this.checkMasc.setSelected(false);
    }

    @FXML
    void checkMascA(ActionEvent event) {
        this.sexo = "M";
        this.checkFem.setSelected(false);
    }

    @FXML
    void btnAlterarFuncionario(ActionEvent event) {
        Alert a;
        if (this.lblAlteraNome.getText().isEmpty() && this.lblAlteraCpf.getText().isEmpty() && this.lblAlteraEndereco.getText().isEmpty() && this.lblAlteraBairro.getText().isEmpty() && this.lblAlteraTelefone.getText().isEmpty() && this.lblAlteraEstado.getText().isEmpty() && this.lblAlteraLogin.getText().isEmpty() && this.lblAlteraSenha.getText().isEmpty() && this.lblAlteraCep.getText().isEmpty() && this.lblAlteraDtNasc.getText().isEmpty() && this.sexo == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos para alterar cadastro!");
            a.show();
        } else if (this.lblAlteraNome.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo nome!");
            a.show();
        } else if (this.lblAlteraCpf.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CPF!");
            a.show();
        } else if (this.lblAlteraEndereco.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Endereco!");
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
        } else if (this.lblAlteraLogin.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Login!");
            a.show();
        } else if (this.lblAlteraSenha.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Senha!");
            a.show();
        } else if (this.lblAlteraCep.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CEP!");
            a.show();
        } else if (this.lblAlteraDtNasc.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Data de Nascimento!");
            a.show();
        } else if (this.sexo == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, Selecione a opção do sexo!");
            a.show();
        } else {
            this.funcionario.setId_funcionario(getFunc().getId_funcionario());
            this.funcionario.setNome(this.lblAlteraNome.getText());
            this.funcionario.setCpf(this.lblAlteraCpf.getText());
            this.funcionario.setEndereco(this.lblAlteraEndereco.getText());
            this.funcionario.setBairro(this.lblAlteraBairro.getText());
            this.funcionario.setTelefone(this.lblAlteraTelefone.getText());
            this.funcionario.setLogin(this.lblAlteraLogin.getText());
            this.funcionario.setEstado(this.lblAlteraEstado.getText());
            this.funcionario.setCep(this.lblAlteraCep.getText());
            this.funcionario.setSenha(this.lblAlteraSenha.getText());
            this.funcionario.setData(Date.valueOf(this.lblAlteraDtNasc.getText()));
            this.funcionario.setSexo(this.sexo);
            this.FuncionarioDAO.alterarFunc(this.funcionario);
            TelaAlterarFuncionario.getStage().close();

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaAlterarFuncionarioController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @FXML
    void btnCancelarAlterar(ActionEvent event) {
        TelaAlterarFuncionario.getStage().close();

        try {
            this.ti.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(TelaAlterarFuncionarioController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void initiFunc() {
        this.lblAlteraNome.setText(getFunc().getNome());
        this.lblAlteraCpf.setText(getFunc().getCpf());
        this.lblAlteraEndereco.setText(getFunc().getEndereco());
        this.lblAlteraBairro.setText(getFunc().getBairro());
        this.lblAlteraTelefone.setText(getFunc().getTelefone());
        this.lblAlteraLogin.setText(getFunc().getLogin());
        this.lblAlteraEstado.setText(getFunc().getEstado());
        this.lblAlteraCep.setText(getFunc().getCep());
        this.lblAlteraSenha.setText(getFunc().getSenha());
        this.lblAlteraDtNasc.setText(String.valueOf(getFunc().getData()));
        String var1 = func.getSexo();

        byte var2 = 0;

        if (var1.equals("F")) {
            var2 = 0;
        }

        if (var1.equals("M")) {
            var2 = 1;
        }

        switch(var2) {
            case 0:
                this.checkFem.setSelected(true);
                break;
            case 1:
                this.checkMasc.setSelected(true);
                break;
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        this.initiFunc();
    }
}

