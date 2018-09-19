package semestre.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import semestre.entity.Semestre;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class SemestreView {
	private Conexion conexion;
	private Scanner scanner;

	public SemestreView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addSemestre() {
		Semestre semestre = RegistroSemestre.ingresarSemestre(scanner);
		String sql = "Insert into semestre ( IdSemestre, Modulo, A�o)" + "values(?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, semestre.getIdSemestre());
			conexion.getSentencia().setInt(2, semestre.getModulo());
			conexion.getSentencia().setInt(3, semestre.getAnio());
			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteSemestre() throws SQLException {
		int idSemestre = InputTypes.readInt("C�digo identificacion del semestre: ", scanner);
		String sql = "delete " + "from semestre " + "where IdSemestre = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idSemestre);
		conexion.modificacion();
	}

	public void updateSemestre() throws Exception {
		ResultSet resultSet;
		Semestre semestre;
		int modulo;
		int anio;
		int idSemestre = InputTypes.readInt("Identificacion del semestre: ", scanner);
		String sql = "select * from semestre where IdSemestre = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idSemestre);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			modulo = resultSet.getInt("Modulo");
			anio = resultSet.getInt("A�o");
			semestre = new Semestre(idSemestre, modulo, anio);
		} else {
			throw new Exception();
		}

		System.out.println(semestre);
		MenuSemestre.menuModificar(scanner, semestre);

		sql = "update semestre set Modulo = ?, A�o = ? where IdSemestre = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, semestre.getModulo());
		conexion.getSentencia().setInt(2, semestre.getAnio());
		conexion.getSentencia().setInt(3, semestre.getIdSemestre());

		conexion.modificacion();
	}

	public void listarSemestre() throws SQLException {
		Semestre semestre;
		String sql = "select * from semestre ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			semestre = new Semestre(resultSet.getInt("IdSemestre"), resultSet.getInt("Modulo"),
					resultSet.getInt("A�o"));
			System.out.println(semestre);
		}
	}
}
