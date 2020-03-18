package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javafx.scene.control.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import com.foundations.Match_output;

import javax.swing.*;

import static javafx.scene.paint.Color.*;

public class Controller implements Initializable {

    @FXML
    private JFXButton problem;


    @FXML
    private TreeTableColumn<Model, String> languagecol;


    @FXML
    private TreeTableView<Model> Table;


    @FXML
    private JFXButton submit;

    @FXML
    private Label problevel;

    @FXML
    private JFXComboBox<String> problemcomb;

    @FXML
    private TreeTableColumn<Model, String> problemcol;

    @FXML
    private TreeTableColumn<Model, String> filecol;

    @FXML
    private JFXComboBox<String> languagecomb;


    @FXML
    private TreeTableColumn<Model, String> statuscol;

    @FXML
    private Label languagechoose;

    @FXML
    private JFXButton filechoose;

    @FXML
    private Label chooseNumber;
    @FXML
    private JFXTextField filetext;
    ObservableList<Model>list;
    public String parent,n,l,s,f,g;
    public Text y;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final FileChooser fileChooser = new FileChooser();
        problemcomb.getItems().addAll("1","2","3","4");
        languagecomb.getItems().addAll("c","c++","java");
        problemcol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().problemcol;
            }
        });
        filecol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().filecol;
            }
        });
        languagecol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().languagecol;
            }
        });
        statuscol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().statuscol;
            }
        });

        list= FXCollections.observableArrayList();
        TreeItem<Model> root=new RecursiveTreeItem<Model>(list, RecursiveTreeObject::getChildren);
        Table.setRoot(root);
        Table.setShowRoot(false);
        Table.setStyle("-fx-backgroung-color:"+"#00ffbf"+";");
        filechoose.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(new Stage());
            f=file.toString();
            parent = file.getName();
            filetext.setText(parent);
        });
        submit.setOnAction(this::handle);
        problem.setOnAction(event -> {
            new Main().problemWindow();
        });
    }
    public void handle(ActionEvent event) {
        Match_output m = new Match_output();
        n = problemcomb.getSelectionModel().getSelectedItem();
        l = languagecomb.getSelectionModel().getSelectedItem();
        try {
            s = m.match(n, f, l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(n.equals("1")) g="Add Two Numbers";
        else if(n.equals("2")) g="Theatre Square";
        else if(n.equals("3")) g="Multiplication \nTable";
        else if(n.equals("4")) g="Yet Another Meme \nProblem";
        list.addAll(new Model(problemcomb.getSelectionModel().getSelectedItem() + "--" + g, parent, languagecomb.getSelectionModel().getSelectedItem(), s));
        customiseFactory(statuscol);
    }
    private void customiseFactory(TreeTableColumn<Model, String> calltypel) {
        calltypel.setCellFactory(column -> {
            return new TreeTableCell<Model, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);

                    TreeTableRow<Model> currentRow = getTreeTableRow();

                    if (!isEmpty()) {

                        if(item.equals("Accepted"))
                            currentRow.setStyle("-fx-background-color:#5cd31c");
                        else
                            currentRow.setStyle("-fx-background-color:FF0000");
                    }
                }
            };
        });
    }
}
