/*
 * Clase Paciente
 * Representa un paciente en sala de urgencias de un hospital
 * 
 * @author Jackelyn Giròn
 */
import java.time.LocalDateTime;
public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String enfermedad;
    private char codigo;
    private LocalDateTime fechaIngreso;

    /*
     * Constructor de la clase Paciente
     * @param nombre Nombre del paciente
     * @param enfermedad Enfermedad del paciente
     * @param codigo Codigo de prioridad del paciente
     * @param fechaIngreso Fecha y hora de ingreso del paciente
     */
    public Paciente(String nombre, String enfermedad, char codigo, LocalDateTime fechaIngreso) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
    }

    /*
     * Getters y Setters de la clase Paciente
     */
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEnfermedad() {
        return this.enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public char getCodigo() {
        return this.codigo;
    }
    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }
    public LocalDateTime getFechaIngreso() {
        return this.fechaIngreso;
    }
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /*
    * Método para comparar pacientes por su código de prioridad y fecha de ingreso
     */
    @Override
    public int compareTo(Paciente urgencia) {
        if (this.codigo< urgencia.getCodigo()) {
            return -1;
        } else if (this.codigo > urgencia.getCodigo()) {
            return 1;
        } else {
            return this.fechaIngreso.compareTo(urgencia.getFechaIngreso());   
        }
    }

    @Override
    public String toString() {
        return "----------------------------" +
                "nombre:'" + nombre + '\'' +
                ", enfermedad:'" + enfermedad + '\'' +
                ", codigo:" + codigo;
    }
}