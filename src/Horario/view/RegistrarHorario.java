package Horario.view;

import java.util.Date;
import java.util.Scanner;

import Horario.entity.Horario;
import universidad.view.InputTypes;


public class RegistrarHorario {
	public static Horario ingresarHorario(Scanner scanner)
	{
		int codigoHorario=InputTypes.readInt("Ingrese el codigo del horario:", scanner);
		String paralelo=InputTypes.readString("Paralelo:", scanner);
		int idClase=InputTypes.readInt("Codigo de identificacion de la clase:", scanner);
		String modalidad=InputTypes.readString("Modalidad: ", scanner);
		Date fechaInicio= InputTypes.readDate("Fecha de inicio:", scanner);
		Date fechaFinal= InputTypes.readDate("Fecha final:", scanner);
		
		return new Horario(codigoHorario, paralelo,idClase, modalidad, fechaInicio, fechaFinal);
	}

}
