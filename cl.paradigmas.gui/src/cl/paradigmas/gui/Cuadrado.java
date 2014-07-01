package cl.paradigmas.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cuadrado implements Dibujable, Comparable<Cuadrado>{

	private int ancho;
	private Point posicion;
	private Color color;
	private int id;
	private static int total=0;
	
	public Cuadrado(Point posicion, int ancho)
	{
		this.posicion = new Point();
		this.posicion.x=posicion.x;
		this.posicion.y=posicion.y;
		this.ancho=ancho;
		this.color = Color.green;
		total++;
		this.id=total;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}



	public Point getPosicion() {
		return posicion;
	}

	public void cambiarColor(Color color) {
		this.color = color;
	}
	
	public void setPosicion(Point posicion) {
		this.posicion.x=posicion.x;
		this.posicion.y=posicion.y;
	}
	
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(posicion.x, posicion.y, ancho, ancho);
	}
	
	public boolean isHere(Point p) {
		
		Point pt = new Point();
		pt.x=p.x;
		pt.y=p.y;
		
			return true;		
		
	}

	
	public int getId() {
		return id;
	}

	public boolean equals(Object o) {
		return ((o instanceof Cuadrado) && 
				(((Cuadrado)o).id == this.id));
	}

	@Override
	public int compareTo(Cuadrado k) {
		if (k.id>this.id){
			return 1;
		} else if(k.id<this.id) {
			return -1;
		}
		return 0;
	}
}
