package com.cart.shopping_cart;


//import com.cart.shopping_cart.cart.CartView;
import com.cart.shopping_cart.home.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.io.IOException;

public class AppController {

    public AnchorPane root;
    public BorderPane body;
    public VBox sideArea;
    public HBox sideControls;
    public Label closeButton;
    public VBox sideNav;
    public Region navHome;
    public Region navCart;
    public ScrollPane scrollPane;
    public VBox componentBox;
    public Pane handPaneMac;
    @FXML
    public BorderPane contentPane;

    public void closeApp(){
        App.getWindow().close();
    }

    public void showHomeView() throws IOException {

        contentPane.setCenter(new HomeView().getView());
    }

    public void showCartView() {

        contentPane.setCenter(new Label("Cart View"));
    }
}