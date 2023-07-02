package com.cart.shopping_cart.cart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
public class CartView {
    public Parent view;

    public CartView() throws IOException {
        URL uiFile = new File("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/com/cart/shopping_cart/cart/cart.fxml").toURI().toURL();
        this.view = FXMLLoader.load(uiFile);
    }

    public Parent getView() {
        return this.view;
    }
}
