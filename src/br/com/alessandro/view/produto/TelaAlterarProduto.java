package br.com.alessandro.view.produto;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Produto;

public class TelaAlterarProduto {
    private static Stage stageAlterarProduto;

    public TelaAlterarProduto(Produto prod2) {
        TelaAlterarProdutoController.setProdu(prod2);
    }

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("TelaAlterarProduto.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Controle fodastico de estoque");
        stage.setScene(scene);
        stage.show();
        stageAlterarProduto = stage;
    }

    public static Stage getStage() {
        return stageAlterarProduto;
    }
}
