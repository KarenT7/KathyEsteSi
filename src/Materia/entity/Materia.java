package Materia.entity;

public class Materia {

	private int codigoMateria;
	private int creditos;
	private String estado;
	private int idCarrera;
	private int idClase;

	public Materia(int codigoMateria, int creditos, String estado, int idCarrera, int idClase) {
		super();
		this.codigoMateria = codigoMateria;
		this.creditos = creditos;
		this.estado = estado;
		this.idCarrera = idCarrera;
		this.idClase = idClase;
	}

	public int getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(int codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	@Override
	public String toString() {
		return "Materia [codigoMateria=" + codigoMateria + ", creditos=" + creditos + ", estado=" + estado
				+ ", idCarrera=" + idCarrera + ", idClase=" + idClase + "]";
	}

}
