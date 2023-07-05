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

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;

public class HomeController {
    //private SynthesizerUtil synthesizerUtil;
    @FXML
    public GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException {
        //synthesizerUtil = SynthesizerUtil.getInstance();
        VBox productView1 = productView(Product.Washing_Machine);
        productGridPane.add(productView1, 0, 0);
        productView1.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView2 = productView(Product.Wireless_Phone_Charger);
        productGridPane.add(productView2, 2, 1);
        productView2.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView3 = productView(Product.Automatic_Home_Controller);
        productGridPane.add(productView3, 2, 0);
        productView3.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView4 = productView(Product.Dishwasher);
        productGridPane.add(productView4, 0, 1);
        productView4.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView5 = productView(Product.Massage_Chair);
        productGridPane.add(productView5, 1, 1);
        productView5.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView6 = productView(Product.AUTOMATIC_VACUUM_CLEANER);
        productGridPane.add(productView6, 1, 0);
        productView6.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView7 = productView(Product.Automatic_Room_Heater);
        productGridPane.add(productView7, 0, 2);
        productView7.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView8 = productView(Product.Neck_Massager);
        productGridPane.add(productView8, 1, 2);
        productView8.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        VBox productView9 = productView(Product.Bluetooth_Speaker);
        productGridPane.add(productView9, 2, 2);
        productView9.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");

    }
    public VBox productView(Product product) throws FileNotFoundException {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        FileInputStream input = new FileInputStream("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/resources/"+product.getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label productName = new Label(product.getName());
        Label price = new Label(product.getPrice()+" Rs");
        Button addButton = new Button("Add to Cart");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        addButton.setUserData(product.name());
        addButton.setOnAction(actionEvent -> {
            //add product to shopping cart
            Node sourceComponent = (Node)actionEvent.getSource();
            String productName1 = (String)sourceComponent.getUserData();

            ShoppingCart shoppingCart = ShoppingCart.getInstance();
            shoppingCart.addProduct(productName1);
            try {
                // Set property as Kevin Dictionary
                System.setProperty(
                        "freetts.voices",
                        "com.sun.speech.freetts.en.us"
                                + ".cmu_us_kal.KevinVoiceDirectory");

                // Register Engine
                Central.registerEngineCentral(
                        "com.sun.speech.freetts"
                                + ".jsapi.FreeTTSEngineCentral");

                // Create a Synthesizer
                Synthesizer synthesizer
                        = Central.createSynthesizer(
                        new SynthesizerModeDesc(Locale.US));
                // Resume Synthesizer
                synthesizer.resume();

                // Speaks the given text
                // until the queue is empty.
                synthesizer.speakPlainText(
                        "Added "+productName1+" to cart", null);
                synthesizer.waitEngineState(
                        Synthesizer.QUEUE_EMPTY);
            }
            catch (Exception e) {
                e.printStackTrace();
            }


        });
        Button inButton = new Button("Info");
        inButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        inButton.setUserData(product.getIn());
        inButton.setOnAction(actionEvent -> {
            //add product to shopping cart
            try {
                // Set property as Kevin Dictionary
                System.setProperty(
                        "freetts.voices",
                        "com.sun.speech.freetts.en.us"
                                + ".cmu_us_kal.KevinVoiceDirectory");

                // Register Engine
                Central.registerEngineCentral(
                        "com.sun.speech.freetts"
                                + ".jsapi.FreeTTSEngineCentral");

                // Create a Synthesizer
                Synthesizer synthesizer
                        = Central.createSynthesizer(
                        new SynthesizerModeDesc(Locale.US));
                // Resume Synthesizer
                synthesizer.resume();

                // Speaks the given text
                // until the queue is empty.
                synthesizer.speakPlainText(
                        product.getIn(), null);
                synthesizer.waitEngineState(
                        Synthesizer.QUEUE_EMPTY);
            }
            catch (Exception e) {
                e.printStackTrace();
            }


        });
        layout.getChildren().addAll(imageView, productName, price, inButton, addButton);
        return layout;
    }
}