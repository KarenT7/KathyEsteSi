package carrera.view;

import java.util.Scanner;

import carrera.entity.Carrera;
import universidad.view.InputTypes;

public class RegistroCarrera {
	public static Carrera ingresarCarrera(Scanner scanner)
	{
	
		int idCarrera=InputTypes.readInt("Ingrese su codigo de identificacion de la carrera :", scanner);
		String nombre=InputTypes.readString("Ingrese el nombre de la carrera:", scanner);
        String JefeDeCarrera=InputTypes.readString("Ingrese el nombre del jefe de a carrera: ", scanner);

		return new Carrera(idCarrera,JefeDeCarrera, nombre);
	}

}
