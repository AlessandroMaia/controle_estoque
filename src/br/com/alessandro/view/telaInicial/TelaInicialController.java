package br.com.alessandro.view.telaInicial;

import br.com.alessandro.view.fornecedor.TelaAlterarFornecedor;
import br.com.alessandro.view.fornecedor.TelaAlterarFornecedorController;
import br.com.alessandro.view.fornecedor.TelaConsultaFornecedor;
import br.com.alessandro.view.fornecedor.TelaConsultaFornecedorController;
import br.com.alessandro.view.fornecedor.TelaNovoFornecedor;
import br.com.alessandro.view.funcionario.TelaAlterarFuncionario;
import br.com.alessandro.view.funcionario.TelaAlterarFuncionarioController;
import br.com.alessandro.view.funcionario.TelaConsultaFuncionario;
import br.com.alessandro.view.funcionario.TelaConsultaFuncionarioController;
import br.com.alessandro.view.funcionario.TelaNovoFuncionario;
import br.com.alessandro.view.produto.TelaAlterarProduto;
import br.com.alessandro.view.produto.TelaAlterarProdutoController;
import br.com.alessandro.view.produto.TelaNovoProduto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import br.com.alessandro.model.bean.Fornecedor;
import br.com.alessandro.model.bean.Funcionario;
import br.com.alessandro.model.bean.Produto;
import br.com.alessandro.model.dao.FornecedorDAO;
import br.com.alessandro.model.dao.FuncionarioDAO;
import br.com.alessandro.model.dao.ProdutoDAO;

public class TelaInicialController implements Initializable {
    TelaAlterarFuncionarioController tafc = new TelaAlterarFuncionarioController();
    TelaConsultaFuncionarioController tcfc = new TelaConsultaFuncionarioController();
    private Funcionario selecionada;
    TelaConsultaFornecedorController tcfcc = new TelaConsultaFornecedorController();
    TelaAlterarFornecedorController tafcc = new TelaAlterarFornecedorController();
    private Fornecedor selecionaForn;
    TelaAlterarProdutoController tapc = new TelaAlterarProdutoController();
    private Produto selecionaPro;
    @FXML
    private TableView<Funcionario> TbFuncionario;
    @FXML
    private TableColumn<Funcionario, Integer> IDFuncionario;
    @FXML
    private TableColumn<Funcionario, String> NomeFuncionario;
    @FXML
    private TableColumn<Funcionario, String> CpfFuncionario;
    @FXML
    private TableColumn<Funcionario, String> SexoFuncionario;
    @FXML
    private TableColumn<Funcionario, String> TelFucnionario;
    @FXML
    private TextField txtBuscarFunc;
    private ObservableList<Funcionario> funciona = FXCollections.observableArrayList();
    @FXML
    private TableView<Produto> TbProduto;
    @FXML
    private TableColumn<Produto, Integer> tbIdPro;
    @FXML
    private TableColumn<Produto, String> tbNomePro;
    @FXML
    private TableColumn<Produto, Integer> tbQtdPro;
    @FXML
    private TableColumn<Produto, String> tbViewMarca;
    @FXML
    private TableColumn<Produto, String> tbViewFornPro;
    @FXML
    private TextField txtBuscarProd;
    private ObservableList<Produto> prod = FXCollections.observableArrayList();
    @FXML
    private TableView<Fornecedor> TbFornecedor;
    @FXML
    private TableColumn<Fornecedor, Integer> IDFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> FantasiaForncedor;
    @FXML
    private TableColumn<Fornecedor, String> CPNJFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> TelFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> PessoaFornecedor;
    @FXML
    private TextField txtBuscarForn;
    private ObservableList<Fornecedor> forn = FXCollections.observableArrayList();

    public TelaInicialController() {
    }

