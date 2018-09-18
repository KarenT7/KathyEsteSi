package Transporte.view;

import java.util.Scanner;

import Transporte.entity.Transporte;
import universidad.view.InputTypes;



public class RegistroTransporte {
	public static Transporte ingresarVehiculo(Scanner scanner)
	{
		int CodigoVehiculo=InputTypes.readInt("Ingrese su codigo de vehiculo:", scanner);
		int CodigoEstudiante=InputTypes.readInt("Ingrese su codigo de Estudiante:", scanner);
		String Placa=InputTypes.readString("Placa:", scanner);
		String Marca=InputTypes.readString("Marca: ", scanner);
		String Color=InputTypes.readString("Color del vehiculo:", scanner);
        boolean Soat=InputTypes.readBoolean("Soat  true(si)/false(no)", scanner);

		return new Transporte(CodigoVehiculo,CodigoEstudiante, Placa,Marca, Color, Soat);
	}

}
