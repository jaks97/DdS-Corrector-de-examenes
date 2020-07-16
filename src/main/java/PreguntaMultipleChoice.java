import java.util.List;

public class PreguntaMultipleChoice extends Pregunta {
    private List<String> opciones; // TODO: Podria abstraer la opcion en vez de usar un String

    public PreguntaMultipleChoice(Integer peso, String pregunta, String respuesta, List<String> opciones) {
        super(peso, pregunta, respuesta);
        this.opciones = opciones;
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
