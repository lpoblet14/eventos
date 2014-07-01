package cl.paradigmas.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Canvas extends JPanel {

	private ArrayList<Dibujable> dibujos;
	private Dibujable dibujableTmp;
	private Dibujable dibujoSeleccionado;
	private boolean dibujandoTmp;
	MouseListener ms;

	public Canvas() {
		super.setBackground(Color.white);
		setBorder(BorderFactory.createDashedBorder(Color.black));
		dibujos = new ArrayList<>();
		this.setVisible(true);
	}

	public void addDibujable(Dibujable dibujo){
		dibujos.add(dibujo);
	}

	public ArrayList<Dibujable> getDibujos() {
		return dibujos;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Dibujable dibujo : dibujos) {
			dibujo.dibujar(g);
		}
		if (dibujandoTmp && dibujableTmp!=null) {
			dibujableTmp.dibujar(g);
		}
	}

	public void limpiar(){
		this.dibujos.clear();
		this.repaint();

	}

	public Dibujable getDibujableTmp() {
		return dibujableTmp;
	}

	public void setDibujableTmp(Dibujable dibujableTmp) {
		this.dibujableTmp = dibujableTmp;
	}

	public boolean isDibujandoTmp() {
		return dibujandoTmp;
	}

	public void setDibujandoTmp(boolean dibujandoTmp) {
		this.dibujandoTmp = dibujandoTmp;
	}

	public Dibujable getDibujoSeleccionado() {
		return dibujoSeleccionado;
	}

	public void setDibujoSeleccionado(Dibujable dibujoSeleccionado) {
		this.dibujoSeleccionado = dibujoSeleccionado;
	}


}