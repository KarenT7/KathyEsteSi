package Docente.entity;

public class Docente {
	private int codigoDocente;
	private String Nombre;
	private String Apellido;
	private int Celular;
	private int fechaNacimiento;
	private String GradoDeTitulacion;
	private int NumeroSeguroMedico;
	public Docente(int codigoDocente, String nombre, String apellido, int celular, int fechaNacimiento,
			String gradoDeTitulacion, int numeroSeguroMedico) {
		super();
		this.codigoDocente = codigoDocente;
		Nombre = nombre;
		Apellido = apellido;
		Celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		GradoDeTitulacion = gradoDeTitulacion;
		NumeroSeguroMedico = numeroSeguroMedico;
	}
	public int getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
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
	public int getCelular() {
		return Celular;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	public int getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGradoDeTitulacion() {
		return GradoDeTitulacion;
	}
	public void setGradoDeTitulacion(String gradoDeTitulacion) {
		GradoDeTitulacion = gradoDeTitulacion;
	}
	public int getNumeroSeguroMedico() {
		return NumeroSeguroMedico;
	}
	public void setNumeroSeguroMedico(int numeroSeguroMedico) {
		NumeroSeguroMedico = numeroSeguroMedico;
	}
	
	@Override
	public String toString() {
		return "Docente [codigoDocente=" + codigoDocente + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", Celular=" + Celular + ", fechaNacimiento=" + fechaNacimiento + ", GradoDeTitulacion="
				+ GradoDeTitulacion + ", NumeroSeguroMedico=" + NumeroSeguroMedico + "]";
	}
	

}
