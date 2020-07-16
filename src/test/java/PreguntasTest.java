
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PreguntasTest {
    @Test
    public void testPreguntaConcreta() {
        Pregunta pregunta = new Pregunta(5, "¿Cuál es la capital de Bulgaria?", "Sofía");
        assertTrue(pregunta.esCorrecta("Sofía"));
        assertEquals((int)pregunta.getPuntajeRespuesta("Sofía"), 5);
        assertFalse(pregunta.esCorrecta("París"));
        assertEquals((int)pregunta.getPuntajeRespuesta("París"), 0);
    }

    @Test
    public void testPreguntaMultipleChoice() {
        Pregunta pregunta = new PreguntaMultipleChoice(3, "El resultado de 1+1 es:", "2", Arrays.asList("0", "1", "2", "3", "10"));
        assertTrue(pregunta.esCorrecta("2"));
        assertEquals((int)pregunta.getPuntajeRespuesta("2"), 3);
        assertFalse(pregunta.esCorrecta("0"));
        assertEquals((int)pregunta.getPuntajeRespuesta("0"), 0);
    }

    @Test
    public void testPreguntaVF() {
        Pregunta pregunta = new PreguntaVF(10, "Esta solución funciona", PreguntaVF.VERDADERO);
        assertTrue(pregunta.esCorrecta(PreguntaVF.VERDADERO));
        assertEquals((int)pregunta.getPuntajeRespuesta(PreguntaVF.VERDADERO), 10);
        assertFalse(pregunta.esCorrecta(PreguntaVF.FALSO));
        assertEquals((int)pregunta.getPuntajeRespuesta(PreguntaVF.FALSO), 0);
    }
}
