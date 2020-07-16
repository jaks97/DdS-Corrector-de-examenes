import java.util.Arrays;

public class PreguntaVF extends PreguntaMultipleChoice {
    static final String VERDADERO = "Verdadero";
    static final String FALSO = "Falso";
    public PreguntaVF(Integer peso, String pregunta, String respuesta) { // Podria ser un boolean tambien la respuesta
        super(peso, pregunta, respuesta, Arrays.asList(VERDADERO, FALSO));
    }
}
