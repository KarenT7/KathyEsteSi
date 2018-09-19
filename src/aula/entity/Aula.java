package aula.entity;

public class Aula {
	private int  idAula;	
	private int NumeroAula;
	public Aula(int idAula, int numeroAula) {
		super();
		this.idAula = idAula;
		NumeroAula = numeroAula;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getNumeroAula() {
		return NumeroAula;
	}
	public void setNumeroAula(int numeroAula) {
		NumeroAula = numeroAula;
	}
	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", NumeroAula=" + NumeroAula + "]";
	}


}
