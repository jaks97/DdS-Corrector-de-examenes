import java.util.List;

public class NotaPromedio extends CriterioCompuesto {
    public NotaPromedio(List<CriterioNota> criterios) {
        super(criterios);
    }

    @Override
    public Integer getNota(Examen examen, Integer puntaje) {
        return (int)notasDeCriterios(examen, puntaje).average().getAsDouble();
    }
}
