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
        VBox productView1 = productView(Product.APPLE);
        productGridPane.add(productView1, 0, 0);
        VBox productView2 = productView(Product.MILK);
        productGridPane.add(productView2, 1, 0);
        VBox productView3 = productView(Product.JUICE);
        productGridPane.add(productView3, 2, 0);
        VBox productView4 = productView(Product.LETTUCE);
        productGridPane.add(productView4, 0, 1);
    }
    private VBox productView(Product product) throws FileNotFoundException {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        FileInputStream input = new FileInputStream("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/resources/img "+product.getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label productName = new Label(product.name());
        Label price = new Label(product.getPrice()+" Rs");
        Button addButton = new Button("Add to Cart");
        layout.getChildren().addAll(imageView,productName,price,addButton);
        return layout;
    }
}