import java.util.List;

public class Examen {
    private List<Pregunta> preguntas;
    private Integer notaMinima; // La nota minima para aprobar el examen
    private CriterioNota criterioNota; // El criterio para calcular la nota del examen

    public Examen(List<Pregunta> preguntas, Integer notaMinima, CriterioNota criterioNota) {
        this.preguntas = preguntas;
        this.notaMinima = notaMinima;
        this.criterioNota = criterioNota;
    }

    public Integer getTotalPuntos() { // Devuelve el maximo de puntos que se pueden obtener segun las preguntas del examen
        return preguntas.stream().mapToInt(Pregunta::getPeso).sum();
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public CriterioNota getCriterioNota() {
        return criterioNota;
    }
}
