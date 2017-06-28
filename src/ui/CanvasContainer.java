package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasContainer {
	
	private Canvas m_canvas;

	public CanvasContainer(double width, double height) {
		m_canvas = new Canvas(width, height);
	}
	
	public Canvas getCanvas() {
		return m_canvas;
	}
	
	public void reset() {
		GraphicsContext gc = m_canvas.getGraphicsContext2D();
		gc.beginPath();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, m_canvas.getWidth(), m_canvas.getHeight());
		gc.fill();
	}
	
	public void setWidth(double width) {
		m_canvas.setWidth(width);
		this.reset();
		this.drawBorder();
	}
	
	public void setHeight(double height) {
		m_canvas.setHeight(height);
		this.reset();
		this.drawBorder();
	}
	
	public void drawBorder() {
		GraphicsContext gc = m_canvas.getGraphicsContext2D();
		gc.beginPath();
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		gc.rect(0, 0, m_canvas.getWidth(), m_canvas.getHeight());
		gc.stroke();
	}

}
