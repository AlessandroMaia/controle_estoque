package br.com.alessandro.view.fornecedor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaNovoFornecedor {
    private static Stage stageNovoFornecedor;

    public TelaNovoFornecedor() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaNovoFornecedor.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle fodastico de estoque");
        stage.setScene(scene);
        stage.show();
        stageNovoFornecedor = stage;
    }

    public static Stage getStage() {
        return stageNovoFornecedor;
    }
}