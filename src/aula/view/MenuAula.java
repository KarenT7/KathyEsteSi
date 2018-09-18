package aula.view;

import java.sql.SQLException;
import java.util.Scanner;

import aula.entity.Aula;
import universidad.view.InputTypes;

public class MenuAula {
	private static int encabezadoMenuAula(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Aula: ");
			System.out.println("2.Listar Aula: ");
			System.out.println("3.Eliminar Aula:");
			System.out.println("4. Modificar Aula ");
			// System.out.println("5. Productos por Categoría ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuAula(Scanner scanner, AulaView aulaV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuAula(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				aulaV.addAula();
				break;
			case 2:
				try {
					aulaV.listarAula();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					aulaV.deleteAula();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			case 4:
				try {
					aulaV.updateAula();
				} catch ( SQLException e) {
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
			System.out.println("1. Modificar codigo de identificacion del aula ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Aula aula) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				aula.setIdClase(InputTypes.readInt("Ingrese el nuevo codigo de identificacion del aula: ", scanner));
				break;
		
			}
		}
	}


}