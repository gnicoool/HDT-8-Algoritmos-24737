import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class Administrador {
    private VectorHeap<Paciente> vectorHeap;
    private java.util.PriorityQueue<Paciente> queueJCF;

    public Administrador() {
        this.queueJCF = new java.util.PriorityQueue<>();
        this.vectorHeap = new VectorHeap<>();
    }

    public void leerPacientes(String archivo)throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;
            while((line = br.readLine()) != null){
                String[] datos = line.split(",");
                String nombre = datos[0];
                String enfermedad = datos[1];
                char codigo = datos[2].charAt(0);

                Paciente paciente = new Paciente(nombre, enfermedad, codigo, LocalDateTime.now());
                queueJCF.add(paciente);
                vectorHeap.add(paciente);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + e.getMessage());
        }
    }


    public VectorHeap<Paciente> getVectorHeap() {
        return vectorHeap;
    }
    public java.util.PriorityQueue<Paciente> getQueueJCF() {
        return queueJCF;
    }

    public void addPaciente(Paciente paciente) {
        vectorHeap.add(paciente);
        queueJCF.add(paciente);
    }

    public Paciente siguiente(){
        if (!queueJCF.isEmpty()) {
            return queueJCF.remove();
        } else {
            System.out.println("No hay pacientes en la cola.");
            return null;
        }
    }
}
