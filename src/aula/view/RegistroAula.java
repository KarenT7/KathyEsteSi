package aula.view;

import java.util.Scanner;

import aula.entity.Aula;
import universidad.view.InputTypes;

public class RegistroAula {
	public static Aula ingresarAula(Scanner scanner)
	{
	
		int idAula=InputTypes.readInt("Ingrese el codigo de identificacion del aula :", scanner);
		int idClase=InputTypes.readInt("Ingrese el codigo de identificacion de la clase :", scanner);

		return new Aula(idAula, idClase);
	}

}
