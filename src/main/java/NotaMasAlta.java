import java.util.List;

public class NotaMasAlta extends CriterioCompuesto {

    public NotaMasAlta(List<CriterioNota> criterios) {
        super(criterios);
    }

    @Override
    public Integer getNota(Examen examen, Integer puntaje) {
        return notasDeCriterios(examen, puntaje).max().getAsInt();
    }
}
