package clase.entity;

public class Clase {
	
	private int idClase;
	private int  codigoDocente;
	private int idSemestre;
	private int CodigoEstudiante;
	public Clase(int idClase, int codigoDocente, int idSemestre, int codigoEstudiante) {
		super();
		this.idClase = idClase;
		this.codigoDocente = codigoDocente;
		this.idSemestre = idSemestre;
		CodigoEstudiante = codigoEstudiante;
	}
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public int getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
	}
	public int getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
	public int getCodigoEstudiante() {
		return CodigoEstudiante;
	}
	public void setCodigoEstudiante(int codigoEstudiante) {
		CodigoEstudiante = codigoEstudiante;
	}
	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", codigoDocente=" + codigoDocente + ", idSemestre=" + idSemestre
				+ ", CodigoEstudiante=" + CodigoEstudiante + "]";
	}
	
	
	

}
