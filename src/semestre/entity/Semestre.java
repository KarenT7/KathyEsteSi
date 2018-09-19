package semestre.entity;

public class Semestre {
	private int idSemestre;
	private int modulo;
	private int anio;

	public Semestre(int idSemestre, int modulo, int anio) {
		super();
		this.idSemestre = idSemestre;
		this.modulo = modulo;
		this.anio = anio;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Semestre [idSemestre=" + idSemestre + ", modulo=" + modulo + ", anio=" + anio + "]";
	}

}
