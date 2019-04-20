package br.com.alessandro.view.funcionario;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Funcionario;
import br.com.alessandro.model.dao.FuncionarioDAO;

public class TelaNovoFuncionarioController {
    FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();
    TelaInicial ti = new TelaInicial();
    @FXML
    private Tab AbaFornecedor;
    @FXML
    private TextField lblFuncionarioNome;
    @FXML
    private TextField lblFuncionarioCPF;
    @FXML
    private DatePicker DataNascFuncionario;
    @FXML
    private TextField lblFuncionarioEndereco;
    @FXML
    private TextField lblFuncionarioBairro;
    @FXML
    private TextField lblFuncionarioTelefone;
    @FXML
    private TextField lblFuncionarioLogin;
    @FXML
    private PasswordField lblFuncionarioSenha;
    @FXML
    private TextField lblFuncionarioEstado;
    @FXML
    private TextField lblFuncionarioCEP;
    public String sexo;

    public TelaNovoFuncionarioController() {
    }

    @FXML
    void radioFuncFemSelecionado(ActionEvent event) {
        this.sexo = "F";
    }

    @FXML
    void radioFuncMascSelecionado(ActionEvent event) {
        this.sexo = "M";
    }

    @FXML
    public void btnCadastrarFuncionario(ActionEvent event) {
        Alert a;
        if (this.lblFuncionarioNome.getText().isEmpty() && this.lblFuncionarioCPF.getText().isEmpty() && this.lblFuncionarioEndereco.getText().isEmpty() && this.lblFuncionarioBairro.getText().isEmpty() && this.lblFuncionarioTelefone.getText().isEmpty() && this.lblFuncionarioEstado.getText().isEmpty() && this.lblFuncionarioLogin.getText().isEmpty() && this.lblFuncionarioSenha.getText().isEmpty() && this.lblFuncionarioCEP.getText().isEmpty() && this.DataNascFuncionario.getValue() == null && this.sexo == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher todos os campos para cadastro!");
            a.show();
        } else if (this.lblFuncionarioNome.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo nome!");
            a.show();
        } else if (this.lblFuncionarioCPF.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CPF!");
            a.show();
        } else if (this.lblFuncionarioEndereco.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Endereco!");
            a.show();
        } else if (this.lblFuncionarioBairro.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Bairro!");
            a.show();
        } else if (this.lblFuncionarioTelefone.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Telefone!");
            a.show();
        } else if (this.lblFuncionarioEstado.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Estado!");
            a.show();
        } else if (this.lblFuncionarioLogin.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Login!");
            a.show();
        } else if (this.lblFuncionarioSenha.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Senha!");
            a.show();
        } else if (this.lblFuncionarioCEP.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo CEP!");
            a.show();
        } else if (this.DataNascFuncionario.getValue() == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo Data de Nascimento!");
            a.show();
        } else if (this.sexo == null) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, Selecione a opção do sexo!");
            a.show();
        } else {
            this.funcionario.setNome(this.lblFuncionarioNome.getText());
            this.funcionario.setCpf(this.lblFuncionarioCPF.getText());
            this.funcionario.setEndereco(this.lblFuncionarioEndereco.getText());
            this.funcionario.setBairro(this.lblFuncionarioBairro.getText());
            this.funcionario.setTelefone(this.lblFuncionarioTelefone.getText());
            this.funcionario.setEstado(this.lblFuncionarioEstado.getText());
            this.funcionario.setLogin(this.lblFuncionarioLogin.getText());
            this.funcionario.setSenha(this.lblFuncionarioSenha.getText());
            this.funcionario.setSexo(this.sexo);
            this.funcionario.setCep(this.lblFuncionarioCEP.getText());
            this.funcionario.setData(Date.valueOf((LocalDate)this.DataNascFuncionario.getValue()));
            br.com.alessandro.model.dao.FuncionarioDAO.inserirFunc(this.funcionario);
            TelaNovoFuncionario.getStage().close();

            try {
                this.ti.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaNovoFuncionarioController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @FXML
    void btnCancelarCadastro(ActionEvent event) {
        TelaNovoFuncionario.getStage().close();

        try {
            this.ti.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(TelaNovoFuncionarioController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
