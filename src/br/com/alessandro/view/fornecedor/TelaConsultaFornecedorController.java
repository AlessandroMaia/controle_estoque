package br.com.alessandro.view.fornecedor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import br.com.alessandro.model.bean.Fornecedor;

public class TelaConsultaFornecedorController implements Initializable {
    @FXML
    private TextField lblConsultaRazaoSocial;
    @FXML
    private TextField lblConsultaNomeFantasia;
    @FXML
    private RadioButton CheckFis;
    @FXML
    private RadioButton CheckJur;
    @FXML
    private TextField lblConsultaCNPJ;
    @FXML
    private TextField lblConsultaIE;
    @FXML
    private TextField lblCOnsultaEnd;
    @FXML
    private TextField lblConsultaBairro;
    @FXML
    private TextField lblConsultaTelefone;
    @FXML
    private TextField lblConsultaCep;
    @FXML
    private Label lblIDForn;
    @FXML
    private TextField lblConsultaEstado;
    private static Fornecedor forn2;

    public TelaConsultaFornecedorController() {
    }

    public static Fornecedor getForn2() {
        return forn2;
    }

    public static void setForn2(Fornecedor aForn2) {
        forn2 = aForn2;
    }

    public void initiViewForn() {
        this.lblIDForn.setText(String.valueOf(getForn2().getId_fornecedor()).intern());
        this.lblConsultaRazaoSocial.setText(getForn2().getRazaosocial());
        this.lblConsultaNomeFantasia.setText(getForn2().getNomefantasia());
        this.lblConsultaCNPJ.setText(getForn2().getCnpj_cpf());
        this.lblConsultaIE.setText(getForn2().getIe());
        this.lblCOnsultaEnd.setText(getForn2().getEndereco());
        this.lblConsultaCep.setText(getForn2().getCep());
        this.lblConsultaBairro.setText(getForn2().getBairro());
        this.lblConsultaEstado.setText(getForn2().getEstado());
        this.lblConsultaTelefone.setText(getForn2().getTelefone());
        String var1 = forn2.getPessoa();
        int var2 = 0;

        if (var1.equals("Física")) {
            var2 = 0;
        }

        if (var1.equals("Júridica")) {
            var2 = 1;
        }

        switch(var2) {
            case 0:
                this.CheckFis.setSelected(true);
                break;
            case 1:
                this.CheckJur.setSelected(true);
                break;
        }

    }

    public void initialize(URL url, ResourceBundle rs) {
        this.initiViewForn();
    }

    @FXML
    void btnSairConsultaFornecedor(ActionEvent event) {
        TelaConsultaFornecedor.getStage().close();
    }
}
