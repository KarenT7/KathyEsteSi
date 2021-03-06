package Horario.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Docente.entity.DocenteSinRegistro;
import Estudiante.entity.EstudianteNoRegistrado;
import Horario.entity.Horario;
import Horario.entity.NoExisteClaseEnH;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class HorarioView {
	private Conexion conexion;
	private Scanner scanner;

	public HorarioView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addHorario() {
		Horario horario = RegistrarHorario.ingresarHorario(scanner);
		String sql = "Insert into horarios (CodigoHorario, Paralelo, IdClase, Modalidad, FechaInicio, FechaFinal) "
				+ "values(?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, horario.getCodigoHorario());
			conexion.getSentencia().setString(2, horario.getParalelo());
			conexion.getSentencia().setInt(3, horario.getIdClase());
			conexion.getSentencia().setString(4, horario.getModalidad());
			conexion.getSentencia().setDate(5, new java.sql.Date(horario.getFechaInicio().getTime()));
			conexion.getSentencia().setDate(6, new java.sql.Date(horario.getFechaFinal().getTime()));

			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteHorario() throws SQLException {
		int codigoHorario = InputTypes.readInt("C�digo del horario: ", scanner);
		String sql = "delete " + "from horarios " + "where CodigoHorario = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoHorario);
		conexion.modificacion();
	}

	public void updateHorario() throws SQLException, NoExisteClaseEnH {
		ResultSet resultSet;
		Horario horario ;
		String Paralelo;
		String Modalidad;
		int IdClase;
		Date fechaInicio;
		Date fechaFinal;
		int codigoHorario = InputTypes.readInt("C�digo del horario que desee modificar: ", scanner);
		String sql = "select * from horarios where CodigoHorario = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoHorario);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Paralelo = resultSet.getString("Paralelo");
			Modalidad = resultSet.getString("Modalidad");
			IdClase = resultSet.getInt("IdClase");
			fechaInicio = resultSet.getDate("FechaInicio");
			fechaFinal = resultSet.getDate("FechaFinal");

			horario = new Horario(codigoHorario, Paralelo, IdClase, Modalidad, fechaInicio, fechaFinal);
		} else {
			throw new NoExisteClaseEnH();

		}

		System.out.println(horario);
		MenuHorario.ModificarHorario(scanner, horario);
		sql = "update horarios set Paralelo = ?, IdClase = ?, Modalidad = ?, FechaInicio = ?, FechaFinal = ? where CodigoHorario = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, horario.getParalelo());
		conexion.getSentencia().setString(3, horario.getModalidad());
		conexion.getSentencia().setInt(2, horario.getIdClase());
		conexion.getSentencia().setDate(4, new java.sql.Date(horario.getFechaInicio().getTime()));
		conexion.getSentencia().setDate(5, new java.sql.Date(horario.getFechaFinal().getTime()));
		conexion.getSentencia().setInt(6, horario.getCodigoHorario());

		conexion.modificacion();
	}

	public void listarHorario() throws SQLException {
		Horario horario;
		String sql = "select * from horarios ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			horario = new Horario(resultSet.getInt("CodigoHorario"), resultSet.getString("Paralelo"),
					resultSet.getInt("IdClase"), resultSet.getString("Modalidad"), resultSet.getDate("FechaInicio"),
					resultSet.getDate("FechaFinal"));
			System.out.println(horario);
		}
	}
}
