package clase.view;

import java.sql.SQLException;
import java.util.Scanner;

import clase.entity.Clase;
import clase.entity.NoExisteClase;
import universidad.view.InputTypes;

public class MenuClase {
	private static int encabezadoMenuClase(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("    Ingrese una opcion      : ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Clase: ");
			System.out.println("2.Listar Clase: ");
			System.out.println("3.Eliminar Clase:");
			System.out.println("4. Modificar Clase ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuClase(Scanner scanner, ClasesView claseV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuClase(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				claseV.addClase();
				break;
			case 2:
				try {
					claseV.listarClase();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					claseV.deleteClase();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					claseV.updateClase();
				} catch (NoExisteClase | SQLException e) {
					System.out.println("No existe clase!");
				}
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("    Ingrese una opcion      : ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar codigo docente");
			System.out.println("2. Modificar la identificacion del semestre ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Clase clase) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				clase.setCodigoDocente(InputTypes.readInt("Ingrese el nuevo codigo del docente: ", scanner));
				break;
			case 2:
				clase.setIdSemestre(
						InputTypes.readInt("Ingrese el nuevo codigo de identificacion del semestre: ", scanner));
				break;
			}
		}
	}
}