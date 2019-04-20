package br.com.alessandro.view.telaInicial;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaInicial {
    private static Stage stageInicial;

    public TelaInicial() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaInicial.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageInicial = stage;
    }

    public static Stage getStage() {
        return stageInicial;
    }
}
