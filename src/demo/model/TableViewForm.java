/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author GIANG TINH
 */
public class TableViewForm extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView tableView = new TableView();
        TableColumn<Form, String> columnName = new TableColumn<>("Tên sản phẩm");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnName.setMinWidth(200);

        TableColumn<Form, String> columnImage = new TableColumn<>("Ảnh sản phẩm");
        columnImage.setCellValueFactory(new PropertyValueFactory<>("Image"));
        columnImage.setMinWidth(200);

        TableColumn<Form, String> columnPrice = new TableColumn<>("Giá (VND)");
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnPrice.setMinWidth(100);

        FormModel fm = new FormModel();
        ArrayList<Form> listForm = fm.query();

        columnImage.setCellFactory(
                new Callback<TableColumn<Form, String>, TableCell<Form, String>>() {
            @Override
            public TableCell<Form, String> call(TableColumn<Form, String> param) {

                return new TableCell<Form, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        if (item != null) {
                            for (Form form : listForm) {
                                Image img = new Image(form.getImage());
                                ImageView imgView = new ImageView(img);
                                imgView.setFitHeight(50);
                                imgView.setFitWidth(50);
                                setGraphic(imgView);
                            }
                        }
                    }
                };
            }
        });

        ObservableList<Form> observableList = FXCollections.observableArrayList();
        observableList.addAll(listForm);
        tableView.getItems().addAll(observableList);

        tableView.getColumns().addAll(columnImage, columnPrice, columnName);
        Scene scene = new Scene(tableView, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
