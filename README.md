# Cosas a Mirar

- [x] Arma ahora se distinguen por el id, revisar si hemos utilizado el equals en otra función y modificarlo.
- [x] Modificar función hanGanadoSupervivientes y poner otra condición donde se vea si todos los supervivientes tienen una provisión en su inventario.
- [x] Añadir +1 contador de zombis matados de superviviente en la función resolver ataque.
- [x] Modificar cuando un Superviviente mata un Zombi. Si éste es tóxico, inflinge daño en esa casilla. Pág2.
- [x] ¿Es necesario distinguir el tipo de Zombi que ataca? Atacan todos igual, ¿no?
- [ ] Revisar TODAS las funciones en las que intervengan los supervivientes. Modificar a que las usen solo los supervivientes vivos.
- [ ] Hacer reaccionarAtaqueZombie, atributo o método?
- [ ] Hacer que si hay zombis en la casilla de origen, cuesta tantas acciones extra como zombis acompañen al superviviente.

**QUITAR EL COMENTARIO DE turno-- EN ACCION SUPERVIVIENTE DE cambiarArma()**

# Cosas Hechas

## 1. **Provisión**
   - Cuando se gane una ronda, comprobar si todos los supervivientes tienen provisiones, si no las tienen no se gana la ronda.

## 2. **Turnos**
   - Al inicio de la partida se generan 3 zombis, y en cada turno se añade uno más.

## 3. **Ataque Zombi**
  - Comprobamos en todo el tablero si cada casilla tiene Zombi:
    - Si tiene zombi comprobamos si tiene superviviente. En caso de que lo tenga, lo herimos (¿de haber varios supervivientes se prioriza atacar a los ya heridos?) y si no lo tiene nos movemos hacia el más cercano. Si hay más zombis ejecutamos esto para cada uno.
    - Si no hay zombi pasamos a la siguiente casilla.


# PRÁCTICA GRUPAL 2024/2025 – A – POO – Calipsis Zombi
<p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/Edward-Andrei-2005/ManzanasYPeras">A – POO – Calipsis Zombi</a> by <span property="cc:attributionName">Anass Chikou, Edward Andrei, Manuel Alos</span> is licensed under <a href="https://creativecommons.org/licenses/by-nc-nd/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">CC BY-NC-ND 4.0<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/nc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/nd.svg?ref=chooser-v1" alt=""></a></p>

## Autores
- Anass Chikou
- Edward Andrei
- Manuel Alos

---

## Entregas

### Entrega 1 (Parcial)
**Fecha límite**: 4 de diciembre de 2024, a las 23:55

**Descripción**: 
Se deberá entregar un archivo `.zip` a través de Aula Virtual que contenga:
- Todos los ficheros fuente de las clases (`*.java`) con sus métodos correspondientes, sin incluir la interfaz gráfica de usuario (IU).
- Un programa de prueba que muestre las pruebas realizadas de los métodos implementados.

### Entrega Final
**Fecha límite**: 20 de diciembre de 2024, a las 23:55

**Descripción**: 
Se deberá entregar un archivo `.zip` a través de Aula Virtual que contenga:
- Todos los ficheros fuente (`*.java` y `*.form`), firmados por cada autor.
- Un archivo `.jar` ejecutable de la aplicación.
- Archivos binarios y de texto con datos de la aplicación. **Requisito mínimo**: 3 jugadores y 5 partidas con diferentes resultados.
- Archivo `leeme.txt` con indicaciones útiles para el equipo docente sobre la ejecución de la práctica y nombres de los autores.
- Vídeo pruebas.mp4 (o enlace a Youtube/similar) donde se detallen las pruebas realizadas sobre todas las funcionalidades del juego haciendo una partida completa y visualización de datos de las estadísticas y partidas
---

![image](https://github.com/user-attachments/assets/9c7ca389-599c-40af-a1cf-5866c6699682)




