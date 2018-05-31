/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author GIANG TINH
 */
public class FormMainThread extends Application {

    private String name;
    private String Image;
    private String price;
    private TextField txtName;
    private TextField txtImage;
    private TextField txtPrice;
    Form form = new Form(name, Image, price);
    private FormModel model = new FormModel();

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        Label lblName = new Label("Name");
        txtName = new TextField();
        Label lblImage = new Label("Image");
        txtImage = new TextField();
        Label lblPrice = new Label("Price");
        txtPrice = new TextField();
        Button btbSubmit = new Button("Submit");
        Button btbReset = new Button("Reset");
        Label lblErrorName = new Label();
        Label lblErrorImage = new Label();
        Label lblErrorPrice = new Label();
        Label lblMessage = new Label();

        gridPane.add(lblName, 0, 0, 1, 1);
        gridPane.add(txtName, 1, 0, 1, 1);
        gridPane.add(lblImage, 0, 1, 1, 1);
        gridPane.add(txtImage, 1, 1, 1, 1);
        gridPane.add(lblPrice, 0, 2, 1, 1);
        gridPane.add(txtPrice, 1, 2, 1, 1);
        gridPane.add(lblErrorName, 2, 0, 1, 1);
        gridPane.add(lblErrorImage, 2, 1, 1, 1);
        gridPane.add(lblErrorPrice, 2, 2, 1, 1);
        gridPane.add(lblMessage, 1, 3, 1, 1);
        HBox box = new HBox();
        box.getChildren().addAll(btbSubmit, btbReset);
        box.setSpacing(10);
        gridPane.add(box, 1, 4, 1, 1);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        btbSubmit.setOnAction((event) -> {
            name = txtName.getText();
            Image = txtImage.getText();
            price = txtPrice.getText();
            if (name == null || name.isEmpty()) {
                lblMessage.setTextFill(Color.web("red"));
                lblMessage.setText("Vui lòng sửa lỗi và thử lại.");
                lblErrorName.setText("(*)");
                return;
            } else {
                lblMessage.setText("");
                lblErrorName.setText("");
            }
            if (Image == null || Image.isEmpty()) {
                lblMessage.setTextFill(Color.web("red"));
                lblMessage.setText("Vui lòng sửa lỗi và thử lại.");
                lblErrorImage.setText("(*)");
                return;
            } else {
                lblMessage.setText("");
                lblErrorImage.setText("");
            }
            if (price == null || price.isEmpty()) {
                lblMessage.setTextFill(Color.web("red"));
                lblMessage.setText("Vui lòng sửa lỗi và thử lại.");
                lblErrorPrice.setText("(*)");
                return;
            } else {
                lblMessage.setText("");
                lblErrorPrice.setText("");
            }

            form = new Form(name, Image, price);
            if (model.save(form)) {
                lblMessage.setTextFill(Color.web("green"));
                lblMessage.setText("Tạo mới thông tin thành công.");
                resetText();
            } else {
                lblMessage.setTextFill(Color.web("red"));
                lblMessage.setText("Không thể lưu thông tin, vui lòng thử lại sau.");
            }

        });
        btbReset.setOnAction((event) -> {
            resetText();
        });
        Scene scene = new Scene(gridPane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void resetText() {
        txtName.clear();
        txtImage.clear();
        txtPrice.clear();
    }
}
