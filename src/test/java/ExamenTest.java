import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExamenTest {
    Examen examen;
    Pregunta unaPregunta;
    Pregunta otraPregunta;

    @Before
    public void init() {
        unaPregunta = new Pregunta(8, "¿Cuál es la capital de Bulgaria?", "Sofía");
        otraPregunta = new PreguntaMultipleChoice(8, "El resultado de 1+1 es:", "2", Arrays.asList("0", "1", "2", "3", "10"));
        examen = new Examen(Arrays.asList(unaPregunta, otraPregunta), 6, new NotaReglaTres());
    }

    @Test
    public void testExamenAprobado() {
        ExamenResuelto solucion = new ExamenResuelto(new Alumno("Jose"), examen);
        solucion.addRespuesta(new RespuestaPregunta(unaPregunta, "Sofía"));
        solucion.addRespuesta(new RespuestaPregunta(otraPregunta, "2"));

        assertEquals((int)solucion.getNota(), 10); // Contesto todas bien
        assertTrue(solucion.aprobado());
    }

    @Test
    public void testExamenDesaprobado() {
        ExamenResuelto solucion = new ExamenResuelto(new Alumno("Pedro"), examen);
        solucion.addRespuesta(new RespuestaPregunta(unaPregunta, "Paris"));
        solucion.addRespuesta(new RespuestaPregunta(otraPregunta, "2"));

        assertEquals((int)solucion.getNota(), 5); // Contesto una mal, tiene un 5
        assertFalse(solucion.aprobado()); // Se aprueba con 6
    }
}
