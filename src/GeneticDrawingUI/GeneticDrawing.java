/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GeneticDrawingUI;

import GeneticDrawModel.GeneratedImageModel;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jgonis
 */
public class GeneticDrawing extends Application {
    
    private GeneratedImageModel m_model;
    private Canvas m_mainCanvas;
    private ImageComparator m_comparator;
    private int m_currentDifference = 1;
    private Image m_originalImage;
    
    /**
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        
        createGui(primaryStage);
        m_model = new GeneratedImageModel(m_mainCanvas.getWidth(), m_mainCanvas.getHeight());
        createOriginalImage();
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                m_model.perturb();
                int result = ImageComparator.compareImage(m_model.draw(), m_originalImage.getPixelReader());
                if(result < m_currentDifference) {
                    m_currentDifference = result;
                    m_model.accept();
                    GraphicsContext gc = m_mainCanvas.getGraphicsContext2D();
                    gc.drawImage(m_model.getImage(), 0, 0);
                }
                
            }
        };
        timer.start();
        
        
        
    }

    private void createGui(Stage primaryStage) {
        m_mainCanvas = new Canvas(1000, 750);
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
        mainPane.getChildren().add(m_mainCanvas);
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

    private void createOriginalImage() {
        URL bale = this.getClass().getClassLoader().getResource("images/christianbale.jpg");
        try {
            m_originalImage = new Image(bale.openStream());
        } catch (IOException ex) {
            Logger.getLogger(GeneticDrawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
