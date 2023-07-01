package com.cart.shopping_cart.cart;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class CartController {
    @FXML
    public VBox cartPane;

    @FXML
    public void initialize() throws FileNotFoundException {
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
                HBox productView = cartEntryView(cartEntry);
                cartPane.getChildren().add(productView);
            }
        }
    }
    private HBox cartEntryView(CartEntry cartEntry) throws FileNotFoundException{
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream(
                "C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/resources/"+cartEntry.getProduct().getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        Label productName = new Label(cartEntry.getProduct().name());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        Label quantity = new Label((String.valueOf(cartEntry.getQuantity())));
        quantity.setStyle("-fx-padding:5px");
        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-padding:5px");
        Button minusButton = new Button("-");
        minusButton.setStyle("-fx-padding:5px");
        Label price = new Label(cartEntry.getProduct().getPrice() + " Rs");

        layout.getChildren().addAll(imageView, productName, plusButton, quantity, minusButton, price);

        return layout;
    }
}