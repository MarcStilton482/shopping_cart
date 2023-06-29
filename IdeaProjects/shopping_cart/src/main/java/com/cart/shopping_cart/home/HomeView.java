package com.cart.shopping_cart.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HomeView {

    public final Parent view;
    public HomeView() throws IOException {
        URL url = new File("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/com/cart/shopping_cart/home/home.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(url);
        this.view = root;
    }

    public Parent getView(){
        return this.view;
    }
}