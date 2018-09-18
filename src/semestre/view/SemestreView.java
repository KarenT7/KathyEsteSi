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

	public void addSemestre() throws SQLException {
		Semestre semestre = RegistroSemestre.ingresarSemestre(scanner);
			String sql = "Insert into Semestre ( Modulo, Año)" + "values(?,?)";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, semestre.getModulo());
			conexion.getSentencia().setYear(2,semestre.getAnio().getValue());
			conexion.modificacion();
			
			
}
	
		public void deleteSemestre() throws SQLException {
			int idSemestre = InputTypes.readInt("Código identificacion del semestre: ", scanner);
			String sql = "delete " + "from semestre " + "where IdSemestre = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, idSemestre);
			conexion.modificacion();
		}

	

	public void updateSemestre() throws  SQLException {
		ResultSet resultSet;
		Semestre semestre = null ;
		int  modulo;
		Year anio;
		int idSemestre = InputTypes.readInt("Identificacion del semestre: ", scanner);
		String sql = "select * from semestre where IdSemestre = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idSemestre);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			modulo = resultSet.getInt("Modulo");
			anio = resultSet.getTime("Año");
			semestre = new Semestre(idSemestre, modulo , anio);
		} else {
	//		throw new NoExisteClase();
		}

		System.out.println(semestre);
		MenuSemestre.menuModificar(scanner, semestre);

		sql = "update semestre set Modulo = ?, Año = ? where IdSemestre = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, semestre.getModulo());
		conexion.getSentencia().setDate(2, new java.sql.Date(semestre.getAnio().getTime()));
		conexion.modificacion();
	}

	public void listarSemestre() throws SQLException {
		Semestre semestre;
		String sql = "select * from semestre ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			semestre = new Semestre(resultSet.getInt("IdSemestre"), resultSet.getInt("Modulo"),
					resultSet.getDate("Año"));
			System.out.println(semestre);
		}
	}
}
