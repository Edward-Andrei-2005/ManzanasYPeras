Juego tiene dimensión. Dimensión es un array doble de 10x10 de Casillas. Cada casilla tiene una coordenada x e y y además, un array dinámico de EntidadesActivables, que pueden ser Superviviente o Zombi.

![image](https://github.com/user-attachments/assets/21b4c6ec-94ef-4243-81ab-4f39ad858090)

A la hora de hacer un ataque. La función de atacar se llama desde Juego. Y ejecuta:

Primero se elige un superviviente que atacará. Se guarda el superviviente en una variable que usarán todas las funciones.

Luego se hace la función elegirArma(). Se le pasa por parámetros: el superviviente que está atacando y con qué arma ataca (un booleano).

La función recorre el array doble, casilla por casilla. Y en cada casilla busca dentro de su ArrayList el superviviente que está atacando.

Cuando lo encuetra va a su arma izquierda o derecha. Si no tiene devuelve null y se vuelve a pedir que haga un ataque.

Cuando encuentra el superviviente, devuelve el arma y la guarda en una variable.
![image](https://github.com/user-attachments/assets/b7757583-d0bf-4aa8-9425-0b6c53fdb7ed)

seleccionarObjetivo(). SE le pasa la casilla origen, el arma que se va a usar y la casilla destino.

Calcula la distancia entre las dos casillas y devuelve booleano si el arma puede atacar al destino desde el origen.
![image](https://github.com/user-attachments/assets/bacede92-3fc7-4668-b78a-dcb94c5e01f2)

lanzardados(). Se la pasa el arma que está atacando.

Cogemos del arma el número de dados: `arma1.numeroDeDados`.

Hacemos tantas tiradas de dados (num aleatorio del 1 al 6) como nos diga el arma y lo guardamos en un array.

Ej: numDeDados = 2 -> return [2, 6].
![image](https://github.com/user-attachments/assets/d9c31b13-9b52-4bb7-be63-61603044b650)


evaluarExitos(). Se pasa el arma y el array de lanzardados
Comprueba cuantas veces se ha superado el número de exito del arma. `arma1.valorDeExito`
Devuelve el entero

resolverAtaque(). Se pasa la casilla destino, el numero de exitos y el arma.

Se recorre la lista de entidades de la casilla. Por cada zombi se comprueba si el arma lo puede matar. Si puede, lo mata y resta un éxito.

Se sigue recorriendo hasta que se encuentre otro zombi que se pueda matar y se repite el proceso.

Si se llega al final de la lista y exitos>0. Significa que hay zombis que no podemos matar.

Si no se llega al final pero exitos=0. Todavía pueden quedar zombis por matar pero no tenemos más exitos.

En cualquiera de los dos casos se termina el ataque.
