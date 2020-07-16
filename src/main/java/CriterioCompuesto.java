import java.util.List;
import java.util.stream.IntStream;

public abstract class CriterioCompuesto implements CriterioNota {
    protected List<CriterioNota> criterios;

    public CriterioCompuesto(List<CriterioNota> criterios) {
        this.criterios = criterios;
    }

    protected IntStream notasDeCriterios(Examen examen, Integer puntaje) { // Devuelve una lista con las notas segun cada criterio
        return criterios.stream().mapToInt(criterio -> criterio.getNota(examen, puntaje));
    }
}
