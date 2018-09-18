package registroNotasYFaltas.entity;

public class NotasYfaltas {
	
	private int idClase;
	private int faltas;
	private int parcial;
	private int notaFinal;
	
	public NotasYfaltas(int idClase, int faltas, int parcial, int notaFinal) {
		super();
		this.idClase = idClase;
		this.faltas = faltas;
		this.parcial = parcial;
		this.notaFinal = notaFinal;
	}

	public int  getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getParcial() {
		return parcial;
	}

	public void setParcial(int parcial) {
		this.parcial = parcial;
	}

	public int getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	
	@Override
	public String toString() {
		return "NotasYfaltas [idClase=" + idClase + ", faltas=" + faltas + ", parcial=" + parcial + ", notaFinal="
				+ notaFinal + "]";
	}
/*******************************************
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			NotasYfaltas notasYfaltas = (NotasYfaltas) o;
			if(this.getIdClase()==notasYfaltas.getIdClase()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getIdClase().hashCode();
	}
	***************************************/

}
