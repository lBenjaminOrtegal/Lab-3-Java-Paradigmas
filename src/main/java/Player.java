/**
 * Clase Player
 * Representa a un jugador en el juego, almacenando su información y estadísticas
 * Esta clase incluye atributos para identificar al jugador, registrar sus estadísticas
 * (victorias, derrotas, empates) y administrar sus piezas restantes
 */
public class Player {
    private final int id;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;
    private final String name;
    private final String color;

    // Constructor

    /**
     * Constructor de la clase Player
     * Crea un jugador con los atributos necesarios para ser utilizado en el juego
     *
     * @param id Identificador único del jugador
     * @param name Nombre del jugador
     * @param color Color asociado al jugador en el juego
     * @param wins Número de victorias acumuladas por el jugador
     * @param losses Número de derrotas acumuladas por el jugador
     * @param draws Número de empates acumulados por el jugador
     * @param remainingPieces Número de piezas restantes disponibles para el jugador
     */
    public Player(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }

    // Selectores

    /**
     * getId() de la clase Player
     * Retorna el identificador del jugador (int)
     */
    public int getId() {
        return id;
    }

    /**
     * getWins() de la clase Player
     * Retorna las victorias del jugador (int)
     */
    public int getWins() {
        return wins;
    }

    /**
     * getLosses() de la clase Player
     * Retorna las derrotas del jugador (int)
     */
    public int getLosses() {
        return losses;
    }

    /**
     * getDraws() de la clase Player
     * Retorna los empates del jugador (int)
     */
    public int getDraws() {
        return draws;
    }

    /**
     * getRemainingPieces() de la clase Player
     * Retorna las piezas restantes del jugador (int)
     */
    public int getRemainingPieces() {
        return remainingPieces;
    }

    /**
     * getName() de la clase Player
     * Retorna el nombre del jugador (String)
     */
    public String getName() {
        return name;
    }

    /**
     * getColor() de la clase Player
     * Retorna el color del jugador (String)
     */
    public String getColor() {
        return color;
    }

    // Otros

    /**
     * mostrarEstadisticas() de la clase Player
     * Imprime en pantalla todos los parametros del jugador
     */
    public void mostrarEstadisticas () {
        System.out.println(getName() + " ("+ getColor() + ") -> Victorias: " + getWins() + ", Derrotas: " + getLosses() + ", Empates: " + getDraws() + ", Piezas: " + getRemainingPieces());
    }

    /**
     * actualizarEstadisticas() de la clase Player
     * Actualiza al jugador segun el resultado del juego
     */
    public void actualizarEstadisticas(String resultado) {
        if (resultado.equals("win")) {
            wins = getWins() + 1;
        }
        else if (resultado.equals("loss")) {
            losses = getLosses() + 1;
        }
        else {
            draws = getDraws() + 1;
        }
    }
}