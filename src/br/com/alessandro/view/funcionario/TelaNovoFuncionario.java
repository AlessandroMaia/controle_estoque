package br.com.alessandro.view.funcionario;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaNovoFuncionario {
    private static Stage stageNovoFuncionario;

    public TelaNovoFuncionario() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaNovoFuncionario.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageNovoFuncionario = stage;
    }

    public static Stage getStage() {
        return stageNovoFuncionario;
    }
}

