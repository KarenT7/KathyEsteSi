package Docente.View;

import java.sql.SQLException;
import java.util.Scanner;

import Docente.entity.Docente;
import Docente.entity.DocenteSinRegistro;
import universidad.view.InputTypes;


public class MenuDocente {
	private static int encabezadoMenuDocente(Scanner scanner)
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
	public static void menuDocente(Scanner scanner, DocenteView docenteV) throws ClassNotFoundException, SQLException {
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuDocente(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				docenteV.addDocente();
				break;
			case 2:
				try {
					docenteV.listarDocente();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					docenteV.deleteDocente();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					docenteV.updateDocente();
				} catch (DocenteSinRegistro e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static int encabezadoModificarDocente(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar Codigo de Docente");
			System.out.println("2. Modificar Nombres ");
			System.out.println("3. Modificar Apellidos ");
			System.out.println("4. Modificar Grado de Titulacion ");
			System.out.println("5. Modificar numero de Seguro Medico ");
			System.out.println("6. Modificar Fecha de Nacimiento ");
			System.out.println("7. Modificar Celular ");
            System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 7) {
				return opcion;
			}
		}
	}
	public static void ModificarDocente(Scanner scanner, Docente docente) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarDocente(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				docente.setCodigoDocente(InputTypes.readInt("Ingrese el nuevo codigo del docente: ", scanner));
				break;
			case 2:
				docente.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				docente.setApellido(InputTypes.readString("Ingrese el nuevo Apellido: ", scanner));
				break;
			case 4:
				docente.setGradoDeTitulacion(InputTypes.readString("Ingrese el nuevo grado  de titulacion: ", scanner));
				break;
			case 5:
				docente.setNumeroSeguroMedico(InputTypes.readInt("Ingrese el nuevo numero de seguro medico: ", scanner));
				break;
			case 6:
				docente.setFechaNacimiento(InputTypes.readInt("Ingrese la nueva fecha de nacimiento: ", scanner));
				break;
			case 7:
				docente.setCelular(InputTypes.readInt("Ingrese el nuevo celular: ", scanner));
				break;
				
			}

}
	
	}}
