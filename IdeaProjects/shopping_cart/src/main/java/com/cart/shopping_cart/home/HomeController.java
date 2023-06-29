package com.cart.shopping_cart.home;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {

    @FXML
    public GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException {
        productGridPane.getChildren().clear();
        Label label1 = new Label(Product.APPLE.name());
        label1.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label1, 0, 0);
        Label label2 = new Label(Product.MILK.name());
        label2.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label2, 1, 0);
        Label label3 = new Label(Product.LETTUCE.name());
        label3.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label3, 2, 0);
        Label label4 = new Label(Product.JUICE.name());
        label4.setPadding(new Insets(5, 5, 5, 5));
        productGridPane.add(label4, 0, 1);
    }
}