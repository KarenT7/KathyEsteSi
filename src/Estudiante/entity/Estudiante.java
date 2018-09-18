package Estudiante.entity;

import java.util.Date;

public class Estudiante {
	private int codigoEstudiante;
	private String Nombre;
	private String Apellido;
	private int CI;
	private Date fechaNacimiento;
	private int telefono;
	private String Direccion;
	private boolean PAA;
	public Estudiante(int codigoEstudiante, String nombre, String apellido,int telefono,String direccion,boolean pAA,
			int cI,Date fechaNacimiento) {
		super();
		this.codigoEstudiante = codigoEstudiante;
		Nombre = nombre;
		Apellido = apellido;
		CI = cI;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		Direccion = direccion;
		PAA = pAA;
	}
	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(int codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public boolean isPAA() {
		return PAA;
	}
	public void setPAA(boolean pAA) {
		PAA = pAA;
	}
	@Override
	public String toString() {
		return "Estudiante [codigoEstudiante=" + codigoEstudiante + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", CI=" + CI + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", Direccion="
				+ Direccion + ", PAA=" + PAA + "]";
	}
	
   
   
   
   
}