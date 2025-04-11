import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
public class VectorHeapTest {
    private VectorHeap<Paciente> heap;
    
    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

     @Test
    public void testAdd() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        Paciente pacienteA = new Paciente("Juan Perez", "fractura", 'C', LocalDateTime.now());
        Paciente pacienteB = new Paciente("Maria", "apendicitis", 'A', LocalDateTime.now().plusMinutes(5));
        Paciente pacienteC = new Paciente("Pedro", "Fractura", 'C', LocalDateTime.now());
        
        heap.add(pacienteB);
        heap.add(pacienteC);
        heap.add(pacienteA);

        assertEquals(3, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(pacienteB, heap.getFirst());
    }
    
    @Test
    public void testRemove() {
        Paciente paciente1 = new Paciente("Juan Perez", "fractura", 'C', LocalDateTime.now());
        Paciente paciente2 = new Paciente("Maria", "apendicitis", 'A', LocalDateTime.now().plusMinutes(5));
        Paciente paciente3 = new Paciente("Lorenzo Toledo", "apendicitis", 'A', LocalDateTime.now());
        
        heap.add(paciente3);
        heap.add(paciente2);
        heap.add(paciente1);
        
        assertEquals(3, heap.size());
       
        Paciente removed = heap.remove();
        assertEquals(paciente3, removed);
        assertEquals(2, heap.size());
        
        removed = heap.remove();
        assertEquals(paciente2, removed);
        assertEquals(1, heap.size());

        removed = heap.remove();
        assertEquals(paciente1, removed);
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
}
