package Docente.View;

import java.util.Date;
import java.util.Scanner;

import Docente.entity.Docente;
import universidad.view.InputTypes;

public class RegistroDocente {
	public static Docente ingresarDocente(Scanner scanner)
	{
		int codigoDocente=InputTypes.readInt("Ingrese su codigo de docente:", scanner);
		String nombre=InputTypes.readString("Nombre:", scanner);
		String apellido=InputTypes.readString("Apellido: ", scanner);
		Date fechaNacimiento=InputTypes.readDate("Fecha de nacimiento:", scanner);
		int celular=InputTypes.readInt("Telefono:", scanner);
		String titulacion=InputTypes.readString("grado de titulacion:", scanner);
        int seguroMedico=InputTypes.readInt("numero de seguro medico:", scanner);				

		return new Docente(codigoDocente, nombre,apellido,titulacion,seguroMedico, celular, fechaNacimiento);
	}

}
