package Docente.entity;

public class DocenteSinRegistro extends Exception{ 
	private static final long serialVersionUID =1L;
	public DocenteSinRegistro()
	{ super ("El docente no se halla registrado en esta universidad");}


}
