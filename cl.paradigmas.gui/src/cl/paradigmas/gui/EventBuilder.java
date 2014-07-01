package cl.paradigmas.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JToggleButton;

final public class EventBuilder implements ActionListener, 
MouseMotionListener, MouseListener{

public static EventBuilder singleton;
public Ventana ventana;
public Canvas canvas;
public ParadigmasToolBar toolbar;

private EventBuilder(Ventana v) {
this.ventana = v;
this.canvas = v.getCanvas();
this.toolbar = v.getToolbar();
}

public static EventBuilder getEvents(Ventana v){
if(singleton != null) {
return singleton;
}
return new EventBuilder(v);
}

@Override
public void mouseClicked(MouseEvent e) 
{
	if(ventana.getSeleccionado()==Ventana.CIRCULO){
		canvas.addDibujable(new Circulo(e.getPoint(), 10));
		canvas.repaint();
}
	else
	{
		if(ventana.getSeleccionado()==Ventana.CUADRADO)
		{
			canvas.addDibujable(new Cuadrado(e.getPoint(), 30));
			canvas.repaint();
		}
	}
}

@Override
public void mouseEntered(MouseEvent arg0) {

}

@Override
public void mouseExited(MouseEvent arg0) {

}

@Override
public void mousePressed(MouseEvent e) 
{
	if (ventana.getSeleccionado()==Ventana.MOVER) {
		for (Dibujable dibujo : canvas.getDibujos()) {
			if (dibujo instanceof Circulo &&
				((Circulo) dibujo).isHere(e.getPoint())) {
					canvas.setDibujoSeleccionado(dibujo);
					canvas.repaint();		
			}/*
			else{
				if (dibujo instanceof Cuadrado &&
				((Cuadrado) dibujo).isHere(e.getPoint())) {
					canvas.setDibujoSeleccionado(dibujo);
					canvas.repaint();		
					}
				}*/
		}
	}
}



@Override
public void mouseReleased(MouseEvent arg0) 
{
	if (ventana.getSeleccionado()==Ventana.MOVER) 
	{
		canvas.setDibujoSeleccionado(null);
	}
}

@Override
public void mouseDragged(MouseEvent e) 
{
	if (ventana.getSeleccionado()==Ventana.MOVER
		&& canvas.getDibujoSeleccionado()!=null) 
	{
		Circulo c = (Circulo)canvas.getDibujoSeleccionado();
		c.setPosicion(e.getPoint());
		canvas.repaint();
		/*
		Cuadrado k = (Cuadrado)canvas.getDibujoSeleccionado();
		k.setPosicion(e.getPoint());
		canvas.repaint();*/
	}
}

@Override
public void mouseMoved(MouseEvent e) 
{
	if (ventana.getSeleccionado()!=Ventana.CIRCULO) {
		for (Dibujable dib : canvas.getDibujos()) {
			if (((Circulo)dib).isHere(e.getPoint())) 
			{
				((Circulo)dib).setColor(Color.orange);
			} 
			else 
			{
				((Circulo)dib).setColor(Color.yellow);
			}
			canvas.repaint();
		}
	}/*
	else
	{
		if (ventana.getSeleccionado()!=Ventana.CUADRADO) {
			for (Dibujable dib : canvas.getDibujos()) {
				if (((Cuadrado)dib).isHere(e.getPoint())) 
				{
					((Cuadrado)dib).setColor(Color.blue);
				} 
				else 
				{
					((Cuadrado)dib).setColor(Color.red);
				}
				canvas.repaint();
			}
		}
	}*/
}

@Override
public void actionPerformed(ActionEvent e) {

//se ubica el origen del evento
	Object source = e.getSource();

	if (source instanceof JButton){
//como es instancia de JButton se castea source a JButton
		JButton btn = (JButton)source;
		if (btn.getText().equals("LIMPIAR")) 
		{
			canvas.limpiar();
		}
		}
		else 
			if(source instanceof JToggleButton){
//como es instancia de JToggleButton se castea source a JToggleButton
				JToggleButton btn = (JToggleButton)source;

				if(btn.getText().equals("CIRCULO")){
					ventana.setSeleccionado(Ventana.CIRCULO);
				} 
				else 
					if(btn.getText().equals("MOVER"))
					{
						ventana.setSeleccionado(Ventana.MOVER);
					}
				
				if(btn.getText().equals("CUADRADO")){
					ventana.setSeleccionado(Ventana.CUADRADO);
				}
				/* 
				else 
					if(btn.getText().equals("MOVER"))
					{
						ventana.setSeleccionado(Ventana.MOVER);
					}*/
			}

	}
}
