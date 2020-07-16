# DdS-Corrector-de-examenes
Tenemos varios tipos de preguntas, y todas tienen un peso o puntaje y una respuesta correcta.
Supongo que esos tipos no pueden cambiar, asi que decidi usar herencia. La clase pregunta representa una pregunta "concreta" con su enunciado y la respuesta. La pregunta Multiple Choice es igual solo que ademas tiene opciones. Y la pregunta verdadero/falso es un caso particular de una multiple choice.
Las respuestas y las opciones son simples `String`, capaz eso se podria ampliar en algo mas especifico. Pero por lo que pide el enunciado me parecio que un String era suficiente.

Entonces tengo un examen que a su vez tiene preguntas. Como el mismo examen puede ser resuelto por varios alumnos decidi que las preguntas no tienen el estado de la respuesta dada. Sino que tienen un metodo que recibe una respuesta por parametro y devuelve si es correcta o no.
Entonces modelé la solución al examén en un objeto aparte `ExamenResuelto` que a su vez tiene varias `RespuestaPregunta` por cada pregunta respondida por el alumno. Este examen resuelto tiene la referencia al examen original y al alumno que lo resolvió.

El examen tiene ademas una nota de aprobacion y un criterio de correcion.
Tengo varios criterios para calcular la nota. En algunos se calcula la nota en base a un conjunto de otros criterios. ¿Estos "criterios compuestos" pueden tener mas criterios compuestos a su vez? Supongo que si.
Asi que por eso uso patron Composite para esto. Entonces tengo una interfaz en comun `CriterioNota` que implementan los distintos criterios. Los criterios "Compuestos" los agrupe con una clase abstracta que tiene la lista de criterios que usan para calcular la nota. Despues cada criterio compuesto en particular implementa el metodo getNota segun su logica.

![](https://raw.githubusercontent.com/jaks97/DdS-Corrector-de-examenes/master/Diagrama%20de%20clases.svg)

---

Para los agregados:

* *un estudiante puede aprobar un examen sólo si tiene determinadas preguntas correctamente contestadas.*

Esto se puede hacer agregando en el examen una lista de preguntas obligatorias. Entonces a la hora de calcular la nota si no esta alguna de esas bien respondidas no dejo que supere la nota minima.




* *para obtener la sumatoria existen tres opciones:
las preguntas mal contestadas no suman, 
restan la mitad de su valor, o bien 
descuenta 1 punto del total.*

En la clase pregunta se puede tener un atributo `CriterioCorreccion` a modo de Strategy. La idea es tener varias clases que implementen esa interfaz `CriterioCorreccion` y donde tengan un metodo que reciba el peso de esa pregunta y devuelva cuanto corresponde si esta mal contestada.
Entonces en el metodo getPuntajeRespuesta que hay ahora, en vez de devolver 0 cuando la respuesta es incorrecta, le preguntamos a este criterio que hay que devolver.
El inconveniente que le encuentro a esto es que el enunciado da a entender que esto es a nivel examen (o sea, todas las preguntas del examen deberian usar el mismo criterio), sin embargo esa solucion seria a nivel pregunta. Si fuese necesario forzar que este criterio se adopte a nivel de examen, entonces se puede hacer que las preguntas tengan alguna referencia al examen, y que el criterio lo tenga el examen en si mismo.
