package clase.entity;

public class Cuenta {
	
	private int idClase;
	private int  codigoDocente;
	private int idSemestre;
	
	public Cuenta(int idClase, int codigoDocente, int idSemestre) {
		this.idClase = idClase;
		this.codigoDocente = codigoDocente;
		this.idSemestre = idSemestre;
	}

	
	public Integer getIdClase() {
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


	
	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", codigoDocente=" + codigoDocente + ", idSemestre=" + idSemestre + "]";
	}

	
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Cuenta clase = (Cuenta) o;
			if(this.getIdClase()==clase.getIdClase()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getIdClase().hashCode();
	}
	

}
