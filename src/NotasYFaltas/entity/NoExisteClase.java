package NotasYFaltas.entity;

public class NoExisteClase extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteClase() {
		super("No hay datos de la clase para el registro de notas y faltas");
	}

	
}
