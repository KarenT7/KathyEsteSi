package carrera.view;

import java.sql.SQLException;
import java.util.Scanner;

import carrera.entity.Carrera;
import universidad.view.InputTypes;

public class MenuCarrera {
	private static int encabezadoMenuCarrera(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Carrera: ");
			System.out.println("2.Listar Carrera: ");
			System.out.println("3.Eliminar Carrera:");
			System.out.println("4. Modificar Carrera ");
			// System.out.println("5. Productos por Categoría ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuCarrera(Scanner scanner, CarreraView carreraV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuCarrera(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					carreraV.addCarrera();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					carreraV.listarCarrera();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					carreraV.deleteCarrera();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			case 4:
				try {
					carreraV.updateCarrera();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			/*
			 * case 5:try { claseV.listarClase(); }catch( NoExisteClase e) {
			 * System.out.println("No existe clase!"); }break;
			 */
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar nombre");
		    System.out.println("2. Modificar el jefe de carrera");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Carrera carrera) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:

				salir = true;
				break;
			case 1:
				carrera.setNombreCarrera(InputTypes.readString("Ingrese el nuevo nombre de la carrera : ", scanner));
				break;
		    case 2: carrera.setJefeDeCarrera( InputTypes.readString("Ingrese el nuevo nombre del jefe de Carrera: ", scanner));
		    break;
			}
		}
	}
}