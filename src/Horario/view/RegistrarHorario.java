package Horario.view;

import java.sql.Date;
import java.util.Scanner;

import Horario.entity.Horario;
import universidad.view.InputTypes;



public class RegistrarHorario {
	public static Horario ingresarHorario(Scanner scanner)
	{
		int codigoHorario=InputTypes.readInt("Ingrese su codigo de estudiante:", scanner);
		String paralelo=InputTypes.readString("Nombre:", scanner);
		int IdClase=InputTypes.readInt("Carnet de Identidad:", scanner);
		String modalidad=InputTypes.readString("Apellido: ", scanner);
		Date fechaInicio=(Date) InputTypes.readDate("Fecha de nacimiento:", scanner);
		Date fechaFinal=(Date) InputTypes.readDate("Telefono:", scanner);
		
		return new Horario(codigoHorario, paralelo,IdClase, modalidad, fechaInicio, fechaFinal);
	}

}
