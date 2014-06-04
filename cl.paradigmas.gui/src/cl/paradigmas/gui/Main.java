package cl.paradigmas.gui;


public class Main {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		EventBuilder manejador =new EventBuilder();
		ventana.getCanvas().addMouseListener(manejador);
		ventana.getCanvas().addMouseMotionListener(manejador);
	
		/* 
		 * aqui se agregan los botones y 
		 * se agregan los eventos creados en 
		 * EventBuilder
		 * 
		 * */
		ventana.setVisible(true);
	}

}
