package Materia.View;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Materia.entity.Materia;
import Materia.entity.MateriaNoRegistrada;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class MateriaView {
	private Conexion conexion;
	private Scanner scanner;

	public MateriaView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addMateria() {
		Materia materia = RegistrarMateria.ingresarMateria(scanner);
		String sql = "Insert into materia ( Creditos,Estado,IdCarrera,IdClase) " + "values(?,?,?,?)";
		try {
			conexion.consulta(sql);
			// conexion.getSentencia().setInt(1, materia.getCodigoMateria());
			conexion.getSentencia().setInt(1, materia.getCreditos());
			conexion.getSentencia().setString(2, materia.getEstado());
			conexion.getSentencia().setInt(3, materia.getIdCarrera());
			conexion.getSentencia().setInt(4, materia.getIdClase());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void deleteMateria() throws SQLException {
		int codigoMateria = InputTypes.readInt("Código de la materia: ", scanner);
		String sql = "delete " + "from materia " + "where CodigoMateria = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMateria);
		conexion.modificacion();
	}

	public void updateMateria() throws SQLException, MateriaNoRegistrada {
		ResultSet resultSet;
		Materia materia;
		int creditos;
		String estado;
		int idCarrera;
		int idClase;
		int codigoMateria = InputTypes.readInt("Código de la materia: ", scanner);
		String sql = "select * from materia where CodigoMateria = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMateria);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			creditos = resultSet.getInt("Creditos");
			estado = resultSet.getString("Estado");
			idCarrera = resultSet.getInt("IdCarrera");
			idClase = resultSet.getInt("IdClase");

			materia = new Materia(codigoMateria, creditos, estado, idCarrera, idClase);
		} else {
			throw new MateriaNoRegistrada();
		}

		System.out.println(materia);
		MenuMateria.ModificarMateria(scanner, materia);
		sql = "update horarios set Creditos = ?, Estado = ?, IdCarrera = ?,  IdClase = ?,  where CodigoMateria = ?";

		conexion.consulta(sql);
	//	conexion.getSentencia().setInt(1, materia.getCodigoMateria());
		conexion.getSentencia().setInt(1, materia.getCreditos());
		conexion.getSentencia().setString(2, materia.getEstado());
		conexion.getSentencia().setInt(3, materia.getIdCarrera());
		conexion.getSentencia().setInt(4, materia.getIdClase());
		conexion.modificacion();
	}

	public void listarMaterias() throws SQLException {
		Materia materia;
		String sql = "select * from materia ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			materia = new Materia(resultSet.getInt("CodigoMateria"), resultSet.getInt("Creditos"),
					resultSet.getString("Estado"), resultSet.getInt("IdClase"), resultSet.getInt("IdCarrera"));
			System.out.println(materia);
		}
	}
}
