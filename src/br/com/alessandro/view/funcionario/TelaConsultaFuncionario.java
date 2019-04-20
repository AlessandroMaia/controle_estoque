package br.com.alessandro.view.funcionario;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Funcionario;

public class TelaConsultaFuncionario {
    public static Stage stageConsultaFuncionario;

    public TelaConsultaFuncionario(Funcionario funci) {
        TelaConsultaFuncionarioController.setFunc2(funci);
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaConsultaFuncionario.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageConsultaFuncionario = stage;
    }

    public static Stage getStage() {
        return stageConsultaFuncionario;
    }
}
