import java.util.List;

public interface InterfazGame {

    // Selectores

    /**
     * getPlayer1() de la clase Game
     * Retorna el player1 del juego
     */
    Player getPlayer1();

    /**
     * getPlayer2() de la clase Game
     * Retorna el player2 del juego
     */
    Player getPlayer2();

    /**
     * getBoard() de la clase Game
     * Retorna el tablero del juego
     */
    Board getBoard();

    /**
     * boardGetState() de la clase Game
     * Llama al método mostrarBoard() de la clase Board con el tablero del juego
     */
    void boardGetState();

    /**
     * getCurrentPlayer() de la clase Game
     * Retorna el jugador con el turno en curso del juego
     * Se verifica quien fue el último jugador en jugar a traves del historial del juego
     */
    Player getCurrentPlayer();

    /**
     * getCurrentTurn() de la clase Game
     * Retorna el turno actual del juego
     */
    int getCurrentTurn();

    // Modificadores

    /**
     * endGame() de la clase Game
     * Finaliza un juego actualizando las estadisticas de los jugadores dependiendo del resultado de la partida
     */
    void endGame();

    /**
     * realizarMovimiento() de la clase Game
     * Realiza un movimiento en el juego
     * @param player Jugador que realiza la jugada
     * @param columna Indice de la columna en donde se realiza la jugada
     */
    void realizarMovimiento(Player player, int columna);

    // Otros

    /**
     * historial() de la clase Game
     * Imprime el historial del juego en pantalla
     */
    void historial();

    /**
     * esEmpate() de la clase Game
     * Determina si el juego actual es un empate verificando las piezas restantes de los jugadores y verificando si hay victoria
     * @return {@code true} si el juego finaliza en empate; {@code false} en caso contrario
     */
    boolean esEmpate();

    /**
     * mostrarJuego() de la clase Game
     * Imprime los parametros del juego
     */
    void mostrarJuego();
}