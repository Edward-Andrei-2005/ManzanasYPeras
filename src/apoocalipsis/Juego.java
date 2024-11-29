package apoocalipsis;

public class Juego {
    private boolean turno; // true = turno del superviviente, false = turno del zombi
    private Casilla[][] dimension; // Representación del tablero del juego como matriz de casillas

    private static final int TAM_X = 10; // Tamaño del tablero en el eje X
    private static final int TAM_Y = 10; // Tamaño del tablero en el eje Y
    
    private static final Casilla CASILLA_INICIO = new Casilla(1, 1);
    private static final Casilla CASILLA_FIN = new Casilla(10, 10);
    
    private static final int NUM_ZOMBIS_NUEVOS_POR_TURNO = 2;

    public Juego() {
        dimension = new Casilla[TAM_X][TAM_Y]; // Inicializa el tablero con casillas vacías
        for (int i=0; i<TAM_X; i++) {
            for (int j=0; j<TAM_Y; j++) {
                dimension[i][j] = new Casilla(i+1, j+1);
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
    }
    
    private boolean turnoSupervivientes(String [] listaS) {
        
    }
    
    private boolean turnoZombis() {
        
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
