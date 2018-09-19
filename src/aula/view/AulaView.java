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

	public void addAula() throws SQLException {
		Aula aula = RegistroAula.ingresarAula(scanner);
			String sql = "Insert into aula (IdAula, NumeroAula)" + "values(?,?)";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, aula.getIdAula());
			conexion.getSentencia().setInt(2, aula.getNumeroAula());
			conexion.modificacion();

}
	
		public void deleteAula() throws SQLException {
			int IdAula = InputTypes.readInt("Código identificacion del aula: ", scanner);
			String sql = "delete " + "from aula " + "where IdAula = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, IdAula);
			conexion.modificacion();

		}

	

	public void updateAula() throws SQLException {
		ResultSet resultSet;
		Aula aula = null;
		int  NumeroAula;
		int idAula = InputTypes.readInt("Identificacion del Código del aula: ", scanner);
		String sql = "select * from aula where IdAula = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idAula);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			NumeroAula = resultSet.getInt("NumeroAula");
			aula = new Aula(idAula, NumeroAula );
		} else {
		}

		System.out.println(aula);
		MenuAula.menuModificar(scanner, aula);

		sql = "update aula set IdClase = ?   where IdAula = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, aula.getIdAula());
		conexion.getSentencia().setInt(2, aula.getNumeroAula());

		conexion.modificacion();
	}

	public void listarAula() throws SQLException {
		Aula aula;
		String sql = "select * from aula ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			aula = new Aula(resultSet.getInt("IdAula"), resultSet.getInt("NumeroAula"));
			System.out.println(aula);
		}
	}
}
