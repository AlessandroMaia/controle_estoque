package br.com.alessandro.view.fornecedor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;

public class TelaAlterarFornecedor {
    private static Stage stageAlterarFornecedor;

    public TelaAlterarFornecedor(Fornecedor forn2) {
        TelaAlterarFornecedorController.setForn1(forn2);
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaAlterarFornecedor.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle");
        stage.setScene(scene);
        stage.show();
        stageAlterarFornecedor = stage;
    }

    public static Stage getStage() {
        return stageAlterarFornecedor;
    }
}