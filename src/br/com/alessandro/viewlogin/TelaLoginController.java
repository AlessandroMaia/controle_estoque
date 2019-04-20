package br.com.alessandro.viewlogin;

import br.com.alessandro.view.telaInicial.TelaInicial;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Funcionario;
import br.com.alessandro.model.dao.FuncionarioDAO;

public class TelaLoginController implements Initializable {
    @FXML
    private PasswordField lblSenha;
    @FXML
    private TextField lblLogin;
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();

    public TelaLoginController() {
    }

    @FXML
    void BotaoEntrar(ActionEvent event) {
        Alert a;
        if (this.lblLogin.getText().isEmpty() && this.lblSenha.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo login e senha!");
            a.show();
        } else if (this.lblLogin.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo login!");
            a.show();
        } else if (this.lblSenha.getText().isEmpty()) {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, preencher o campo e senha!");
            a.show();
        } else if (funcionarioDAO.loginFunc(lblLogin.getText(), lblSenha.getText())) {
            try {
                TelaInicial ti = new TelaInicial();
                ti.start(new Stage());
                MainTelaLogin.getStage().close();
            } catch (Exception var4) {
                a = new Alert(AlertType.ERROR);
                a.setHeaderText("Erro ao iniciar Tela Inicial!");
                a.show();
            }
        } else {
            a = new Alert(AlertType.ERROR);
            a.setHeaderText("Usuário ou Senha Inválidos!");
            a.show();
        }

    }

    @FXML
    void BotaoSair(ActionEvent event) {
        System.exit(0);
    }

    public void initialize(URL url, ResourceBundle rb) {
    }
}