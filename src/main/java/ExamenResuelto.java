import java.util.ArrayList;
import java.util.List;

public class ExamenResuelto {
    private Alumno alumno;
    private Examen examen;
    private List<RespuestaPregunta> respuestas;

    public ExamenResuelto(Alumno alumno, Examen examen) {
        this.alumno = alumno;
        this.examen = examen;
        respuestas = new ArrayList<>();
    }

    public void addRespuesta(RespuestaPregunta respuesta){
        respuestas.add(respuesta);
    }

    public Integer getPuntaje() {
        return respuestas.stream().mapToInt(RespuestaPregunta::getPuntajeObtenido).sum();
    }

    public Integer getNota() {
        return examen.getCriterioNota().getNota(examen, getPuntaje());
    }

    public Boolean aprobado() {
        return getNota() >= examen.getNotaMinima();
    }
}
