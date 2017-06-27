/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticDrawModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author jgonis
 */
public class GeneratedImageModel {

    private final Canvas m_canvas;
    private final Random m_rand = new Random();

    public GeneratedImageModel( double canvasWidth, double canvasHeight) {
        m_canvas = new Canvas(canvasWidth, canvasHeight);

    }

    public void perturb() {        
    }

    public PixelReader draw() {
        return null;
    }

    public Image getImage() {
        WritableImage image = m_canvas.snapshot(null, null);
        return image;
    }

    public void accept() {
    }
}
