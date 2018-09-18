package universidad.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import universidad.control.Conexion;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			universidad.view.MenuOficial.menú(scanner);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}
