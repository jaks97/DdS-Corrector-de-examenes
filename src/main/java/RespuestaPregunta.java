public class RespuestaPregunta {
    private Pregunta pregunta;
    private String respuesta;

    public RespuestaPregunta(Pregunta pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Integer getPuntajeObtenido() {
        return pregunta.getPuntajeRespuesta(respuesta);
    }
}
