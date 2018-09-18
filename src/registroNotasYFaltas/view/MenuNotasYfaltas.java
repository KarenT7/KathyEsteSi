package registroNotasYFaltas.view;

import java.sql.SQLException;
import java.util.Scanner;

import registroNotasYFaltas.entity.NoExisteClase;
import registroNotasYFaltas.entity.NotasYfaltas;
import universidad.view.InputTypes;

public class MenuNotasYfaltas {
	private static int encabezadoMenuNotasYfaltas(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Notas y faltas: ");
			System.out.println("2.Listar Notas y faltas: ");
			System.out.println("3.Eliminar Registro de notas y faltas:");
			System.out.println("4. Modificar Registro de notas y faltas ");
			// System.out.println("5. Productos por Categoría ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuNotasYfaltas(Scanner scanner, NotasYfaltasView notasYfaltasV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuNotasYfaltas(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				notasYfaltasV.addNotasYfaltas();
				break;
			case 2:
				try {
					notasYfaltasV.listarNotasYfaltas();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				try {
					notasYfaltasV.deleteNotasYfaltas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			case 4:
				try {
					notasYfaltasV.updateNotasYfaltas();
				} catch (NoExisteClase | SQLException e) {
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
			System.out.println("1. Modificar numero de faltas");
			System.out.println("2. Modificar dato del parcial ");
			System.out.println("3. Modificar dato de la nota final ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, NotasYfaltas notasYfaltas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				notasYfaltas.setFaltas(InputTypes.readInt("Ingrese el nuevo numero de faltas: ", scanner));
				break;
			case 2:
				notasYfaltas.setParcial(
						InputTypes.readInt("Ingrese el nuevo dato del parcial : ", scanner));
				break;
			case 3:
				notasYfaltas.setNotaFinal(InputTypes.readInt("Ingrese la nueva nota final", scanner));
			}
		}
	}
}