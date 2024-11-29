package apoocalipsis;
import apoocalipsis.Arma;
import java.util.Scanner;

public class Juego {
    private boolean turno; // true = turno del superviviente, false = turno del zombi
    private Casilla[][] dimension; // Representación del tablero del juego como matriz de casillas

    private static final int TAM_X = 10; // Tamaño del tablero en el eje X
    private static final int TAM_Y = 10; // Tamaño del tablero en el eje Y
    
    private static final Casilla CASILLA_INICIO = new Casilla(0, 0);
    private static final Casilla CASILLA_FIN = new Casilla(9, 9);
    
    private static final int NUM_ZOMBIS_NUEVOS_POR_TURNO = 2;
    private static final int TURNOS_SUPERVIVIENTES = 3;
    

    public Juego() {
        dimension = new Casilla[TAM_X][TAM_Y]; // Inicializa el tablero con casillas vacías
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                dimension[i][j] = new Casilla(i, j);
            }
        }
        turno = true;
    }
    
    // Metodo que gestiona todo el ciclo de una partida
    public boolean hacerPartida(String [] listaNombres) {
        asignarSupervivientesPosicionInicial(listaNombres);
        
        do {
            turnoSupervivientes(listaNombres);
            turnoZombis();
            generarNuevosZombis();
        } while (!hayAlgunSupervivienteMuerto() && !hanGanadoSupervivientes());
        return true;
    }
    
    private boolean turnoSupervivientes(String [] listaS) {
        for(int λ=0; λ<listaS.length; λ++) {
            for(int φ=0; φ<TAM_X; φ++) {
                for(int Ψ=0; Ψ<TAM_Y ; Ψ++) {
                    if(dimension[φ][Ψ].hayAlgunSuperviviente(listaS[λ])) {
                        for(int ϑ=0; ϑ<TURNOS_SUPERVIVIENTES; ϑ++) {
                            ejecutarAccionesSupervivientes(dimension[φ][Ψ].getSuperviviente(listaS[λ]));
                        }
                    }
                }
            }
        }
        return true;
    }

    public void ejecutarAccionesSupervivientes(Superviviente s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Acciones disponibles para el Superviviente:");
        System.out.println("1. No hacer nada");
        System.out.println("2. Moverse");
        System.out.println("3. Atacar");
        System.out.println("4. Buscar equipo");
        System.out.println("5. Cambiar arma");
        System.out.print("Selecciona la acción que deseas realizar (1-5): ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1: // No hacer nada
                break;
            case 2: // Moverser
                int xDestino, yDestino;
                do {
                    System.out.print("Introduce la coordenada X de la casilla destino (0-10): ");
                    xDestino = scanner.nextInt();
                    System.out.print("Introduce la coordenada Y de la casilla destino (0-10): ");
                    yDestino = scanner.nextInt();

                    if (xDestino < 0 || xDestino >= TAM_X || yDestino < 0 || yDestino >= TAM_Y) {
                        System.out.println("Coordenadas fuera del rango permitido. Intenta de nuevo.");
                    }
                } while (xDestino < 0 || xDestino >= TAM_X || yDestino < 0 || yDestino >= TAM_Y);

                moverse(new Casilla(xDestino, yDestino), s);
                break;

            case 3: // Atacar

                System.out.println("Iniciando ataque...");

                // Pedir si usará el arma izquierda o derecha
                System.out.print("¿Usar el arma izquierda? (true para izquierda, false para derecha): ");
                boolean izq = scanner.nextBoolean();

                // Pedir las coordenadas de la casilla objetivo
                int xObjetivo, yObjetivo;
                do {
                    System.out.print("Introduce la coordenada X de la casilla objetivo (0-10): ");
                    xObjetivo = scanner.nextInt();
                    System.out.print("Introduce la coordenada Y de la casilla objetivo (0-10): ");
                    yObjetivo = scanner.nextInt();

                    if (xObjetivo < 0 || xObjetivo >= TAM_X || yObjetivo < 0 || yObjetivo >= TAM_Y) {
                        System.out.println("Coordenadas fuera del rango permitido. Intenta de nuevo.");
                    }
                } while (xObjetivo < 0 || xObjetivo >= TAM_X || yObjetivo < 0 || yObjetivo >= TAM_Y);

                // Llamar al método generarAtaque
                generarAtaque(s, izq, new Casilla(xObjetivo, yObjetivo));
                break;
                
            case 4: // Buscar equipo
                Casilla c = buscarCasillaOrigen(s);
                c.buscarEquipo(s);
                break;

            case 5: // Cambiar arma
                // Mostrar todas las armas que tiene el superviviente
                System.out.println("Armas disponibles:");

                // Recorremos el inventario y mostramos las armas
                for (int i = 0; i < s.getInventario().length; i++) {
                    if (s.getInventario()[i] instanceof Arma) {
                        System.out.println(i + ": " + ((Arma) s.getInventario()[i]).getNombre());
                        System.out.println(i + ": " + ((Arma) s.getInventario()[i]).getId());
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
                    } else {
                        s.elegirArma(arma, false);
                    }
                } else {
                    System.out.println("Índice no válido. Asegúrate de elegir un arma en el inventario.");
                }
                break;
                
            default:
                System.out.println("Opción no válida. Intenta nuevamente.");
                ejecutarAccionesSupervivientes(s); // Repetir si la opción es inválida
                break;
        }
    }

    
    private boolean turnoZombis() {
        //activacionesZombies()
        //zombiMuerdeSuperviviente()
        //zombiMueveHaciaSuperviviente()
        return false;
    }
    
    private boolean generarNuevosZombis() {
        for (int i=0; i<NUM_ZOMBIS_NUEVOS_POR_TURNO; i++) {
            // Genera una posicion aleatoria para un zombi que cumpla
            // que no este en una casilla adyacente a un superviviente
            boolean valido = true;
            int x,y;
            do {
                valido = true;
                x = (int) (Math.random() * TAM_X) + 1;
                y = (int) (Math.random() * TAM_Y) + 1;
                
                // Comprobamos si hay algun superviviente en alguna de las adyacentes
                int x1 = x + 1;
                int y1 = y;
                if (dimension[x1][y1].hayAlgunSuperviviente()) valido = false;
                x1 = x;
                y1 = y + 1;
                if (dimension[x1][y1].hayAlgunSuperviviente()) valido = false;
                x1 = x - 1;
                y1 = y;
                if (dimension[x1][y1].hayAlgunSuperviviente()) valido = false;
                x1 = x;
                y1 = y - 1;
                if (dimension[x1][y1].hayAlgunSuperviviente()) valido = false;
            } while (!valido);
            
            int numero = (int) (Math.random() * 9);
            
            switch(numero) {
                case 0:
                    dimension[x][y].anadirEntidad(new Abominacion());
                    break;
                case 1:
                    dimension[x][y].anadirEntidad(new AbominacionBerserker());
                    break;
                case 2:
                    dimension[x][y].anadirEntidad(new AbominacionToxico());
                    break;
                case 3:
                    dimension[x][y].anadirEntidad(new Caminante());
                    break;
                case 4:
                    dimension[x][y].anadirEntidad(new CaminanteBerserker());
                    break;
                case 5:
                    dimension[x][y].anadirEntidad(new CaminanteToxico());
                    break;
                case 6:
                    dimension[x][y].anadirEntidad(new Corredor());
                    break;
                case 7:
                    dimension[x][y].anadirEntidad(new CorredorBerserker());
                    break;
                case 8:
                    dimension[x][y].anadirEntidad(new CorredorToxico());
                    break;
            }
        }
        return true;
    }
    
    
    private boolean asignarSupervivientesPosicionInicial(String [] listaS) {
        for (int i=0; i<listaS.length-1; i++) {
            for (int j=i+1; j<listaS.length; j++) {
                if (listaS[i].equals(listaS[j])) return false;
            }
        }
        
        int x = CASILLA_INICIO.getX()-1;
        int y = CASILLA_INICIO.getY()-1;
        
        for (int i=0; i<listaS.length; i++) {
            dimension[x][y].anadirEntidad(new Superviviente(listaS[i]));
        }
        
        return true;
    }
    
    private boolean hayAlgunSupervivienteMuerto() {
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                if (dimension[i][j].hayAlgunSupervivienteMuerto()) return true;
            }
        }
        return false;
    }
    
    private boolean hanGanadoSupervivientes() {
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                if (!dimension[i][j].equals(CASILLA_FIN) &&
                        dimension[i][j].hayAlgunSuperviviente())   return false;
            }
        }
        return true;
    }

    public boolean moverse(Casilla destino, EntidadActivable e) {
        Casilla origen = buscarCasillaOrigen(e); // Encuentra la casilla actual de la entidad

        if (origen.esAdyacente(destino)) { // Verifica si la casilla destino es adyacente
            origen.eliminarEntidad(e); // Quita la entidad de la casilla actual
            destino.anadirEntidad(e); // Coloca la entidad en la casilla destino
            return true; // Movimiento exitoso
        }
        return false; // Movimiento inválido
    }

    public boolean generarAtaque(Superviviente s, boolean izq, Casilla objetivo) {
        Arma a;
        try {
            a = elegirArma(s, izq); // Intenta elegir el arma del superviviente
        } catch (Exception e) {
            System.err.println("ElegirArma devuelve null"); // Maneja el caso de arma no encontrada
            return false; // Ataque falla si no hay arma
        }

        Casilla origen = buscarCasillaOrigen(s); // Encuentra la posición del superviviente

        if (!seleccionarObjetivo(origen, a, objetivo)) { // Comprueba si el objetivo está en el rango del arma
            System.err.println("Arma fuera de rango");
            return false;
        }

        int exitos = evaluarExito(lanzarDados(a), a); // Calcula los éxitos del ataque basados en los dados

        return resolverAtaque(a, objetivo, exitos); // Resuelve el ataque eliminando enemigos si aplica
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

    private Casilla buscarCasillaOrigen(EntidadActivable e) {
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

    private boolean resolverAtaque(Arma a, Casilla destino, int exitos) {
        // Elimina los zombis en la casilla objetivo si el número de éxitos es suficiente
        return destino.eliminarZombis(a, exitos);
    }
}
