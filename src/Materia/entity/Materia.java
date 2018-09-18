package Materia.entity;

public class Materia {
private int CodigoMateria;
private int Creditos;
private String Estado;
private int IdCarrera;
private int IdClase;
public Materia(int codigoMateria, int creditos, String estado2, int idCarrera, int idClase) {
	super();
	CodigoMateria = codigoMateria;
	Creditos = creditos;
	Estado = estado2;
	IdCarrera = idCarrera;
	IdClase = idClase;
}
public int getCodigoMateria() {
	return CodigoMateria;
}
public void setCodigoMateria(int codigoMateria) {
	CodigoMateria = codigoMateria;
}
public int getCreditos() {
	return Creditos;
}
public void setCreditos(int creditos) {
	Creditos = creditos;
}
public String getEstado() {
	return Estado;
}
public void setEstado(String estado) {
	Estado = estado;
}
public int getIdCarrera() {
	return IdCarrera;
}
public void setIdCarrera(int idCarrera) {
	IdCarrera = idCarrera;
}
public int getIdClase() {
	return IdClase;
}
public void setIdClase(int idClase) {
	IdClase = idClase;
}
@Override
public String toString() {
	return "Materia [CodigoMateria=" + CodigoMateria + ", Creditos=" + Creditos + ", Estado=" + Estado + ", IdCarrera="
			+ IdCarrera + ", IdClase=" + IdClase + "]";
}


	
}
