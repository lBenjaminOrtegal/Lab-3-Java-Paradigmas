public interface InterfazBoard {

    // Modificador

    /**
     * jugarFicha() de la clase Board
     * Modifica un tablero agregando una pieza en la columna designada
     *
     * @param columna Indice de la columna en la cual se ingresara la pieza, es un número del 0 al 6
     * @param pieza Pieza a ingresar en el tablero (primera letra del color del player a jugar en mayúsculas)
     */
    void jugarFicha(int columna, String pieza);

    // Otros

    /**
     * mostrarBoard() de la clase Board
     * Imprime el tablero en pantalla
     */
    void mostrarBoard();

    /**
     * sePuedeJugar() de la clase Board
     * Verifica si se puede realizar una jugada en el tablero
     * @return {@code true} si hay al menos un espacio disponible en el tablero; {@code false} en caso contrario
     */
    boolean sePuedeJugar();

    /**
     * verificarVictoriaVertical() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia vertical de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria vertical; Retorna el id del ganador en caso contrario
     */
    int verificarVictoriaVertical(Player player1, Player player2);

    /**
     * verificarVictoriaHorizontal() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia horizontal de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria horizontal; Retorna el id del ganador en caso contrario
     */
    int verificarVictoriaHorizontal(Player player1, Player player2);

    /**
     * verificarVictoriaDiagonal() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia diagonal (superior o inferior) de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria diagonal; Retorna el id del ganador en caso contrario
     */
    int verificarVictoriaDiagonal(Player player1, Player player2);

    /**
     * entregarGanador() de la clase Board
     * Verifica si existe algún tipo de victoria en el tablero (vertical, horizontal o diagonal)
     * @param player1 Player1, usado para retornar el id del jugador ganador y llamar a las funciones de verificar victoria
     * @param player2 Player2, usado para retornar el id del jugador ganador y llamar a las funciones de verificar victoria
     * @return {@code 0} si no hay victoria; Retorna el id del ganador en caso contrario
     */
    int entregarGanador(Player player1, Player player2);
}