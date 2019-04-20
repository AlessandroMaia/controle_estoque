package br.com.alessandro.viewlogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTelaLogin extends Application {
    private static Stage stageLogin;

    public MainTelaLogin() {
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("TelaLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageLogin = stage;
    }

    public static Stage getStage() {
        return stageLogin;
    }

    public static void main(String[] args) {
        launch(args);
    }
}