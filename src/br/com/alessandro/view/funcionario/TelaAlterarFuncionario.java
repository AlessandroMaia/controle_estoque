package br.com.alessandro.view.funcionario;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Funcionario;

public class TelaAlterarFuncionario {
    private static Stage stageAlterarFuncionario;

    public TelaAlterarFuncionario(Funcionario funci) {
        TelaAlterarFuncionarioController.setFunc(funci);
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaAlterarFuncionario.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageAlterarFuncionario = stage;
    }

    public static Stage getStage() {
        return stageAlterarFuncionario;
    }
}
