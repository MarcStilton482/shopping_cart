package com.cart.shopping_cart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;


import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    public double xOffset = 0;
    public double yOffset = 0;
    public static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("C:/Users/ADMIN/IdeaProjects/shopping_cart/src/main/java/com/cart/shopping_cart/cartui.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Shopping Cart App");
        stage.setScene(new Scene(root, Color.TRANSPARENT));

        // phase 2
        stage.initStyle(StageStyle.TRANSPARENT);
        makeDraggable(root);
        stage.show();

        window = stage;
    }

    public static void main(String[] args) {

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

            // Allocate synthesizer
            synthesizer.allocate();
            // Resume Synthesizer
            synthesizer.resume();

            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(
                    "Welcome to Shop Voice Shopping Cart."+"Signed in as Admin", null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        launch();

    }


    public static Stage getWindow() {
        return window;
    }

    public void makeDraggable(Parent root){
        root.setOnMousePressed( e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        root.setOnMouseDragged( e -> {
            window.setX( e.getScreenX() - xOffset);
            window.setY( e.getScreenY() - yOffset);
        });
    }

}