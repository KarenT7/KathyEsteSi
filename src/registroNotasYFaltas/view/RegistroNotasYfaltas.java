package registroNotasYFaltas.view;

import java.util.Scanner;

import registroNotasYFaltas.entity.NotasYfaltas;
import universidad.view.InputTypes;

public class RegistroNotasYfaltas {
	public static NotasYfaltas ingresarNotasYfaltas(Scanner scanner)
	{
	
		int idClase=InputTypes.readInt("Ingrese su codigo de identificacion de la clase :", scanner);
		int faltas=InputTypes.readInt("Ingrese el numero de faltas del estudiante :", scanner);
		int parcial=InputTypes.readInt("Ingrese la nota del parcial :", scanner);
		int notaFinal=InputTypes.readInt("Ingrese la nota final del estudiante :", scanner);

		
		return new NotasYfaltas(idClase, faltas, parcial, notaFinal);
	}

}
