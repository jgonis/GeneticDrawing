/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GeneticDrawModel;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author jgonis
 */
class Triangle {
    private ArrayList<Point2D> m_vertices;
    private Color m_color;
    
    public Triangle(Random rand, double width, double height) {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        double a = rand.nextDouble();
        m_color = Color.rgb(r, g, b, a);
        m_vertices = new ArrayList<>(3);
        Point2D.Double point1 = new Point2D.Double(rand.nextInt((int)width), rand.nextInt((int)height));
        Point2D.Double point2 = new Point2D.Double(rand.nextInt((int)width), rand.nextInt((int)height));
        Point2D.Double point3 = new Point2D.Double(rand.nextInt((int)width), rand.nextInt((int)height));
        m_vertices.add(point1);
        m_vertices.add(point2);
        m_vertices.add(point3);
        
        
    }
    
    public void draw(GraphicsContext gc) {
        gc.setFill(m_color);
        gc.beginPath();
        gc.moveTo(m_vertices.get(0).getX(), m_vertices.get(0).getY());
        gc.lineTo(m_vertices.get(1).getX(), m_vertices.get(1).getY());
        gc.lineTo(m_vertices.get(2).getX(), m_vertices.get(2).getY());
        gc.lineTo(m_vertices.get(0).getX(), m_vertices.get(0).getY());
        gc.fill();
        gc.closePath();
    }
    
    
}
