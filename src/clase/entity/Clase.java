package clase.entity;

public class Clase {
	
	private int idClase;
    private int  codigoDocente;
    private int idSemestre;
    private int CodigoEstudiante;
    private int CodigoHorario;
    private int IdAula;
    public Clase(int idClase, int codigoDocente, int idSemestre, int codigoEstudiante, int codigoHorario, int idAula) {
            super();
            this.idClase = idClase;
            this.codigoDocente = codigoDocente;
            this.idSemestre = idSemestre;
            CodigoEstudiante = codigoEstudiante;
            CodigoHorario = codigoHorario;
            IdAula = idAula;
    }
    public int getIdClase() {
            return idClase;
    }
    public void setIdClase(int idClase) {
            this.idClase = idClase;
    }
    public int getCodigoDocente() {
            return codigoDocente;
    }
    public void setCodigoDocente(int codigoDocente) {
            this.codigoDocente = codigoDocente;
    }
    public int getIdSemestre() {
            return idSemestre;
    }
    public void setIdSemestre(int idSemestre) {
            this.idSemestre = idSemestre;
    }
    public int getCodigoEstudiante() {
            return CodigoEstudiante;
    }
    public void setCodigoEstudiante(int codigoEstudiante) {
            CodigoEstudiante = codigoEstudiante;
    }
    public int getCodigoHorario() {
            return CodigoHorario;
    }
    public void setCodigoHorario(int codigoHorario) {
            CodigoHorario = codigoHorario;
    }
    public int getIdAula() {
            return IdAula;
    }
    public void setIdAula(int idAula) {
            IdAula = idAula;
    }
    @Override
    public String toString() {
            return "Clase [idClase=" + idClase + ", codigoDocente=" + codigoDocente + ", idSemestre=" + idSemestre
                            + ", CodigoEstudiante=" + CodigoEstudiante + ", CodigoHorario=" + CodigoHorario + ", IdAula=" + IdAula
                            + "]";
    }
    

}
