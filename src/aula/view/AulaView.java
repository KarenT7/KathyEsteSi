package aula.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import aula.entity.Aula;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class AulaView {
	private Conexion conexion;
	private Scanner scanner;

	public AulaView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addAula() {
		Aula aula = RegistroAula.ingresarAula(scanner);
			String sql = "Insert into aula ( IdClase)" + "values(?)";
			try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, aula.getIdClase());
			conexion.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
}
	
		public void deleteAula() throws SQLException {
			int idClase = InputTypes.readInt("Código identificacion del aula: ", scanner);
			String sql = "delete " + "from aula " + "where IdAula = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, idClase);
			conexion.modificacion();

		}

	

	public void updateAula() throws SQLException {
		ResultSet resultSet;
		Aula aula = null;
		int  idClase;
		int idAula = InputTypes.readInt("Identificacion del Código del aula: ", scanner);
		String sql = "select * from aula where IdAula = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idAula);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			idClase = resultSet.getInt("IdClase");
			aula = new Aula(idAula, idClase );
		} else {
		}

		System.out.println(aula);
		MenuAula.menuModificar(scanner, aula);

		sql = "update aula set IdClase = ?,   where IdAula = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, aula.getIdClase());
		conexion.modificacion();
	}

	public void listarAula() throws SQLException {
		Aula aula;
		String sql = "select * from aula ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			aula = new Aula(resultSet.getInt("IdAula"), resultSet.getInt("IdClase"));
			System.out.println(aula);
		}
	}
}
