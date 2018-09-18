package carrera.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import carrera.entity.Carrera;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class CarreraView {
	private Conexion conexion;
	private Scanner scanner;

	public CarreraView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addCarrera() throws SQLException {
		Carrera carrera = RegistroCarrera.ingresarCarrera(scanner);
		String sql = "Insert into carrera (JefeDeCarrera, Nombre )" + "values(?,?)";
		conexion.consulta(sql);
		conexion.getSentencia().setString(1, carrera.getJefeDeCarrera());
		conexion.getSentencia().setString(2, carrera.getNombreCarrera());

		conexion.modificacion();			
	}

	public void deleteCarrera() throws SQLException {
		int idCarrera = InputTypes.readInt("Código identificacion de la carrera: ", scanner);
		String sql = "delete " + "from carrera " + "where IdCarrera = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idCarrera);
		conexion.modificacion();

	}



	public void updateCarrera() throws  SQLException {
		ResultSet resultSet;
		Carrera carrera = null;
		String JefeDeCarrera;
		String nombreCarrera;
		int idCarrera = InputTypes.readInt("Identificacion del Código de la Carrera: ", scanner);
		String sql = "select * from carrera where IdCarrera = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idCarrera);

		resultSet = conexion.resultado();
		if (resultSet.next()) {
			nombreCarrera = resultSet.getString("Nombre");
			JefeDeCarrera=resultSet.getString("JefeDeCarrera");
			carrera = new Carrera(idCarrera ,JefeDeCarrera, nombreCarrera);
		} else {

		}

		System.out.println(carrera);
		MenuCarrera.menuModificar(scanner, carrera);

		sql = "update carrera set JefeDeCarrera=?, Nombre = ?, where IdCarrera = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, carrera.getNombreCarrera());
		conexion.getSentencia().setString(2, carrera.getJefeDeCarrera());

		conexion.modificacion();
	}

	public void listarCarrera() throws SQLException {
		Carrera carrera;
		String sql = "select * from carrera ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			carrera = new Carrera(resultSet.getInt("IdCarrera"),resultSet.getString("JefeDeCarrera"), resultSet.getString("Nombre"));
			System.out.println(carrera);
		}
	}
}
