package br.com.alessandro.view.fornecedor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;

public class TelaConsultaFornecedor {
    private static Stage stageConsultaFornecedor;

    public TelaConsultaFornecedor(Fornecedor funci) {
        TelaConsultaFornecedorController.setForn2(funci);
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaConsultaFornecedor.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle fodastico de estoque");
        stage.setScene(scene);
        stage.show();
        stageConsultaFornecedor = stage;
    }

    public static Stage getStage() {
        return stageConsultaFornecedor;
    }
}