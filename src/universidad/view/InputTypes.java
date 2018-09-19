package universidad.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

	public class InputTypes {

		public static int readInt(String mensaje, Scanner scanner) {
			int valor = 0;
			while (true) {
				try {
					System.out.print(mensaje);
					valor = scanner.nextInt();
					scanner.nextLine();
					break;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Debe ingresar valores numericos ! ");
					scanner.nextLine();
				}
			}
			return valor;
		}

		public static String readString(String mensaje, Scanner scanner) {
			String palabra = null;
			while (true) {
				try {
					System.out.print(mensaje);
					palabra = scanner.nextLine();
					break;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Debe ingresar valores tipo caracter ! ");
				}
			}
			return palabra;
		}

		public static double readDouble(String mensaje, Scanner scanner) {
			double decimal = 0;
			while (true) {
				try {
					System.out.print(mensaje);
					decimal = scanner.nextDouble();
					scanner.nextLine();
					break;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Debe ingresar valores numericos ! ");
					scanner.nextLine();
				}
			}
			return decimal;
		}

		public static Date readDate(String msg, Scanner leer) {
			Date fecha;
			DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			while (true) {
				System.out.print(msg);
				try {
					fecha = formato.parse(leer.nextLine());
					return fecha;
				} catch (ParseException e) {
					System.out.println("Error en el formato de fecha");
				}
			}
		}

		public static boolean readBoolean(String mensaje, Scanner scanner) {

			boolean valor = false;
			while (true) {
				try

				{
					System.out.print(mensaje);
					valor = scanner.nextBoolean();
					scanner.nextLine();

					break;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Debe ingresar true(si) o false(no)");
					scanner.nextLine();
				}
			}

			return valor;
		}
	}
