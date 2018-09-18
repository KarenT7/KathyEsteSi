package Materia.View;

import java.sql.SQLException;
import java.util.Scanner;

import Materia.entity.Materia;
import Materia.entity.MateriaNoRegistrada;
import universidad.view.InputTypes;



public class MenuMateria {
	private static int encabezadoMenuMateria(Scanner scanner)
	{
		int opcion;
		while(true)
		{
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Materia: ");
			System.out.println("2.Listar Materias: ");
			System.out.println("3.Eliminar Materia:");
			System.out.println("4.Modificar Materia:");
			System.out.println("0.Salir");
			System.out.println();

			opcion=InputTypes.readInt("¿Su Opcion?", scanner);
			if(opcion >=0 && opcion<=4)
			{return opcion;}
		}

	}
	public static void menuMateria(Scanner scanner, MateriaView materiaView) throws ClassNotFoundException, SQLException {
	
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuMateria(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				materiaView.addMateria();
				break;
			case 2:
				try {
					materiaView.listarMaterias();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					materiaView.deleteMateria();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
			
				try {
					materiaView.updateMateria();
				} catch (MateriaNoRegistrada e) {
					e.printStackTrace();
				}
	
			}
		}
	}
	public static int encabezadoModificarMateria(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar Codigo de la Materia");
			System.out.println("2. Modificar Creditos ");
			System.out.println("3. Modificar Estado ");
			System.out.println("4. Modificar IdClase ");
			System.out.println("5. Modificar IdCarrera ");
            System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}
	public static void ModificarMateria(Scanner scanner, Materia materia) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarMateria(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				materia.setCodigoMateria(InputTypes.readInt("Ingrese el nuevo codigo de la materia: ", scanner));
				break;
			case 2:
				materia.setCreditos(InputTypes.readInt("Ingrese el nuevo numero de creditos: ", scanner));
				break;
			case 3:
				materia.setEstado(InputTypes.readString("Ingrese el nuevo estado de la materia(aprobado/reprobado/en curso): ", scanner));
				break;
			case 4:
				materia.setIdClase(InputTypes.readInt("Ingrese el nuevo codigo de la Clase: ", scanner));
				break;
			case 5:
				materia.setIdCarrera(InputTypes.readInt("Ingrese el nuevo codigo de la carrera: ", scanner));
				break;
			
				
			}

}
	
	}}
