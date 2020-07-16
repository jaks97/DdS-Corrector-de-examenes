import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CriterioNotaTest {
    Examen examen;
    CriterioNota notaResta;
    CriterioNota notaReglaTres;
    CriterioNota notaTabla;

    @Before
    public void init() {
        Pregunta unaPregunta = new Pregunta(8, "¿Cuál es la capital de Bulgaria?", "Sofía");
        Pregunta otraPregunta = new PreguntaMultipleChoice(8, "El resultado de 1+1 es:", "2", Arrays.asList("0", "1", "2", "3", "10"));
        examen = new Examen(Arrays.asList(unaPregunta, otraPregunta), 6, new NotaReglaTres());

        notaResta = new NotaResta(6);
        notaReglaTres = new NotaReglaTres();
        Map<Integer, Integer> tabla = new HashMap<>();
        tabla.put(16, 10);
        tabla.put(15, 8);
        tabla.put(14, 6);
        tabla.put(13, 4);
        //...

        notaTabla = new NotaTabla(tabla);
    }


    @Test
    public void testResta() {
        assertEquals((int)notaResta.getNota(examen, 14), 8);
    }

    @Test
    public void testReglaTres() {
        assertEquals((int)notaReglaTres.getNota(examen, 14), 8);
    }

    @Test
    public void testTabla() {
        assertEquals((int)notaTabla.getNota(examen, 14), 6);
    }

    @Test
    public void testNotaMasAlta() {
        CriterioNota criterioNota = new NotaMasAlta(Arrays.asList(notaResta, notaReglaTres, notaTabla));
        assertEquals((int)criterioNota.getNota(examen, 14), 8);
    }

    @Test
    public void testNotaPromedio() {
        CriterioNota criterioNota = new NotaPromedio(Arrays.asList(notaResta, notaReglaTres, notaTabla));
        assertEquals((int)criterioNota.getNota(examen, 14), 7);
    }
}
