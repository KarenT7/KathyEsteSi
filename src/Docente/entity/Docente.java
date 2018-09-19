package Docente.entity;

import java.util.Date;


public class Docente {
	private int codigoDocente;
	private String nombre;
	private String apellido;
	private int celular;
	private Date fechaNacimiento;

	private String gradoDeTitulacion;
	private int seguroMedico;
	public Docente(int codigoDocente, String nombre, String apellido, String gradoDeTitulacion, int seguroMedico, int celular,Date fechaNacimiento) {
		super();
		this.codigoDocente = codigoDocente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		this.gradoDeTitulacion = gradoDeTitulacion;
		this.seguroMedico = seguroMedico;
	}
	public int getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGradoDeTitulacion() {
		return gradoDeTitulacion;
	}
	public void setGradoDeTitulacion(String gradoDeTitulacion) {
		this.gradoDeTitulacion = gradoDeTitulacion;
	}
	public int getSeguroMedico() {
		return seguroMedico;
	}
	public void setSeguroMedico(int seguroMedico) {
		this.seguroMedico = seguroMedico;
	}
	@Override
	public String toString() {
		return "Docente [codigoDocente=" + codigoDocente + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", celular=" + celular + ", fechaNacimiento=" + fechaNacimiento + ", gradoDeTitulacion="
				+ gradoDeTitulacion + ", seguroMedico=" + seguroMedico + "]";
	}

	
	


}
