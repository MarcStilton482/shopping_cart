package com.cart.shopping_cart.home;

//import com.cart.shopping_cart.SynthesizerUtil;

import com.cart.shopping_cart.cart.ShoppingCart;
import javafx.fxml.FXML;
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
    //private SynthesizerUtil synthesizerUtil;
    @FXML
    public GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException {
        //synthesizerUtil = SynthesizerUtil.getInstance();
        VBox productView1 = productView(Product.Washing_Machine);
        productGridPane.add(productView1, 0, 0);
        VBox productView2 = productView(Product.Wireless_Phone_Charger);
        productGridPane.add(productView2, 2, 1);
        VBox productView3 = productView(Product.Automatic_Home_Controller);
        productGridPane.add(productView3, 2, 0);
        VBox productView4 = productView(Product.Dishwasher);
        productGridPane.add(productView4, 0, 1);
        VBox productView5 = productView(Product.Massage_Chair);
        productGridPane.add(productView5, 1, 1);
        VBox productView6 = productView(Product.AUTOMATIC_VACUUM_CLEANER);
        productGridPane.add(productView6, 1, 0);
        VBox productView7 = productView(Product.Automatic_Room_Heater);
        productGridPane.add(productView7, 0, 2);
        VBox productView8 = productView(Product.Neck_Massager);
        productGridPane.add(productView8, 1, 2);
        VBox productView9 = productView(Product.Bluetooth_Speaker);
        productGridPane.add(productView9, 2, 2);
    }
    public VBox productView(Product product) throws FileNotFoundException {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        FileInputStream input = new FileInputStream("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/resources/"+product.getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label productName = new Label(product.name());
        Label price = new Label(product.getPrice()+" Rs");
        Button addButton = new Button("Add to Cart");
        //synthesizerUtil.speak("Open Add to cart");
      //  Synth("Open Add to cart");
        addButton.setUserData(product.name());
        addButton.setOnAction(actionEvent -> {
            //add product to shopping cart
            Node sourceComponent = (Node)actionEvent.getSource();
            String productName1 = (String)sourceComponent.getUserData();
            ShoppingCart shoppingCart = ShoppingCart.getInstance();
            shoppingCart.addProduct(productName1);
           // Synth("Open Add to cart"+productName1);


        });
        layout.getChildren().addAll(imageView,productName,price,addButton);
        return layout;
    }
}