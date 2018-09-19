package Horario.entity;

import java.util.Date;

public class Horario {
	private int codigoHorario;
	private String paralelo;
    private int idClase;
    private String modalidad;
    private Date fechaInicio;
    private Date fechaFinal;
	public Horario(int codigoHorario, String paralelo, int idClase, String modalidad, Date fechaInicio,
			Date fechaFinal) {
		super();
		this.codigoHorario = codigoHorario;
		this.paralelo = paralelo;
		this.idClase = idClase;
		this.modalidad = modalidad;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	public int getCodigoHorario() {
		return codigoHorario;
	}
	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}
	public String getParalelo() {
		return paralelo;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	@Override
	public String toString() {
		return "Horario [codigoHorario=" + codigoHorario + ", paralelo=" + paralelo + ", idClase=" + idClase
				+ ", modalidad=" + modalidad + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + "]";
	}

}
