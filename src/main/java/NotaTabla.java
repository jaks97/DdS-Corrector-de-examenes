import java.util.Map;

public class NotaTabla implements CriterioNota {
    private Map<Integer, Integer> tablaConversion;

    public NotaTabla(Map<Integer, Integer> tablaConversion) {
        this.tablaConversion = tablaConversion;
    }

    @Override
    public Integer getNota(Examen examen, Integer puntaje) {
        return tablaConversion.get(puntaje);
    }
}
