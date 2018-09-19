package cuenta.view;

import java.sql.SQLException;
import java.util.Scanner;

import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;
import universidad.view.InputTypes;

public class MenuCuenta {
	private static int encabezadoMenuCuenta(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Cuenta: ");
			System.out.println("2.Listar Cuenta: ");
			System.out.println("3.Eliminar Cuenta:");
			System.out.println("4. Modificar Cuenta ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuCuenta(Scanner scanner, CuentaView cuentaV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuCuenta(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				cuentaV.addCuenta();
				break;
			case 2:
				try {
					cuentaV.listarCuenta();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					cuentaV.deleteCuenta();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			case 4:
				try {
					cuentaV.updateCuenta();
				} catch (NoExisteCuenta | SQLException e) {
					System.out.println("No existe cuenta!");
				}
				break;
			
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar Saldo a pagar");
			System.out.println("2. Modificar el importe pagado ");
			System.out.println("3. Modificar el descuento por beca ");
			System.out.println("4. Modificar el plan de pagos ");
			System.out.println("5.Modificar codigo de Estudiante");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Cuenta cuenta) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				cuenta.setSaldoApagar(InputTypes.readDouble("Ingrese el nuevo saldo a pagar: ", scanner));
				break;
			case 2:
				cuenta.setImportePagado(InputTypes.readDouble("Ingrese el nuevo Importe Pagado: ", scanner));
				break;
			case 3:
				cuenta.setDescuentoBeca(InputTypes.readDouble("Ingrese el nuevo descuento por Beca: ", scanner));
				break;
			case 4:
				cuenta.setPlanDePagos(InputTypes.readString("Ingrese el nuevo plan de Pagos: ", scanner));
				break;
			case 5:
				cuenta.setCodigoEstudiante(InputTypes.readInt("Ingrese el nuevo codigo del estudiante", scanner));
			}
		}
	}
}