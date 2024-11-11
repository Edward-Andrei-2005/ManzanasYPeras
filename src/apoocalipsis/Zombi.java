package apoocalipsis;

import static apoocalipsis.TipoZombi.ABOMINACION;
import static apoocalipsis.TipoZombi.CAMINANTE;
import static apoocalipsis.TipoZombi.CORREDOR;

public abstract class Zombi {
    //Atributos
    private static int contador = 1;
    private int identificador;
    private int aguante, activaciones;
    private String reaccionAnteAtaques;
    
    //Constructores
    public Zombi (TipoCaminante caminante, TipoZombi zombi) {
        if((caminante != null) && (zombi != null)) {
            identificador = contador++;     //Si se puede crear el zombie, le ponemos un identificador
            switch(caminante) {             //Creamos el zombie dependiendo del tipo que es
                
                case NORMAL:
                    switch(zombi) {
                        case CAMINANTE:
                            aguante = 1;
                            activaciones = 1;
                            break;
                        case CORREDOR:
                            aguante = 1;
                            activaciones = 2;
                            break;
                        case ABOMINACION:
                            aguante = 3;
                            activaciones = 1;
                            break;
                    }
                    break;
                
                case BERSERKER:
                    switch(zombi) {
                        case CAMINANTE:
                            aguante = 1;
                            activaciones = 1;
                            break;
                        case CORREDOR:
                            aguante = 1;
                            activaciones = 2;
                            break;
                        case ABOMINACION:
                            aguante = 3;
                            activaciones = 1;
                            break;
                    }
                    break;
                
                case TOXICO:
                    switch(zombi) {
                        case CAMINANTE:
                            aguante = 1;
                            activaciones = 1;
                            break;
                        case CORREDOR:
                            aguante = 1;
                            activaciones = 2;
                            break;
                        case ABOMINACION:
                            aguante = 3;
                            activaciones = 1;
                            break;
                    }
                    break;
            }
        } else {
            identificador = -1; //Si algún parámetro es incorrecto ponemos el id en -1
        }
    }
}
