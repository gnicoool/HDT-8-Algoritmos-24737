/*
 * Jackelyn Nicolle Giròn Villacinda
 * Carne 24737
 */
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador();
        try{
            admin.leerPacientes("pacientes.txt");
        }catch(IOException e){
            System.err.println("Error en la carga de  archivo");
        }
        
        VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
        java.util.PriorityQueue<Paciente> queueJCF = new java.util.PriorityQueue<>();
        
        
        boolean continuar = true;
        while (continuar) {
            
            System.out.println("\n------ Urgencias ------");
            System.out.println("1. Ver y atender pacientes con VectorHeap");
            System.out.println("2. Ver y atender pacientes con Java Collections Framework");
            System.out.println("3. Ingresar nuevo paciente");
            System.out.println("4. Salir del programa");
                
            int opcion = sc.nextInt();
            sc.nextLine();
                
            switch (opcion) {
                case 1:
                    atenderPacientes(admin.getVectorHeap());
                    break;
                        
                case 2:
                    atenderPacientesJCF(admin.getQueueJCF());
                    break;
                        
                case 3:
                    System.out.println("\n----- Nuevo Paciente -----");
        
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    
                    System.out.print("Descripción del síntoma: ");
                    String enfermedad = sc.nextLine();
                    
                    char codigo;
                    do {
                        System.out.print("Código de emergencia (A-E, donde A es más prioritario): ");
                        codigo = sc.nextLine().toUpperCase().charAt(0);
                        
                        if (codigo < 'A' || codigo > 'E') {
                            System.out.println("Código inválido. Debe ser una letra entre A y E.");
                        }
                    } while (codigo < 'A' || codigo > 'E');
                    
                    Paciente nuevoPaciente =  new Paciente(nombre, enfermedad, codigo, LocalDateTime.now());
                    vectorHeap.add(nuevoPaciente);
                    queueJCF.add(nuevoPaciente);
                    System.out.println("Paciente ingresado correctamente.");
                    break;
                        
                case 4:
                    System.out.println("Saliendo del programa");
                    continuar = false;
                    return;
                        
                default:
                    System.out.println("Ingrese una opcion valida, entre 1 y 6");
                    break;
            }
            
        }
        
        sc.close();
    }
    
    
    private static void atenderPacientes(VectorHeap<Paciente> cola) {
        System.out.println("\n----- VectorHeap -----");
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en la cola de espera.");
            return;
        }
        
        int totalPacientes = cola.size();
        System.out.println("Total de pacientes en espera: " + totalPacientes);
        
        
        VectorHeap<Paciente> copiaCola = new VectorHeap<>();
        
        int contador = 1;
        while (!cola.isEmpty()) {
            Paciente paciente = cola.remove();
            System.out.println("\nPaciente #" + contador + ": " + paciente.getNombre());
            System.out.println("Condición: " + paciente.getEnfermedad());
            System.out.println("Código de prioridad: " + paciente.getCodigo());
            System.out.println("-----------------------------------");
            
            copiaCola.add(paciente);
            contador++;
        }
        
       
        while (!copiaCola.isEmpty()) {
            cola.add(copiaCola.remove());
        }
    }
    
    
    private static void atenderPacientesJCF(java.util.PriorityQueue<Paciente> cola) {
        System.out.println("\n----- Java Collections Framework -----");
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en la cola de espera.");
            return;
        }
        
        int totalPacientes = cola.size();
        System.out.println("Total de pacientes en espera: " + totalPacientes);
        
      
        java.util.PriorityQueue<Paciente> copiaCola = new java.util.PriorityQueue<>(cola);
        
        int contador = 1;
        while (!copiaCola.isEmpty()) {
            Paciente paciente = copiaCola.poll();
            System.out.println("\nPaciente #" + contador + ": " + paciente.getNombre());
            System.out.println("Condición: " + paciente.getEnfermedad());
            System.out.println("Código de prioridad: " + paciente.getCodigo());
            System.out.println("-----------------------------------");
            contador++;
        }
    }
    


}
