public interface InterfazPlayer_21542985_OrtegaQuinteros {
    // Selectores

    /**
     * getId() de la clase Player
     * Retorna el identificador del jugador (int)
     */
    int getId();

    /**
     * getWins() de la clase Player
     * Retorna las victorias del jugador (int)
     */
    int getWins();

    /**
     * getLosses() de la clase Player
     * Retorna las derrotas del jugador (int)
     */
    int getLosses();

    /**
     * getDraws() de la clase Player
     * Retorna los empates del jugador (int)
     */
    int getDraws();

    /**
     * getRemainingPieces() de la clase Player
     * Retorna las piezas restantes del jugador (int)
     */
    int getRemainingPieces();

    /**
     * getName() de la clase Player
     * Retorna el nombre del jugador (String)
     */
    String getName();

    /**
     * getColor() de la clase Player
     * Retorna el color del jugador (String)
     */
    String getColor();

    // Modificador

    /**
     * lessPiece() de la clase Player
     * Retorna el jugador con una pieza menos
     */
    void restarPiezaPlayer();

    // Otros

    /**
     * mostrarEstadisticas() de la clase Player
     * Imprime en pantalla todos los parametros del jugador
     */
    void mostrarEstadisticas();

    /**
     * actualizarEstadisticas() de la clase Player
     * Actualiza al jugador segun el resultado del juego
     */
    void actualizarEstadisticas(String resultado);
}