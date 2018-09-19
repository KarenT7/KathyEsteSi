package aula.entity;

public class Aula {
	private int  idAula;	
	private int idClase;

	public Aula(int idAula, int idClase) {
		super();
		this.idAula = idAula;
		this.idClase = idClase;
	}

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", idClase=" + idClase + "]";
	}

}
