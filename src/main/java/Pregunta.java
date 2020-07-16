public class Pregunta {
    private Integer peso;
    private String pregunta; // La pregunta en si, aka la consigna
    private String respuesta; // TODO: Podria abstraer la respuesta en vez de usar un String

    public Pregunta(Integer peso, String pregunta, String respuesta) {
        this.peso = peso;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Boolean esCorrecta(String respuesta) {
        return this.respuesta.equals(respuesta);
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getPuntajeRespuesta(String respuesta) {
        return esCorrecta(respuesta) ? peso : 0;
    }
}
