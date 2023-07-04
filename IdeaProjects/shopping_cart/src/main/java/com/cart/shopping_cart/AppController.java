package com.cart.shopping_cart;

import com.cart.shopping_cart.cart.CartView;
import com.cart.shopping_cart.home.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

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

    public void closeApp()  {

        App.getWindow().close();
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
                    "Closing Shopping Cart", null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);

            // Deallocate the Synthesizer.
            synthesizer.deallocate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }








    }

    public void showHomeView() throws IOException {

        contentPane.setCenter(new HomeView().getView());







    }

    public void showCartView() throws IOException {

        contentPane.setCenter(new CartView().getView());






    }
}