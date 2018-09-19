package semestre.view;

import java.sql.SQLException;
import java.util.Scanner;

import semestre.entity.Semestre;
import universidad.view.InputTypes;


public class MenuSemestre {
	private static int encabezadoMenuSemestre(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Semestre: ");
			System.out.println("2.Listar Semestre: ");
			System.out.println("3.Eliminar Semestre:");
			System.out.println("4. Modificar Semestre ");
			// System.out.println("5. Productos por Categoría ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuSemestre(Scanner scanner, SemestreView semestreV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuSemestre(scanner)) {
			case 0:
				
				salir = true;
				break;
			case 1:
				try {
					semestreV.addSemestre();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				break;
		
			case 2:
				try {
					semestreV.listarSemestre();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					semestreV.deleteSemestre();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			case 4:
				try {
					semestreV.updateSemestre();
				} catch (  SQLException e) {
					System.out.println("No existe clase!");
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
			System.out.println("1. Modificar modulo");
			System.out.println("2. Modificar  Año ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Semestre semestre) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				semestre.setModulo(InputTypes.readInt("Ingrese el nuevo modulo: ", scanner));
				break;
			case 2:
				semestre.setAnio(InputTypes.readInt("Ingrese el nuevo anio: ", scanner));
				break;
			}
		}
	}
}