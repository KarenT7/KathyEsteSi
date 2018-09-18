package Transporte.entity;

public class Transporte {
	private int CodigoVehiculo;
	private int CodigoEstudiante;
	private String Placa;
	private String Marca;
	private String Color;
	private boolean Soat;
	public Transporte(int codigoVehiculo, int codigoEstudiante, String placa, String marca, String color,
			boolean soat) {
		super();
		CodigoVehiculo = codigoVehiculo;
		CodigoEstudiante = codigoEstudiante;
		Placa = placa;
		Marca = marca;
		Color = color;
		Soat = soat;
	}
	public int getCodigoVehiculo() {
		return CodigoVehiculo;
	}
	public void setCodigoVehiculo(int codigoVehiculo) {
		CodigoVehiculo = codigoVehiculo;
	}
	public int getCodigoEstudiante() {
		return CodigoEstudiante;
	}
	public void setCodigoEstudiante(int codigoEstudiante) {
		CodigoEstudiante = codigoEstudiante;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public boolean isSoat() {
		return Soat;
	}
	public void setSoat(boolean soat) {
		Soat = soat;
	}
	@Override
	public String toString() {
		return "Transporte [CodigoVehiculo=" + CodigoVehiculo + ", CodigoEstudiante=" + CodigoEstudiante + ", Placa="
				+ Placa + ", Marca=" + Marca + ", Color=" + Color + ", Soat=" + Soat + "]";
	}
	
	

}
