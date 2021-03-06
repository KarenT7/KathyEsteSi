package Estudiante.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Estudiante.entity.Estudiante;
import Estudiante.entity.EstudianteNoRegistrado;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class EstudiantesView {
	private Conexion conexion;
	private Scanner scanner;

	public EstudiantesView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addEstudiante() {
		Estudiante estudiante = RegistroEstudiante.ingresarEstudiante(scanner);
		String sql = "Insert into estudiante (CodigoEstudiante, Nombres,Apellidos,  Telefono, Direccion, PAA,CI, FechaNacimiento) "
				+ "values(?,?,?,?,?,?,?,?)";
		
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, estudiante.getCodigoEstudiante());
				conexion.getSentencia().setString(2, estudiante.getNombre());
				conexion.getSentencia().setString(3, estudiante.getApellido());
				conexion.getSentencia().setInt(4, estudiante.getTelefono());
				conexion.getSentencia().setString(5, estudiante.getDireccion());
				conexion.getSentencia().setBoolean(6, estudiante.isPAA());
				conexion.getSentencia().setInt(7, estudiante.getCI());
				conexion.getSentencia().setDate(8, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
				
				conexion.modificacion();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	public void deleteEstudiante() throws SQLException {
		int codigoEstudiante = InputTypes.readInt("C�digo del estudiante: ", scanner);
		String sql = "delete " + "from estudiante " + "where CodigoEstudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		conexion.modificacion();
	}

	public void update() throws EstudianteNoRegistrado, SQLException {
		ResultSet resultSet;
		Estudiante estudiante;
		String Nombre;
		String Apellido;
		
		int CI;
		Date fechaNacimiento;
		int telefono;
		String Direccion;
		boolean PAA;
		int IdCLase;

		int codigoEstudiante = InputTypes.readInt("C�digo del estudiante: ", scanner);
		String sql = "select * from estudiante where CodigoEstudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Nombre = resultSet.getString("Nombres");
			Apellido = resultSet.getString("Apellidos");
			CI = resultSet.getInt("CI");
			fechaNacimiento = resultSet.getDate("FechaNacimiento");
			telefono = resultSet.getInt("Telefono");
			Direccion = resultSet.getString("Direccion");
			PAA = resultSet.getBoolean("PAA");

			estudiante = new Estudiante(codigoEstudiante, Nombre, Apellido, telefono,
					Direccion, PAA,CI, fechaNacimiento);
		} else {
			throw new EstudianteNoRegistrado();
		}

		System.out.println(estudiante);
		MenuEstudiante.ModificarEstudiante(scanner, estudiante);
		sql = "update estudiante set Nombres = ?, Apellidos = ?, Telefono = ?,Direccion = ?,PAA =?,  CI = ?, FechaNacimiento = ? where CodigoEstudiante = ?";

		conexion.consulta(sql);
//		conexion.getSentencia().setInt(, estudiante.getCodigoEstudiante());
		conexion.getSentencia().setString(1, estudiante.getNombre());
		conexion.getSentencia().setString(2, estudiante.getApellido());
		conexion.getSentencia().setInt(5, estudiante.getTelefono());
		conexion.getSentencia().setString(6, estudiante.getDireccion());
		conexion.getSentencia().setBoolean(7, estudiante.isPAA());
		conexion.getSentencia().setInt(3, estudiante.getCI());
		conexion.getSentencia().setDate(4, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
		conexion.getSentencia().setInt(8, estudiante.getCodigoEstudiante());

		conexion.modificacion();
	}

	public void listarEstudiate() throws SQLException {
		Estudiante estudiante;
		String sql = "select * from estudiante ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("CodigoEstudiante"),
					resultSet.getString("Nombres"), resultSet.getString("Apellidos"), resultSet.getInt("Telefono"),
					resultSet.getString("Direccion"),
					resultSet.getBoolean("PAA"), 
					resultSet.getInt("CI"),
					resultSet.getDate("FechaNacimiento") );
			System.out.println(estudiante);
		}
	}
}