    public void initialize(URL url, ResourceBundle rs) {
        this.initTable();
        this.initiTableForn();
        this.initiTablePro();
        this.TbFuncionario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TelaInicialController.this.selecionada = (Funcionario)newValue;
                TelaInicialController.this.tafc.initiFunc();
                TelaInicialController.this.tcfc.initiViewFunc();
            }
        });
        this.TbFornecedor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TelaInicialController.this.selecionaForn = (Fornecedor)newValue;
                TelaInicialController.this.tcfcc.initiViewForn();
                TelaInicialController.this.tafcc.initiAlteForn();
            }
        });
        this.TbProduto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TelaInicialController.this.selecionaPro = (Produto)newValue;
                TelaInicialController.this.tapc.initiAlteraProduto();
            }
        });
    }

    public void initTable() {
        this.IDFuncionario.setCellValueFactory(new PropertyValueFactory("Id_funcionario"));
        this.NomeFuncionario.setCellValueFactory(new PropertyValueFactory("nome"));
        this.CpfFuncionario.setCellValueFactory(new PropertyValueFactory("cpf"));
        this.SexoFuncionario.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.TelFucnionario.setCellValueFactory(new PropertyValueFactory("telefone"));
        this.TbFuncionario.setItems(this.atualizaTabela());
    }

    public ObservableList<Funcionario> atualizaTabela() {
        FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
        this.funciona = FXCollections.observableArrayList(FuncionarioDAO.getList());
        return this.funciona;
    }

    @FXML
    void CadastrarNovoFuncionario(ActionEvent event) {
        TelaNovoFuncionario tnf = new TelaNovoFuncionario();

        try {
            tnf.start(new Stage());
            TelaInicial.getStage().close();
        } catch (Exception var4) {
            System.out.println("Error");
        }

    }

    @FXML
    void AlterarFuncionario(ActionEvent event) {
        TelaAlterarFuncionario taf = new TelaAlterarFuncionario(this.selecionada);
        if (this.selecionada != null) {
            try {
                taf.start(new Stage());
                TelaInicial.getStage().close();
            } catch (Exception var4) {
                System.out.println("Error" + var4);
            }
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um funcionario!");
            a.show();
        }

    }

    @FXML
    void ConsultaFuncionario(ActionEvent event) {
        TelaConsultaFuncionario tcf = new TelaConsultaFuncionario(this.selecionada);
        if (this.selecionada != null) {
            try {
                tcf.start(new Stage());
            } catch (Exception var4) {
                System.out.println("Error" + var4);
            }
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um funcionario!");
            a.show();
        }

    }

    @FXML
    void DeletarFuncionario(ActionEvent event) {
        FuncionarioDAO fdao = new FuncionarioDAO();
        Alert a;
        if (this.selecionada != null) {
            fdao.deletarFunc(this.selecionada);
            this.initTable();
            a = new Alert(AlertType.INFORMATION);
            a.setHeaderText("Funcionario excluido com sucesso!");
            a.show();
        } else {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um funcionario!");
            a.show();
        }

    }

    private ObservableList<Funcionario> BuscarFuncionario() {
        ObservableList<Funcionario> pesquisafuncionario = FXCollections.observableArrayList();

        for(int x = 0; x < this.funciona.size(); ++x) {
            if (((Funcionario)this.funciona.get(x)).getNome().toLowerCase().contains(this.txtBuscarFunc.getText())) {
                pesquisafuncionario.add(this.funciona.get(x));
            }
        }

        return pesquisafuncionario;
    }

    @FXML
    void btnBuscarFunc(ActionEvent event) {
        this.TbFuncionario.setItems(this.BuscarFuncionario());
    }

    public void initiTablePro() {
        this.tbIdPro.setCellValueFactory(new PropertyValueFactory("id_produto"));
        this.tbNomePro.setCellValueFactory(new PropertyValueFactory("nome"));
        this.tbQtdPro.setCellValueFactory(new PropertyValueFactory("quantidade"));
        this.tbViewMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.tbViewFornPro.setCellValueFactory(new PropertyValueFactory("nomefantasia"));
        this.TbProduto.setItems(this.atualizaTabelaPro());
    }

    public ObservableList<Produto> atualizaTabelaPro() {
        this.prod = FXCollections.observableArrayList(ProdutoDAO.getList());
        return this.prod;
    }

    @FXML
    void CadastrarNovoProduto(ActionEvent event) {
        TelaNovoProduto tnp = new TelaNovoProduto();

        try {
            tnp.start(new Stage());
            TelaInicial.getStage().close();
        } catch (Exception var4) {
            System.out.println(var4);
        }

    }

    @FXML
    void AlterarProduto(ActionEvent event) {
        TelaAlterarProduto tafff = new TelaAlterarProduto(this.selecionaPro);
        if (this.selecionaPro != null) {
            try {
                tafff.start(new Stage());
                TelaInicial.getStage().close();
            } catch (Exception var4) {
                System.out.println(var4);
            }
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um produto!");
            a.show();
        }

    }

    @FXML
    void DeletarProduto(ActionEvent event) {
        ProdutoDAO pdao = new ProdutoDAO();
        Alert a;
        if (this.selecionaPro != null) {
            pdao.deletarPro(this.selecionaPro);
            this.initiTablePro();
            a = new Alert(AlertType.INFORMATION);
            a.setHeaderText("Produto excluido com sucesso!");
            a.show();
        } else {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um produto!");
            a.show();
        }

    }

    private ObservableList<Produto> BuscarProduto() {
        ObservableList<Produto> pesquisaproduto = FXCollections.observableArrayList();

        for(int x = 0; x < this.prod.size(); ++x) {
            if (((Produto)this.prod.get(x)).getNome().toLowerCase().contains(this.txtBuscarProd.getText())) {
                pesquisaproduto.add(this.prod.get(x));
            }
        }

        return pesquisaproduto;
    }

    @FXML
    void btnBuscarProd(ActionEvent event) {
        this.TbProduto.setItems(this.BuscarProduto());
    }

    public void initiTableForn() {
        this.IDFornecedor.setCellValueFactory(new PropertyValueFactory("id_fornecedor"));
        this.FantasiaForncedor.setCellValueFactory(new PropertyValueFactory("nomefantasia"));
        this.CPNJFornecedor.setCellValueFactory(new PropertyValueFactory("cnpj_cpf"));
        this.TelFornecedor.setCellValueFactory(new PropertyValueFactory("telefone"));
        this.PessoaFornecedor.setCellValueFactory(new PropertyValueFactory("pessoa"));
        this.TbFornecedor.setItems(this.atualizaTabelaForn());
    }

    public ObservableList<Fornecedor> atualizaTabelaForn() {
        FornecedorDAO FornecedorDAO = new FornecedorDAO();
        this.forn = FXCollections.observableArrayList(FornecedorDAO.getList());
        return this.forn;
    }

    @FXML
    void CadastrarNovoFornecedor(ActionEvent event) {
        TelaNovoFornecedor tnff = new TelaNovoFornecedor();

        try {
            tnff.start(new Stage());
            TelaInicial.getStage().close();
        } catch (Exception var4) {
            System.out.println(var4);
        }

    }

    @FXML
    void AlterarFornecedor(ActionEvent event) {
        TelaAlterarFornecedor taff = new TelaAlterarFornecedor(this.selecionaForn);
        if (this.selecionaForn != null) {
            try {
                taff.start(new Stage());
                TelaInicial.getStage().close();
            } catch (Exception var4) {
                System.out.println(var4);
            }
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um Fornecedor!");
            a.show();
        }

    }

    @FXML
    void ConsultaFornecedor(ActionEvent event) {
        TelaConsultaFornecedor tcff = new TelaConsultaFornecedor(this.selecionaForn);
        if (this.selecionaForn != null) {
            try {
                tcff.start(new Stage());
            } catch (Exception var4) {
                System.out.println("Error" + var4);
            }
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um Fornecedor!");
            a.show();
        }

    }

    @FXML
    void DeletarFornecedor(ActionEvent event) {
        FornecedorDAO fnao = new FornecedorDAO();
        Alert a;
        if (this.selecionaForn != null) {
            fnao.deletarForn(this.selecionaForn);
            this.initiTableForn();
            a = new Alert(AlertType.INFORMATION);
            a.setHeaderText("Fornecedor excluido com sucesso!");
            a.show();
        } else {
            a = new Alert(AlertType.WARNING);
            a.setHeaderText("Favor, selecione um fornecedor!");
            a.show();
        }

    }

    private ObservableList<Fornecedor> BuscarFornecedor() {
        ObservableList<Fornecedor> pesquisafornecedor = FXCollections.observableArrayList();

        for(int x = 0; x < this.forn.size(); ++x) {
            if (((Fornecedor)this.forn.get(x)).getNomefantasia().toLowerCase().contains(this.txtBuscarForn.getText())) {
                pesquisafornecedor.add(this.forn.get(x));
            }
        }

        return pesquisafornecedor;
    }

    @FXML
    void btnBuscarForn(ActionEvent event) {
        this.TbFornecedor.setItems(this.BuscarFornecedor());
    }
}
