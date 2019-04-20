package br.com.alessandro.view.funcionario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import br.com.alessandro.model.bean.Funcionario;

public class TelaConsultaFuncionarioController implements Initializable {
    @FXML
    private TextField lblviewNomeFunc;
    @FXML
    private TextField lblviewCpfFunc;
    @FXML
    private TextField lblviewDataFunc;
    @FXML
    private TextField lblviewEnderecoFunc;
    @FXML
    private TextField lblviewBairroFunc;
    @FXML
    private TextField lblviewTelefoneFunc;
    @FXML
    private RadioButton CheckMasc;
    @FXML
    private RadioButton CheckFem;
    @FXML
    private TextField lblviewLoginFunc;
    @FXML
    private TextField lblviewEstadoFunc;
    @FXML
    private TextField lblviewCepFunc;
    @FXML
    private TextField lblViewConsultaSenha;
    private static Funcionario func2;

    public TelaConsultaFuncionarioController() {
    }

    public void initialize(URL url, ResourceBundle rs) {
        this.initiViewFunc();
    }

    public static Funcionario getFunc2() {
        return func2;
    }

    public static void setFunc2(Funcionario aFunc2) {
        func2 = aFunc2;
    }

    public void initiViewFunc() {
        this.lblviewNomeFunc.setText(getFunc2().getNome());
        this.lblviewCpfFunc.setText(getFunc2().getCpf());
        this.lblviewEnderecoFunc.setText(getFunc2().getEndereco());
        this.lblviewBairroFunc.setText(getFunc2().getEndereco());
        this.lblviewTelefoneFunc.setText(getFunc2().getTelefone());
        this.lblviewLoginFunc.setText(getFunc2().getLogin());
        this.lblviewEstadoFunc.setText(getFunc2().getEstado());
        this.lblviewCepFunc.setText(getFunc2().getCep());
        this.lblViewConsultaSenha.setText(getFunc2().getSenha());
        this.lblviewDataFunc.setText(String.valueOf(getFunc2().getData()));
        String var1 = func2.getSexo();

        byte var2 = 0;

        if (var1.equals("F")) {
            var2 = 0;
        }

        if (var1.equals("M")) {
            var2 = 1;
        }

        switch (var2) {
            case 0:
                this.CheckFem.setSelected(true);
                break;
            case 1:
                this.CheckMasc.setSelected(true);
                break;
        }

    }

    @FXML
    void btnSairConsulta(ActionEvent event) {
        TelaConsultaFuncionario.getStage().close();
    }
}
