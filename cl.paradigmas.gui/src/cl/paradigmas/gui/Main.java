package cl.paradigmas.gui;
import javax.swing.JToggleButton;


public class Main {

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ParadigmasToolBar toolbar = ventana.getToolbar();
		Canvas canvas = ventana.getCanvas();
		EventBuilder eventos = EventBuilder.getEvents(ventana);

		toolbar.addBtn("CIRCULO", new JToggleButton("CIRCULO"));
		toolbar.addBtn("CUADRADO", new JToggleButton("CUADRADO"));
		toolbar.addBtn("MOVER", new JToggleButton("MOVER"));

		toolbar.getBtnLimpiar().addActionListener(eventos);
		toolbar.getBtn("CIRCULO").addActionListener(eventos);
		toolbar.getBtn("CUADRADO").addActionListener(eventos);
		toolbar.getBtn("MOVER").addActionListener(eventos);

		canvas.addMouseListener(eventos);
		canvas.addMouseMotionListener(eventos);

		ventana.setVisible(true);
	}

}