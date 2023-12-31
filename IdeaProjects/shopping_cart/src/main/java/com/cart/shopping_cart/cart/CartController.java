package com.cart.shopping_cart.cart;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
public class CartController {
    @FXML
    public VBox cartPane;
    public Label totalPriceLabel;
    @FXML
    public void initialize() throws FileNotFoundException {
        //populate the view
        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        if (entries.isEmpty()) {
            Label emptyLabel = new Label("EmptyCart");
            cartPane.getChildren().add(emptyLabel);
            cartPane.setStyle("-fx-font-size:16pt;");
        } else {
            Label shoppingCartTitle = new Label("Shopping cart");
            cartPane.getChildren().add(shoppingCartTitle);
            cartPane.setStyle("-fx-font-size:16pt;");

            for (CartEntry cartEntry : entries) {
                HBox productView = cartEntryView(cartEntry);
                cartPane.getChildren().add(productView);
            }
            Separator separator =new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(separator);

            HBox totalView = totalView(ShoppingCart.getInstance().calculateTotal());
            cartPane.getChildren().add(totalView);
        }
    }
    public HBox totalView(float totalPrice){
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);
        Label totalLabel = new Label("Total : ");
        totalLabel.setStyle("-fx-font-size:25pt;");
        this.totalPriceLabel = new Label(totalPrice +" Rs");
        totalPriceLabel.setStyle("-fx-font-size:25pt;");
        layout.getChildren().addAll(totalLabel,this.totalPriceLabel);
        layout.setStyle("-fx-border-color: #d45b0e; -fx-border-width: 2px; -fx-padding: 10px;");
        return layout;
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

        Label productName = new Label(cartEntry.getProduct().getName());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:14pt; -fx-padding:5px");


        Label quantity = new Label((String.valueOf(cartEntry.getQuantity())));
        quantity.setStyle("-fx-padding:5px ");
        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-padding:5px; -fx-background-color: #00008b; -fx-text-fill: white; -fx-font-size: 14px;");

        plusButton.setUserData(cartEntry.getProduct().name());
        plusButton.setOnAction( e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            String addedProduct =ShoppingCart.getInstance().addProduct(name);
            float productStock = cartEntry.getProduct().getStock();

            if(productStock!=0){productStock--;
                cartEntry.getProduct().setStock((int) productStock);}
            quantity.setText(String.valueOf(ShoppingCart.getInstance().getQuantity(name)));
                String changedQuantity = String.valueOf(ShoppingCart.getInstance().getQuantity(name));



            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getInstance().calculateTotal()));
            String totalPrice = String.valueOf(ShoppingCart.getInstance().calculateTotal());
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
                        " Added product    "+ addedProduct + "    Quantity changed to     "+ changedQuantity+ "   and the total price changed to   "+totalPrice , null);
                synthesizer.waitEngineState(
                        Synthesizer.QUEUE_EMPTY);
            }
            catch (Exception et) {
                et.printStackTrace();
            }
        });
        Button minusButton = new Button("-");
        minusButton.setStyle("-fx-padding:5px; -fx-background-color: #00008b; -fx-text-fill: white; -fx-font-size: 14px;");

        minusButton.setUserData(cartEntry.getProduct().name());
        minusButton.setOnAction( e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            String removeProduct = ShoppingCart.getInstance().removeProduct(name);
            quantity.setText(String.valueOf(ShoppingCart.getInstance().getQuantity(name)));
            String changedQuantity = String.valueOf(ShoppingCart.getInstance().getQuantity(name));
            float productStock = cartEntry.getProduct().getStock();
            if(productStock < 10){productStock++;
                cartEntry.getProduct().setStock((int) productStock);}
            this.totalPriceLabel.setText(String.valueOf(ShoppingCart.getInstance().calculateTotal()));
            String totalPrice = String.valueOf(ShoppingCart.getInstance().calculateTotal());
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
                        " Removed product    "+ removeProduct + "    Quantity changed to     "+ changedQuantity+ "   and the total price changed to   "+totalPrice , null);
                synthesizer.waitEngineState(
                        Synthesizer.QUEUE_EMPTY);
            }
            catch (Exception et) {
                et.printStackTrace();
            }
        });
        Label price = new Label(cartEntry.getProduct().getPrice() + " Rs");


        layout.getChildren().addAll(imageView, productName, plusButton, quantity, minusButton, price);
        layout.setStyle("-fx-border-color: #8B4000; -fx-border-width: 2px; -fx-padding: 10px;");
        layout.setSpacing(15);

        return layout;
    }

    public void checkOut(MouseEvent mouseEvent) throws IOException {

        List<CartEntry> entries = ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        Label checkoutMessage= new Label("Thank You for Shopping with us");
        cartPane.getChildren().add(checkoutMessage);
        cartPane.setStyle("-fx-font-size:16pt;");
        cartPane.setAlignment(Pos.CENTER);




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
                    "Checking out the products in cart "+" Thank you for ordering", null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}