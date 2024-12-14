package apoocalipsis;
import apoocalipsis.Arma;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego implements Serializable {
    private boolean turno; // true = turno del superviviente, false = turno del zombi
    private Casilla[][] dimension; // Representación del tablero del juego como matriz de casillas

    private static final int TAM_X = 10; // Tamaño del tablero en el eje X
    private static final int TAM_Y = 10; // Tamaño del tablero en el eje Y
    
    private static final Casilla CASILLA_INICIO = new Casilla(0, 0);
    private static final Casilla CASILLA_FIN = new Casilla(9, 9);
    
    private static final int NUM_ZOMBIS_INICIO = 3;
    private static final int NUM_ZOMBIS_NUEVOS_POR_TURNO = 1;
    private static final int NUM_TURNOS_SUPERVIVIENTES = 3; //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡CAMBIAR A 3!!!!!!!!!!!!!!!!!
    
    private static final int PROBABILIDAD_CAMINANTE = 6; // 60%
    private static final int PROBABILIDAD_CORREDOR = 9; // 30%
    
    private ArrayList<Ataque> listaAtaques;

    public Juego() {
        dimension = new Casilla[TAM_X][TAM_Y]; // Inicializa el tablero con casillas vacías
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                dimension[i][j] = new Casilla(i, j);
            }
        }
        turno = true;
        listaAtaques = new ArrayList<>();
    }
    
    public Casilla getCasilla(int i, int j) {
        return dimension[i][j];
    }
    
    public Equipo buscarEquipo(Superviviente s) {
        return buscarCasillaOrigen(s).buscarEquipo(s);
    }
    
    public int getTurnosSupervivientes() {
        return NUM_TURNOS_SUPERVIVIENTES;
    }
    
    // Metodo que gestiona todo el ciclo de una partida
    public boolean hacerPartida(String [] listaNombres) {
        asignarSupervivientesPosicionInicial(listaNombres);
        generarZombisInicio();
        
        do {
            turnoSupervivientes(listaNombres);
            turnoZombis();
            generarNuevoZombi();
            
        } while (!hayAlgunSupervivienteMuerto() && !hanGanadoSupervivientes(listaNombres));
        return true;
    }
    
    public Superviviente getSuperviviente(String nombre) {
        for(int φ=0; φ<TAM_X; φ++) {
            for(int Ψ=0; Ψ<TAM_Y ; Ψ++) {
                if(dimension[φ][Ψ].estaSuperviviente(nombre) 
                        && dimension[φ][Ψ].getSuperviviente(nombre).estaVivo()) {
                        return dimension[φ][Ψ].getSuperviviente(nombre);
                }
            }
        }
        return null;
    }
    
    public boolean turnoSupervivientes(String [] listaS) {
        for(int λ=0; λ<listaS.length; λ++) {
            boolean encontrado = false;
            for(int φ=0; φ<TAM_X; φ++) {
                for(int Ψ=0; Ψ<TAM_Y ; Ψ++) {
                    if(dimension[φ][Ψ].estaSuperviviente(listaS[λ]) 
                            && dimension[φ][Ψ].getSuperviviente(listaS[λ]).estaVivo() && !encontrado) {
                            ejecutarAccionesSupervivientes(dimension[φ][Ψ].getSuperviviente(listaS[λ]));
                            encontrado = true;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean turnoZombis() {
    System.out.println("\n----------------------- TURNO ZOMBIS -----------------------\n\n");
    
    // Guardamos todos los zombis que existan en ese momento en el juego en un arrayList
    // Esto es para luego recorrer el arrayList y asegurarnos de que un mismo zombi no haga una accion dos veces en un turno
    ArrayList<Zombi> todosLosZombisDelJuego = new ArrayList <> ();
    for (int i=0; i<TAM_X; i++) {
        for (int j=0; j<TAM_Y; j++) {
            todosLosZombisDelJuego.addAll(dimension[i][j].todosLosZombis());
        }
    }
    for (Zombi z : todosLosZombisDelJuego) {
        for (int k=0; k<z.getActivaciones(); k++) {
            boolean zombiEncontrado = false;
            for (int i = 0; i < TAM_X; i++) {
                for (int j = 0; j < TAM_Y; j++) {
                    if (dimension[i][j].hayAlgunZombi() && !zombiEncontrado) {
                        // Hacemos una copia de la lista para evitar ConcurrentModificationException
                        ArrayList<EntidadActivable> entidadesCopia = new ArrayList<>(dimension[i][j].getListaEntidades());

                        for (EntidadActivable e : entidadesCopia) {
                            if (e instanceof Zombi && e.equals(z)) {
                                Zombi zombi = (Zombi) e;
                                System.out.println("Turno del Zombi de la casilla:\n" +buscarCasillaOrigen(e));
                                
                                // Separar supervivientes en heridos y sanos
                                ArrayList<Superviviente> supervivientesHeridos = new ArrayList<>();
                                ArrayList<Superviviente> supervivientesSanos = new ArrayList<>();

                                for (EntidadActivable e2 : entidadesCopia) { // Iteramos sobre la copia
                                    if (e2 instanceof Superviviente && ((Superviviente) e2).estaVivo()) {
                                        if (((Superviviente) e2).estaHerido()) {
                                            supervivientesHeridos.add((Superviviente) e2);
                                        } else {
                                            supervivientesSanos.add((Superviviente) e2);
                                        }
                                    }
                                }

                                // Ataque en bucle mientras haya activaciones y supervivientes
                                if (!supervivientesHeridos.isEmpty()) {
                                    Superviviente herido = supervivientesHeridos.remove(0); // Ataca al primer herido
                                    System.out.println("Ataque realizado con exito al superviviente herido: " +herido);
                                    herido.recibirAtaque();
                                } else if (!supervivientesSanos.isEmpty()) {
                                    Superviviente sano = supervivientesSanos.remove(0); // Ataca al primer sano
                                    System.out.println("Ataque realizado con exito al superviviente sano: " +sano);
                                    sano.recibirAtaque();
                                }

                                // Movimiento si quedan activaciones y no hay supervivientes en la casilla
                                if (zombi.getActivaciones() > 0 && supervivientesHeridos.isEmpty() && supervivientesSanos.isEmpty()) {
                                    ////////////////////////////PRUEBAS//////////////////////////////////

                                    //System.out.println(zombi);
                                    //System.out.println(obtenerCasillaSupervivienteMasCercano(zombi).toString()); //Imprimir para comprobar
                                    /////////////////////////////////////////////////////////////////////
                                    System.out.println("No hay supervivientes en esta casilla, el mas cercano esta en: \n" +obtenerCasillaSupervivienteMasCercano(zombi));
                                    moverseZombi(zombi, obtenerCasillaSupervivienteMasCercano(zombi));
                                    System.out.println("El zombi se mueve a: " +buscarCasillaOrigen(zombi));
                                }
                                zombiEncontrado = true;
                            }
                        }
                    }
                }
            }
        }
    }
    return true;
    }
    
    private Casilla obtenerCasillaSupervivienteMasCercano(Zombi z) {
        Casilla origen = buscarCasillaOrigen(z); // Encuentra la casilla actual del zombi
        Casilla destino = dimension[CASILLA_INICIO.getX()][CASILLA_INICIO.getY()];
        int distanciaMinima = (int) Math.sqrt(Math.pow(TAM_X, 2) + Math.pow(TAM_Y, 2)); // El tamaño más grande que acepta el tablero

        // Buscar la casilla más cercana con un superviviente
        for (int i = 0; i < TAM_X; i++) {
            for (int j = 0; j < TAM_Y; j++) {
                if (dimension[i][j].hayAlgunSupervivienteVivo()) {
                    int distancia = dimension[i][j].distancia(origen);
                    if (distancia < distanciaMinima) {
                        distanciaMinima = distancia;
                        destino = dimension[i][j]; // La casilla ojetivo será la casilla actual
                    }
                }
            }
        }
        
        return destino;
    }
    
    private void moverseZombi(Zombi zombi, Casilla objetivo) {
        // Obtener la posición actual del zombi
            int xActual = buscarCasillaOrigen(zombi).getX();
            int yActual = buscarCasillaOrigen(zombi).getY();

            // Coordenadas de la casilla objetivo
            int xObjetivo = objetivo.getX();
            int yObjetivo = objetivo.getY();

            /*// Máximo de movimientos del zombi (1 casilla por activación)
            int activacionesZombi = zombi.getActivaciones();*/
            
            if (xActual < xObjetivo) {
                xActual++; // Bajar
            } else if (xActual > xObjetivo) {
                xActual--; // Subir
            } 
            if (yActual < yObjetivo) {
                yActual++; // Mover Derecha
            } else if (yActual > yObjetivo) {
                yActual--; // Mover Izquierda
            }
            moverse(dimension[xActual][yActual], zombi);
            dibujarTableroConNumeros();

            /*// Mientras el zombi tenga movimientos y no haya llegado al objetivo
            while (activacionesZombi > 0 && (xActual != xObjetivo || yActual != yObjetivo)) {
                // Decidir en qué dirección moverse en X
                if (xActual < xObjetivo) {
                    xActual++; // Bajar
                } else if (xActual > xObjetivo) {
                    xActual--; // Subir
                } 
                if (yActual < yObjetivo) {
                    yActual++; // Mover Derecha
                } else if (yActual > yObjetivo) {
                    yActual--; // Mover Izquierda
                }
                activacionesZombi--;
                moverse(dimension[xActual][yActual], zombi);
                dibujarTableroConNumeros();
            }*/
    }
    public void dibujarTableroConNumeros() {
        // Imprimir los números de las columnas (parte superior)
        System.out.print("    "); // Espacio inicial para alinear los números de las filas
        for (int j = 0; j < TAM_Y; j++) {
            System.out.printf("%3d ", j);
        }
        System.out.println();

        // Imprimir el borde superior
        System.out.print("   +");
        System.out.print("---+".repeat(TAM_Y));
        System.out.println();

        for (int i = 0; i < TAM_X; i++) {
            // Imprimir el número de la fila (parte izquierda)
            System.out.printf("%2d |", i);

            // Contenido de cada fila
            for (int j = 0; j < TAM_Y; j++) {
                if (dimension[i][j].hayAlgunSupervivienteVivo() && dimension[i][j].hayAlgunZombi()) {
                System.out.print(" / |");; // Hay zombis y supervivientes
                } else if (dimension[i][j].hayAlgunZombi()) {
                    System.out.print(" Z |");
                } else if (dimension[i][j].hayAlgunSupervivienteVivo()) {
                    System.out.print(" S |");
                } else {
                    System.out.print("   |"); // Casilla vacía
                }
                if(i==5 && j==9) { System.out.print("\t/: Hay Supervivientes y Zombis en la misma casilla"); }
            }
            System.out.println();

            // Borde entre filas
            System.out.print("   +");
            System.out.print("---+".repeat(TAM_Y));
            System.out.println();
        }
    }
    // ejecutarAccionesSupervivientes solo se ejecutará si el superviviente está vivo, no hay que hacer distinciones
    private void ejecutarAccionesSupervivientes(Superviviente s) {
        System.out.println("\n----------------------- TURNO SUPERVIVIENTES -----------------------\n\n");
        System.out.println("\n************* " + s.getNombre() + " *************");
        
        int turnos = NUM_TURNOS_SUPERVIVIENTES;
        while (turnos > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Acciones disponibles para el Superviviente: ");
            System.out.println("1. No hacer nada");
            System.out.println("2. Moverse");
            System.out.println("3. Atacar");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Cambiar arma");
            dibujarTableroConNumeros();
            System.out.println();
            System.out.print("Selecciona la accion que deseas realizar (1-5): \n\n");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // No hacer nada
                    turnos--;
                    System.out.println("Tienes " + turnos + " turnos\n\n");
                    break;
                case 2: // Moverse
                    int xDestino, yDestino;
                    
                    Casilla origen = buscarCasillaOrigen(s);
                    
                    // Si no tiene suficiente numero de acciones en su turno para moverse, no se ejecuta el metodo moverse()
                    if (origen.numeroZombis() + 1 > turnos) {
                        System.out.println("Mi loco tu no te escapas");
                        break;
                    }
                    
                    boolean esMovimientoValido;
                    do {
                        System.out.print("Introduce la coordenada X de la casilla destino (0-9): ");
                        xDestino = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Introduce la coordenada Y de la casilla destino (0-9): ");
                        yDestino = scanner.nextInt();
                        scanner.nextLine();
                        
                        esMovimientoValido = moverse(dimension[xDestino][yDestino], s);

                        if (xDestino < 0 || xDestino >= TAM_X || yDestino < 0 || yDestino >= TAM_Y) {
                            System.out.println("Coordenadas fuera del rango permitido. Intenta de nuevo.");
                        }
                    } while (!esMovimientoValido);
                    
                    Casilla destino = buscarCasillaOrigen(s);
                    
                    turnos = turnos - (origen.numeroZombis() + 1);
                    System.out.println("Tienes " + turnos + " turnos");
                    System.out.println("Te has movido a la casilla: " +destino.toString());
                    System.out.println();
                    break;

                case 3: // Atacar

                    System.out.println("Iniciando ataque...");

                    // Pedir si usará el arma izquierda o derecha
                    System.out.println("¿Usar el arma izquierda? (true para izquierda, false para derecha): ");
                    if(s.getManoIzq() != null) {
                        System.out.println("\t- En la mano izquierda tienes: " + s.getManoIzq().toString());
                    }
                    if(s.getManoDer() != null) {
                        System.out.println("\t- En la mano derecha tienes: " + s.getManoDer().toString());
                    }
                    if(s.getManoIzq() == null && s.getManoDer() == null) {
                        System.out.println("No tienes ningun arma en las manos, no puedes atacar");
                        break;
                    }
                    boolean izq = scanner.nextBoolean();

                    // Pedir las coordenadas de la casilla objetivo
                    for (int i=0; i<TAM_X; i++) {
                        for (int j=0; j<TAM_Y; j++) {
                            if(dimension[i][j].numeroZombis() > 0) {
                                System.out.println("Casilla:\n " + dimension[i][j].toString());
                                System.out.println(dimension[i][j].imprimirAguanteZombis());
                            }
                        }
                    }
                    int xObjetivo, yObjetivo;
                    do {
                        System.out.print("Introduce la coordenada X de la casilla objetivo (0-10): ");
                        xObjetivo = scanner.nextInt();
                        System.out.print("Introduce la coordenada Y de la casilla objetivo (0-10): ");
                        yObjetivo = scanner.nextInt();

                        if (xObjetivo < 0 || xObjetivo >= TAM_X || yObjetivo < 0 || yObjetivo >= TAM_Y) {
                            System.out.println("Coordenadas fuera del rango permitido. Intenta de nuevo.");
                        }
                        if(!buscarCasillaOrigen(s).esAdyacente(dimension[xObjetivo][yObjetivo])) {
                            System.out.print("La casilla no es adyacente. Intenta de nuevo: ");
                        }
                    } while (xObjetivo < 0 || xObjetivo >= TAM_X || yObjetivo < 0 || yObjetivo >= TAM_Y || !buscarCasillaOrigen(s).esAdyacente(dimension[xObjetivo][yObjetivo]));

                    // Llamar al método generarAtaque
                    //generarAtaque(s, izq, dimension[xObjetivo][yObjetivo]);
                    
                    
                    turnos--;
                    System.out.println("Tienes " + turnos + " turnos\n\n");
                    break;

                case 4: // Buscar equipo
                    Casilla c = buscarCasillaOrigen(s);
                    System.out.println(c.toString());
                    Equipo e = c.buscarEquipo(s);
                    if(e != null) {
                        if(e instanceof Arma) {
                            System.out.println("Has encontrado un arma!: " + e.toString());
                            turnos--;
                        } else if (e instanceof Provision) {
                            System.out.println("Has encontrado una provision!: " + e.toString());
                            turnos--;
                        }

                    } else {
                        System.out.println("No has encontrado nada.");
                    }
                    System.out.println("Tienes " + turnos + " turnos\n\n");
                    break;

                case 5: // Cambiar arma
                    // Mostrar todas las armas que tiene el superviviente
                    System.out.println("Armas disponibles:");

                    // Recorremos el inventario y mostramos las armas
                    for (int i = 0; i < s.getInventario().length; i++) {
                        if (s.getInventario()[i] instanceof Arma) {
                            System.out.println("Nombre : " + ((Arma) s.getInventario()[i]).getNombre() +
                                    "\tId: " + ((Arma) s.getInventario()[i]).getId());
                        }
                    }

                    // Pedir al jugador que elija el arma
                    Scanner aux = new Scanner(System.in);
                    System.out.println("Selecciona la ID del arma que deseas equipar:");
                    int id = aux.nextInt();

                    // Verificar que el id es válido

                    if (s.estaArmaEnInventario(id)) {
                        Arma arma = s.getArma(id);
                        // Preguntar si se quiere equipar en la mano izquierda o derecha
                        System.out.println("¿Quieres equipar el arma en la mano izquierda o derecha? (I/D):");
                        char mano = aux.next().toUpperCase().charAt(0);

                        if (mano == 'I') {
                            // Ejecutamos el método elegirArma pasando el arma y la mano elegida
                            s.elegirArma(arma, true);
                            System.out.println("Has cambiado el arma a la mano izquierda\n");
                        } else {
                            s.elegirArma(arma, false);
                            System.out.println("Has cambiado el arma a la mano derecha\n");
                        }
                    } else {
                        System.out.println("Índice no válido. Asegúrate de elegir un arma en el inventario.");
                    }
                    
                    // QUITAR ESTE COMENTARIO turnos--;
                    System.out.println("Tienes " + turnos + " turnos\n\n");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    ejecutarAccionesSupervivientes(s); // Repetir si la opción es inválida
                    break;
            }
        }
        
    }
    
    public boolean generarNuevoZombi() {
        for (int i = 0; i < NUM_ZOMBIS_NUEVOS_POR_TURNO; i++) {
            // Genera una posicion aleatoria para un zombi que cumpla
            // que no este en una casilla adyacente a un superviviente
            boolean valido = true;
            int x,y;
            do {
                valido = true;
                x = (int) (Math.random() * TAM_X);
                y = (int) (Math.random() * TAM_Y);

                // Comprobamos si hay algún superviviente en las casillas adyacentes
                // Coordenadas de las casillas adyacentes
                int[][] adyacentes = {
                    {x, y},     // Misma casilla
                    {x + 1, y}, // Sur
                    {x, y + 1}, // Este
                    {x - 1, y}, // Norte
                    {x, y - 1},  // Oeste
                    {x + 1, y + 1},
                    {x + 1, y - 1},
                    {x - 1, y + 1},
                    {x - 1, y - 1}
                };

                // Verificar cada casilla adyacente
                for (int[] coord : adyacentes) {
                    int x1 = coord[0];
                    int y1 = coord[1];

                    // Verificar que las coordenadas estén dentro de los límites del mapa
                    if (x1 >= 0 && x1 < TAM_X && y1 >= 0 && y1 < TAM_Y) {
                        // Verificar si hay algún superviviente vivo en esa casilla
                        if (dimension[x1][y1].hayAlgunSupervivienteVivo()) {
                            valido = false;
                            break; // Detenemos el bucle si ya encontramos uno
                        }
                    }
                }
            } while (!valido);

            int numero = (int) (Math.random() * 10); // Genera un número entre 0 y 9

            // CAMINANTE (0-5), CORREDOR (6-8), ABOMINACIÓN (9)
            if (numero < PROBABILIDAD_CAMINANTE) { // 60% de probabilidad
                switch ((int) (Math.random() * 3)) { // Me genera un número entre 0 y 2
                    case 0:
                        dimension[x][y].anadirEntidad(new Caminante());
                        break;
                    case 1:
                        dimension[x][y].anadirEntidad(new CaminanteBerserker());
                        break;
                    case 2:
                        dimension[x][y].anadirEntidad(new CaminanteToxico());
                        break;
                }
            } else if (numero >= PROBABILIDAD_CAMINANTE && numero < PROBABILIDAD_CORREDOR) { // 30% de probabilidad
                switch ((int) (Math.random() * 3)) { // Me genera un número entre 0 y 2
                    case 0:
                        dimension[x][y].anadirEntidad(new Corredor());
                        break;
                    case 1:
                        dimension[x][y].anadirEntidad(new CorredorBerserker());
                        break;
                    case 2:
                        dimension[x][y].anadirEntidad(new CorredorToxico());
                        break;
                }
            } else { // 10% de probabilidad
                switch ((int) (Math.random() * 3)) { // Me genera un número entre 0 y 2
                    case 0:
                        dimension[x][y].anadirEntidad(new Abominacion());
                        break;
                    case 1:
                        dimension[x][y].anadirEntidad(new AbominacionBerserker());
                        break;
                    case 2:
                        dimension[x][y].anadirEntidad(new AbominacionToxico());
                        break;
                }
            }
        }
        return true;
    }
    
    public boolean generarZombisInicio() {
        for (int i = 0; i < NUM_ZOMBIS_INICIO; i++) {
            generarNuevoZombi();
        }
        return true;
    }
    
    public boolean asignarSupervivientesPosicionInicial(String [] listaS) {
        for (int i=0; i<listaS.length-1; i++) {
            for (int j=i+1; j<listaS.length; j++) {
                if (listaS[i].equals(listaS[j])) return false;
            }
        }
        
        int x = CASILLA_INICIO.getX();
        int y = CASILLA_INICIO.getY();
        
        for (int i=0; i<listaS.length; i++) {
            dimension[x][y].anadirEntidad(new Superviviente(listaS[i]));
        }
        
        return true;
    }
    
    public boolean hayAlgunSupervivienteMuerto() {
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                if (dimension[i][j].hayAlgunSupervivienteMuerto()) {
                    System.out.println("Han matado a un superviviente");
                    return true;
                }
            }
        }
        return false;
    }
    
    private int numeroZombis() {
        int num = 0;
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                num += dimension[i][j].numeroZombis();
            }
        }
        return num;
    }
    
    public boolean hanGanadoSupervivientes(String [] listaS) {
        int x = CASILLA_FIN.getX();
        int y = CASILLA_FIN.getY();
        
        if (dimension[x][y].numeroSupervivientes() == listaS.length 
                && !dimension[x][y].noTieneProvisionSuperviviente()) {
            System.out.println("Han ganado los supervivientes");
            return true;
        }
        
        /*for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                if (!dimension[i][j].equals(CASILLA_FIN) && dimension[i][j].hayAlgunSuperviviente()
                        && dimension[i][j].noTieneProvisionSuperviviente()) return false;
            }
        }*/
        return false;
    }

    // Este método solo funciona cuando la casilla está adyacente
    public boolean moverse(Casilla destino, EntidadActivable e) {
        Casilla origen = buscarCasillaOrigen(e); // Encuentra la casilla actual de la entidad

        if (origen.esAdyacente(destino) // Verifica si la casilla destino es adyacente
                && destino.getX() >= 0 && destino.getX() <= TAM_X && destino.getY() >= 0 && destino.getY() <= TAM_Y) {  // Y si esta dentro del tablero 
            origen.eliminarEntidad(e); // Quita la entidad de la casilla actual
            destino.anadirEntidad(e); // Coloca la entidad en la casilla destino
            return true; // Movimiento exitoso
        }
        return false; // Movimiento inválido
    }

    
    public boolean generarAtaque(Superviviente s, Arma a, Casilla objetivo) {
        Casilla origen = buscarCasillaOrigen(s); // Encuentra la posición del superviviente

        if (!seleccionarObjetivo(origen, a, objetivo)) { // Comprueba si el objetivo está en el rango del arma
            System.err.println("Arma fuera de rango");
            return false;
        }
        
        int dados[] = lanzarDados(a);
        int exitos = evaluarExito(dados, a); // Calcula los éxitos del ataque basados en los dados
        
        Ataque ataque = new Ataque(s, a, dados, exitos, objetivo);
        listaAtaques.add(ataque);
        
        return resolverAtaque(a, objetivo, exitos, s); // Resuelve el ataque eliminando enemigos si aplica
    }

    
    private Arma elegirArma(Superviviente s, boolean izq) {
        // Busca el arma en todas las casillas del tablero
        for (int i = 0; i < TAM_X; i++) {
            for (int j = 0; j < TAM_Y; j++) {
                Arma a = dimension[i][j].buscarArma(s, izq); // Busca el arma en una casilla específica
                if (a != null) return a; // Retorna el arma encontrada
            }
        }
        return null; // Devuelve null si no encuentra el arma
    }

    public Casilla buscarCasillaOrigen(EntidadActivable e) {
        // Encuentra la casilla donde se encuentra la entidad activable
        for (int i = 0; i < TAM_X; i++) {
            for (int j = 0; j < TAM_Y; j++) {
                if (dimension[i][j].estaEntidad(e)) return dimension[i][j]; // Devuelve la casilla si contiene la entidad
            }
        }
        return null; // Devuelve null si no encuentra la entidad
    }

    private boolean seleccionarObjetivo(Casilla origen, Arma a, Casilla destino) {
        // Comprueba si el destino está dentro del rango del arma
        return a.estaDentroDelRango(origen.distancia(destino));
    }

    private int[] lanzarDados(Arma a) {
        // Simula el lanzamiento de los dados basados en el número que permite el arma
        int[] v = new int[a.getNumeroDeDados()];
        for (int i = 0; i < v.length; i++) {
            v[i] = a.tirarDado(); // Genera el valor del dado
        }
        return v; // Devuelve los resultados de los lanzamientos
    }

    private int evaluarExito(int[] v, Arma a) {
        int contador = 0;
        // Cuenta los lanzamientos exitosos según el valor de éxito requerido por el arma
        for (int i = 0; i < v.length; i++) {
            if (a.getValorDeExito() <= v[i]) contador++;
        }
        return contador; // Devuelve el número de éxitos
    }

    private boolean resolverAtaque(Arma a, Casilla destino, int exitos, Superviviente s) {
        // Elimina los zombis en la casilla objetivo si el número de éxitos es suficiente
        return eliminarZombis(a, exitos, s, destino);
    }
    
    /*public boolean esMatable(Arma a, Zombi z, Superviviente s) {
        // Verifica si el zombi es de tipo CaminanteBerserker, CorredorBerserker o AbominacionBerserker
        Casilla casillaSuperviviente = buscarCasillaOrigen(s);
        Casilla casillaZombi = buscarCasillaOrigen(z);
        if((z instanceof CaminanteBerserker) || (z instanceof CorredorBerserker) || (z instanceof AbominacionBerserker)) {
            /*Si es un zombi Berserker, debe cumplir dos condiciones:
            1. El arma debe tener suficiente potencia para eliminar al zombi (potencia >= aguante)
            2. El arma debe ser cuerpo a cuerpo (alcance == 0), ya que los zombis Berserker son inmunes a ataques a distancia.<
           return (a.getPotencia() >= z.getAguante()) && casillaSuperviviente.distancia(casillaZombi) == 0;
        } else {
            // Si el zombi no es un Berserker, solo se verifica que el arma tenga suficiente potencia y que tenga suficiente alcance.
            if(a.getAlcance() == 0) { // Armas de corto alcance
                return (a.getPotencia() >= z.getAguante()) && casillaSuperviviente.distancia(casillaZombi) == 0;
            } else {
                return (a.getPotencia() >= z.getAguante()) && casillaSuperviviente.distancia(casillaZombi) <= a.getAlcance();
            }
        }
    }*/
    
    public boolean eliminarZombis(Arma a, int exitos, Superviviente s, Casilla destino) {
        ArrayList<EntidadActivable> zombisAEliminar = new ArrayList<>(); // Lista para almacenar los zombis eliminables
        
        for (EntidadActivable e : destino.getListaEntidades()) { // Itera por las entidades de la casilla
            if (exitos == 0) { // Si no quedan éxitos, detiene el proceso
                break;
            } else if (e instanceof Zombi) { // Verifica si la entidad es un Zombi
                if (((Zombi) e).esMatable(a)) { // Comprueba si el zombi puede ser eliminado con el arma
                    // Si el zombi a matar es toxico se hiere a todos los supervivientes de una casilla
                    if (((Zombi) e) instanceof CaminanteToxico ||
                            ((Zombi) e) instanceof AbominacionToxico ||
                            ((Zombi) e) instanceof CorredorToxico) {
                        destino.herirSupervivientes();
                    }
                    zombisAEliminar.add(e); // Añade el zombi a la lista de eliminables
                    exitos--;
                }
            }
        }

        destino.eliminarEntidad(zombisAEliminar);

        // Actualizamos la lista de zombis eliminados por el superviviente
        s.sumarZombisKO(zombisAEliminar.size());

        return true;  // Cabmiar el true si sale mal a: !zombisAEliminar.isEmpty()
    }
}
