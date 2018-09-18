package registroNotasYFaltas.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import registroNotasYFaltas.entity.NoExisteClase;
import registroNotasYFaltas.entity.NotasYfaltas;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class NotasYfaltasView {
	private Conexion conexion;
	private Scanner scanner;

	public NotasYfaltasView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addNotasYfaltas() {
		NotasYfaltas notasYfaltas = RegistroNotasYfaltas.ingresarNotasYfaltas(scanner);
		String sql = "Insert into notasyfaltas ( Faltas, Parcial, NotaFinal)" + "values(?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, notasYfaltas.getFaltas());
			conexion.getSentencia().setInt(2, notasYfaltas.getParcial());
			conexion.getSentencia().setInt(3, notasYfaltas.getNotaFinal());

			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void deleteNotasYfaltas() throws SQLException {
		int idClase = InputTypes.readInt("Código identificacion de la clase: ", scanner);
		String sql = "delete " + "from notasyfaltas " + "where IdClase = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idClase);
		conexion.modificacion();
	}

	public void updateNotasYfaltas() throws NoExisteClase, SQLException {
		ResultSet resultSet;
		NotasYfaltas notasYfaltas;
		int faltas;
		int parcial;
		int notaFinal ;
		int idClase = InputTypes.readInt("Identificacion del Código de la Clase: ", scanner);
		String sql = "select * from notasyfaltas where IdClase = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idClase);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			faltas = resultSet.getInt("Faltas");
			parcial = resultSet.getInt("Parcial");
			notaFinal = resultSet.getInt("NotaFinal");
			notasYfaltas = new NotasYfaltas(idClase, faltas, parcial, notaFinal);
		} else {
			throw new NoExisteClase();
		}

		System.out.println(notasYfaltas);
		MenuNotasYfaltas.menuModificar(scanner, notasYfaltas);

		sql = "update clase set Faltas = ?, Parcial = ?, NotaFinal = ?, where IdClase = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, notasYfaltas.getFaltas());
		conexion.getSentencia().setInt(2, notasYfaltas.getParcial());
		conexion.getSentencia().setInt(3, notasYfaltas.getNotaFinal());

		conexion.modificacion();
	}

	public void listarNotasYfaltas() throws SQLException {
		NotasYfaltas notasYfaltas;
		String sql = "select * from notasYfaltas ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			notasYfaltas = new NotasYfaltas(resultSet.getInt("IdClase"), resultSet.getInt("Faltas"),
					resultSet.getInt("Parcial"), resultSet.getInt("NotaFinal"));
			System.out.println(notasYfaltas);
		}
	}
}
