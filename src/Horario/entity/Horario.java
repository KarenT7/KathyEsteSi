package Horario.entity;

import java.sql.Date;

public class Horario {
	private int CodigoHorario;
	private String Paralelo;
    private int IdClase;
    private String Modalidad;
    private Date fechaInicion;
    private Date fechaFinal;
	public Horario(int codigoHorario, String paralelo, int idClase, String modalidad, Date fechaInicion,
			Date fechaFinal) {
		super();
		CodigoHorario = codigoHorario;
		Paralelo = paralelo;
		IdClase = idClase;
		Modalidad = modalidad;
		this.fechaInicion = fechaInicion;
		this.fechaFinal = fechaFinal;
	}
	public int getCodigoHorario() {
		return CodigoHorario;
	}
	public void setCodigoHorario(int codigoHorario) {
		CodigoHorario = codigoHorario;
	}
	public String getParalelo() {
		return Paralelo;
	}
	public void setParalelo(String paralelo) {
		Paralelo = paralelo;
	}
	public int getIdClase() {
		return IdClase;
	}
	public void setIdClase(int idClase) {
		IdClase = idClase;
	}
	public String getModalidad() {
		return Modalidad;
	}
	public void setModalidad(String modalidad) {
		Modalidad = modalidad;
	}
	public Date getFechaInicion() {
		return fechaInicion;
	}
	public void setFechaInicion(Date fechaInicion) {
		this.fechaInicion = fechaInicion;
	}
	public java.sql.Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	@Override
	public String toString() {
		return "Horario [CodigoHorario=" + CodigoHorario + ", Paralelo=" + Paralelo + ", IdClase=" + IdClase
				+ ", Modalidad=" + Modalidad + ", fechaInicion=" + fechaInicion + ", fechaFinal=" + fechaFinal + "]";
	}
    
}
