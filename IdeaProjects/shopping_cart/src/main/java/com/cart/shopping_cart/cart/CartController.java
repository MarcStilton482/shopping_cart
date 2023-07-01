package com.cart.shopping_cart.cart;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;

import java.util.List;

public class CartController {
    @FXML
    public VBox cartPane;

    @FXML
    public void initialize() {
        //populate the view
        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        if (entries.isEmpty()) {
            Label emptyLabel = new Label("EmptyCart");
            cartPane.getChildren().add(emptyLabel);
        } else {
            Label shoppingCartTitle = new Label("Shopping cart");
            cartPane.getChildren().add(shoppingCartTitle);

            for (CartEntry cartEntry : entries) {
                HBox hBox = new HBox();
                Label productName = new Label(cartEntry.getProduct().name());
                hBox.getChildren().add(productName);
                cartPane.getChildren().add(hBox);
            }
        }
    }
}