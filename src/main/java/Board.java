/**
 * Clase Board
 * Representa el tablero del juego, almacenando su información y estadísticas
 * Esta clase incluye atributos para inicializar el tablero
 */
public class Board {
    private final String[][] board = new String[6][7];

    // Constructor

    /**
     * Constructor de la clase Board
     * Crea un tablero inicializando cada casilla de la matriz con un espacio en blanco
     */
    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.board[i][j] = " ";
            }
        }
    }

    // Modificador

    /**
     * jugarFicha() de la clase Board
     * Modifica un tablero agregando una pieza en la columna designada
     *
     * @param columna Indice de la columna en la cual se ingresara la pieza, es un número del 0 al 6
     * @param pieza Pieza a ingresar en el tablero (primera letra del color del player a jugar en mayúsculas)
     */
    public void jugarFicha(int columna, String pieza) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][columna].equals(" ")) {
                board[i][columna] = pieza;
                return;
            }
        }
        System.out.println("Error al jugar la pieza.");
    }

    // Otros

    /**
     * mostrarBoard() de la clase Board
     * Imprime el tablero en pantalla
     */
    public void mostrarBoard() {
        System.out.print("\n     1   2   3   4   5   6   7 ");
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * sePuedeJugar() de la clase Board
     * Verifica si se puede realizar una jugada en el tablero
     * @return {@code true} si hay al menos un espacio disponible en el tablero; {@code false} en caso contrario
     */
    public boolean sePuedeJugar() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    /**
     * verificarVictoriaVertical() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia vertical de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria vertical; Retorna el id del ganador en caso contrario
     */
    public int verificarVictoriaVertical(Player player1, Player player2) {
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                String posicion1 = board[i][j];
                String posicion2 = board[i + 1][j];
                String posicion3 = board[i + 2][j];
                String posicion4 = board[i + 3][j];
                if (!posicion1.equals(" ") && posicion1.equals(posicion2) && posicion2.equals(posicion3) && posicion3.equals(posicion4)){
                    if (posicion1.equals(player1.getColor().substring(0, 1))) {
                        return player1.getId();
                    }
                    return player2.getId();
                }
            }
        }
        return 0;
    }

    /**
     * verificarVictoriaHorizontal() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia horizontal de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria horizontal; Retorna el id del ganador en caso contrario
     */
    public int verificarVictoriaHorizontal(Player player1, Player player2) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                String posicion1 = board[i][j];
                String posicion2 = board[i][j + 1];
                String posicion3 = board[i][j + 2];
                String posicion4 = board[i][j + 3];
                if (!posicion1.equals(" ") && posicion1.equals(posicion2) && posicion2.equals(posicion3) && posicion3.equals(posicion4)){
                    if (posicion1.equals(player1.getColor().substring(0, 1))) {
                        return player1.getId();
                    }
                    return player2.getId();
                }
            }
        }
        return 0;
    }

    /**
     * verificarVictoriaDiagonal() de la clase Board
     * Verifica si alguno de los jugadores gano con una secuencia diagonal (superior o inferior) de piezas
     * @param player1 Player1, usado para retornar el id del jugador ganador
     * @param player2 Player2, usado para retornar el id del jugador ganador
     * @return {@code 0} si no hay victoria diagonal; Retorna el id del ganador en caso contrario
     */
    public int verificarVictoriaDiagonal(Player player1, Player player2) {
        for (int i = 0; i < 3; i++) { // Inferior Diagonal
            for (int j = 0; j < 4; j++) {
                String posicion1 = board[i][j];
                String posicion2 = board[i + 1][j + 1];
                String posicion3 = board[i + 2][j + 2];
                String posicion4 = board[i + 3][j + 3];
                if (!posicion1.equals(" ") && posicion1.equals(posicion2) && posicion2.equals(posicion3) && posicion3.equals(posicion4)){
                    if (posicion1.equals(player1.getColor().substring(0, 1))) {
                        return player1.getId();
                    }
                    return player2.getId();
                }
            }
        }
        for (int i = 5; i > 2; i--) { // Superior Diagonal
            for (int j = 0; j < 4; j++) {
                String posicion1 = board[i][j];
                String posicion2 = board[i - 1][j + 1];
                String posicion3 = board[i - 2][j + 2];
                String posicion4 = board[i - 3][j + 3];
                if (!posicion1.equals(" ") && posicion1.equals(posicion2) && posicion2.equals(posicion3) && posicion3.equals(posicion4)){
                    if (posicion1.equals(player1.getColor().substring(0, 1))) {
                        return player1.getId();
                    }
                    return player2.getId();
                }
            }
        }
        return 0;
    }

    /**
     * entregarGanador() de la clase Board
     * Verifica si existe algún tipo de victoria en el tablero (vertical, horizontal o diagonal)
     * @param player1 Player1, usado para retornar el id del jugador ganador y llamar a las funciones de verificar victoria
     * @param player2 Player2, usado para retornar el id del jugador ganador y llamar a las funciones de verificar victoria
     * @return {@code 0} si no hay victoria; Retorna el id del ganador en caso contrario
     */
    public int entregarGanador(Player player1, Player player2) {
        int ganadorV = verificarVictoriaVertical(player1, player2);
        int ganadorH = verificarVictoriaHorizontal(player1, player2);
        int ganadorD = verificarVictoriaDiagonal(player1, player2);
        if (ganadorV == 0) {
            if (ganadorH == 0) {
                return ganadorD;
            }
            return ganadorH;
        }
        return ganadorV;
    }
}