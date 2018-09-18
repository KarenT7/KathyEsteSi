package Docente.View;

import java.util.Scanner;

import Docente.entity.Docente;
import universidad.view.InputTypes;

public class RegistroDocente {
	public static Docente ingresarDocente(Scanner scanner)
	{
		int codigoDocente=InputTypes.readInt("Ingrese su codigo de docente:", scanner);
		String Nombre=InputTypes.readString("Nombre:", scanner);
		String Apellido=InputTypes.readString("Apellido: ", scanner);
		int CI=InputTypes.readInt("Carnet de Identidad:", scanner);
		int fechaNacimiento=InputTypes.readInt("Fecha de nacimiento:", scanner);
		int celular=InputTypes.readInt("Telefono:", scanner);
		String titulacion=InputTypes.readString("Direccion:", scanner);
        int numeroSeguroMedico=InputTypes.readInt("Codigo de la clase:", scanner);				

		return new Docente(codigoDocente, Nombre,Apellido, fechaNacimiento, celular, titulacion, numeroSeguroMedico);
	}

}
