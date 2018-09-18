package cuenta.view;

import java.util.Scanner;

import cuenta.entity.Cuenta;
import universidad.view.InputTypes;

public class RegistroCuenta {
	public static Cuenta ingresarCuenta(Scanner scanner)
	{
	
		int codigoCuenta=InputTypes.readInt("Ingrese su codigo de la cuenta del estudiante :", scanner);
		double saldoApagar = InputTypes.readDouble("Ingrese el saldo pendiente o el saldo a pagar", scanner);
		double importePagado = InputTypes.readDouble("Ingrese el importe pagado", scanner);
		double descuentoBeca = InputTypes.readDouble("Ingrese el descuento por Beca ", scanner);
		String planDePagos = InputTypes.readString("Ingrese el plan de pagos ", scanner);
		int CodigoEstudiante=InputTypes.readInt("Ingrese su codigo de estudiante", scanner);
		return new Cuenta(codigoCuenta, saldoApagar , importePagado, descuentoBeca, planDePagos, CodigoEstudiante);
	}

}
