package universidad.view;

import java.sql.SQLException;
import java.util.Scanner;

import Docente.View.DocenteView;
import Estudiante.View.EstudiantesView;
import Horario.view.HorarioView;
import Materia.View.MateriaView;
import Transporte.view.TransporteView;
import aula.view.AulaView;
import carrera.view.CarreraView;
import clase.view.ClasesView;
import cuenta.view.CuentaView;
import NotasYFaltas.view.NotasYfaltasView;
import semestre.view.SemestreView;
import universidad.control.Conexion;


public class MenuOficial {

    public static int encabezado(Scanner scanner) {
            int opcion;

            while (true) {
                    System.out.println("****************************************************************************************");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("                            Ingrese una opcion  :                   ");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("****************************************************************************************");

                    System.out.println("1. Estudiante");
                    System.out.println("2. Cuenta del Estudiante");
                    System.out.println("3. Transporte del Estudiante ");
                    System.out.println("4. Docente  ");
                    System.out.println("5. Carrera ");
                    System.out.println("6. Clase ");
                    System.out.println("7. Materia ");
                    System.out.println("8. Aula ");
                    System.out.println("9. Horarios ");
                    System.out.println("10. Semestre ");
                    System.out.println("11. Registro de notas y faltas ");
                    
                    System.out.println("0. Salir");
                    System.out.println();

                    opcion = InputTypes.readInt("¿Su opción? ", scanner);

                    if (opcion >= 0 && opcion <= 11) {
                            return opcion;
                    }
            }
    }


    public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
            boolean salir = false;
            
            Conexion conexión = new Conexion("root","","kathy");
            CarreraView carreraV = new CarreraView(conexión, scanner);
            SemestreView semestreV = new SemestreView(conexión, scanner);
            ClasesView claseV = new ClasesView(conexión, scanner);
            AulaView aulaV = new AulaView(conexión, scanner);
            NotasYfaltasView notasYfaltasV = new NotasYfaltasView(conexión, scanner);
            CuentaView cuentaV = new CuentaView(conexión, scanner);
            DocenteView docenteV = new DocenteView(conexión, scanner);
            EstudiantesView estudianteV = new EstudiantesView(conexión, scanner);
            HorarioView horarioV = new HorarioView(conexión, scanner);
            MateriaView materiaV = new MateriaView(conexión, scanner);
            TransporteView transporteV = new TransporteView(conexión, scanner);
            
                    while (!salir) {
                    switch (encabezado(scanner)) {
                    case 0:
                            salir = true;
                            break;
                    case 1:
                            Estudiante.View.MenuEstudiante.menuEstudiante(scanner, estudianteV);
                            break;
                    case 2:
                            cuenta.view.MenuCuenta.menuCuenta(scanner, cuentaV);
                            break;
                    case 3:
                            Transporte.view.MenuTransporte.menuTransporte(scanner, transporteV);
                            break;
                    case 10:
                            semestre.view.MenuSemestre.menuSemestre(scanner, semestreV);
                            break;
                    case 5:
                            carrera.view.MenuCarrera.menuCarrera(scanner, carreraV);
                            break;          
                    case 6:
                            clase.view.MenuClase.menuClase(scanner, claseV);
                            break;
                    case 7:
                            Materia.View.MenuMateria.menuMateria(scanner, materiaV);
                            break;
                    case 8:
                            aula.view.MenuAula.menuAula(scanner, aulaV);
                            break;
                    case 9:
                            Horario.view.MenuHorario.menuHorario(scanner, horarioV);
                            break;
                    case 4:
                            Docente.View.MenuDocente.menuDocente(scanner, docenteV);
                            break;
                    case 11:
                            NotasYFaltas.view.MenuNotasYfaltas.menuNotasYfaltas(scanner, notasYfaltasV);
                            break;
                    }
            }
            conexión.close();
    }
}
