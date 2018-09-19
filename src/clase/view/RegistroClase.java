package clase.view;

import java.util.Scanner;

import clase.entity.Clase;
import universidad.view.InputTypes;

public class RegistroClase {
	public static Clase ingresarClase(Scanner scanner)
	{
	
		int idClase=InputTypes.readInt("Ingrese su codigo de identificacion de la clase :", scanner);
		int codigoDocente=InputTypes.readInt("Ingrese el codigo  del docente :", scanner);
		int idSemestre=InputTypes.readInt("Ingrese el codigo de identificacion del semestre :", scanner);
		int CodigoEstudiante=InputTypes.readInt("Ingrese su codigo de Estudiante", scanner);
        int CodigoHorario=InputTypes.readInt("Ingrese el codigo de su horario", scanner);
        int IdAula=InputTypes.readInt("Ingrese el codigo de su aula", scanner);

		return new Clase(idClase, codigoDocente, idSemestre,CodigoEstudiante, CodigoHorario, IdAula);
	}

}
