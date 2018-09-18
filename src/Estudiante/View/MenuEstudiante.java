package Estudiante.View;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.entity.Estudiante;
import Estudiante.entity.EstudianteNoRegistrado;
import universidad.control.Conexion;
import universidad.view.InputTypes;



public class MenuEstudiante {
	private static int encabezadoMenuEstudiante(Scanner scanner)
	{
		int opcion;
		while(true)
		{
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Estudiante: ");
			System.out.println("2.Listar Estudiantes: ");
			System.out.println("3.Eliminar Estudiante:");
			System.out.println("4.Modificar Estudiante:");
			System.out.println("0.Salir");
			System.out.println();

			opcion=InputTypes.readInt("¿Su Opcion?", scanner);
			if(opcion >=0 && opcion<=4)
			{return opcion;}
		}

	}
	public static void menuEstudiante(Scanner scanner, EstudiantesView estudiantesView) throws ClassNotFoundException, SQLException {
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuEstudiante(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				estudiantesView.addEstudiante();
				break;
			case 2:
				try {
					estudiantesView.listarEstudiate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					estudiantesView.deleteEstudiante();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					estudiantesView.update();
				} catch (EstudianteNoRegistrado e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static int encabezadoModificarEstudiante(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar Codigo de Estudiante");
			System.out.println("2. Modificar Nombres ");
			System.out.println("3. Modificar Apellidos ");
			System.out.println("4. Modificar Fecha de Nacimiento ");
			System.out.println("5. Modificar Telefono ");
			System.out.println("6. Modificar Direccion ");
			System.out.println("7. Modificar PAA ");
			System.out.println("8. Modificar CI ");
            System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 8) {
				return opcion;
			}
		}
	}
	public static void ModificarEstudiante(Scanner scanner, Estudiante estudiante) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarEstudiante(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				estudiante.setCodigoEstudiante(InputTypes.readInt("Ingrese el nuevo codigo de Estudiante: ", scanner));
				break;
				
			case 2:
				estudiante.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				estudiante.setApellido(InputTypes.readString("Ingrese el nuevo Apellido: ", scanner));
				break;
				
			case 4:
				estudiante.setFechaNacimiento(InputTypes.readDate("Ingrese la nueva fecha de nacimiento: ", scanner));
				break;
			case 5:
				estudiante.setTelefono(InputTypes.readInt("Ingrese el nuevo telefono: ", scanner));
				break;
			case 6:
				estudiante.setDireccion(InputTypes.readString("Ingrese la nueva Direccion: ", scanner));
				break;
			case 7:
				estudiante.setPAA(InputTypes.readBoolean("Ingrese el nuevo estado de la PAA: ", scanner));
				break;
			case 8:
				estudiante.setCI(InputTypes.readInt("Ingrese el nuevo Carnet de Estudiante: ", scanner));
				break;
				
			}

}
	
	}}
