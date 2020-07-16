public class NotaReglaTres implements CriterioNota {

    @Override
    public Integer getNota(Examen examen, Integer puntaje) {
        return puntaje * 10 / examen.getTotalPuntos();
    }
}
