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

    private final ArrayList<Triangle> m_imageModel;
    private ArrayList<Triangle> m_candidateModel;
    private final Canvas m_canvas;
    private final Random m_rand = new Random();

    public GeneratedImageModel(int numberOfTriangles, double canvasWidth, double canvasHeight) {
        m_imageModel = new ArrayList<>(numberOfTriangles);
        for(int i = 0; i < numberOfTriangles; i++) {
            Triangle temp = new Triangle(m_rand, canvasWidth, canvasHeight);
            m_imageModel.add(temp);
        }
        m_canvas = new Canvas(canvasWidth, canvasHeight);

    }

    public void perturb() {
        m_candidateModel = new ArrayList<>(m_imageModel.size());
        for(Triangle t : m_imageModel) {
            try {
                m_candidateModel.add(t.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GeneratedImageModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public PixelReader draw() {
        GraphicsContext gc = m_canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, m_canvas.getWidth(), m_canvas.getHeight());
        Iterator<Triangle> it = m_imageModel.iterator();
        while (it.hasNext()) {
            it.next().draw(gc);
        }
        return null;
    }

    public Image getImage() {
        WritableImage image = m_canvas.snapshot(null, null);
        return image;
    }

    public void accept() {
    }

}
