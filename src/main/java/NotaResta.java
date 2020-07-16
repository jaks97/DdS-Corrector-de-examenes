public class NotaResta implements CriterioNota {
    private Integer n;

    public NotaResta(Integer n) {
        this.n = n;
    }

    @Override
    public Integer getNota(Examen examen, Integer puntaje) {
        return puntaje - n;
    }
}
