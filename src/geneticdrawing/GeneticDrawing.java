/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package geneticdrawing;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jgonis
 */
public class GeneticDrawing extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Canvas mainCanvas = new Canvas(1000, 750);
        Label iterationsPerSec = new Label("Iterations per second: ");
        Button resetButton = new Button("Reset Drawing");
        
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        VBox mainPane = new VBox();
        AnchorPane controlPane = new AnchorPane();
        mainPane.getChildren().add(mainCanvas);
        mainPane.getChildren().add(controlPane);
        controlPane.getChildren().addAll(iterationsPerSec, resetButton);
        AnchorPane.setLeftAnchor(iterationsPerSec, 10.0);
        AnchorPane.setRightAnchor(resetButton, 10.0);
        
        Scene scene = new Scene(mainPane);
        
        primaryStage.setTitle("GeneticDrawing");
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
            }
        });
        
        primaryStage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as
     * fallback in case the application can not be launched through deployment artifacts, e.g., in
     * IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
