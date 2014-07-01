package cl.paradigmas.gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Circulo implements Dibujable, Comparable<Circulo>{

	private Point posicion;
	private Color color;
	private int radius;
	private int id;
	private static int total=0;

	public Circulo(Point posicion, int radius){
		this.posicion = new Point();
		this.posicion.x=posicion.x-radius;
		this.posicion.y=posicion.y-radius;
		this.radius = radius;
		this.color = Color.yellow;
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
		this.posicion.x=posicion.x-radius;
		this.posicion.y=posicion.y-radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(posicion.x, posicion.y, radius*2, radius*2);
	}

	public boolean isHere(Point p) {
		Point pt = new Point();
		pt.x=p.x-radius;
		pt.y=p.y-radius;
		if (Math.abs(pt.distance(this.posicion)) <= radius)
			return true;
		return false;
	}

	public int getId() {
		return id;
	}

	public boolean equals(Object o) {
		return ((o instanceof Circulo) && 
				(((Circulo)o).id == this.id));
	}

	@Override
	public int compareTo(Circulo c) {
		if (c.id>this.id){
			return 1;
		} else if(c.id<this.id) {
			return -1;
		}
		return 0;
	}


}