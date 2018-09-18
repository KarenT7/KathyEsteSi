package Materia.View;
import java.util.Scanner;

import Materia.entity.Materia;
import universidad.view.InputTypes;



public class RegistrarMateria {
	public static Materia ingresarMateria(Scanner scanner)
	{
		int codigoMateria=InputTypes.readInt("Ingrese el codigo de la materia:", scanner);
		int creditos=InputTypes.readInt("Cantidad de creditos:", scanner);
		String estado=InputTypes.readString("Aprobado/Reprobado/Cursando: ", scanner);
		int idCarrera=InputTypes.readInt("Ingrese codigo de la carrera:", scanner);
		int idCLase=InputTypes.readInt("Ingrese el codigo de la clase:", scanner);
		
		return new Materia(codigoMateria,creditos, estado, idCarrera, idCLase);
	}

}
