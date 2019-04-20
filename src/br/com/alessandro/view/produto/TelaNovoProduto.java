package br.com.alessandro.view.produto;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaNovoProduto {
    private static Stage stageNovoProduto;

    public TelaNovoProduto() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaNovoProduto.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle fodastico de estoque");
        stage.setScene(scene);
        stage.show();
        stageNovoProduto = stage;
    }

    public static Stage getStage() {
        return stageNovoProduto;
    }
}
