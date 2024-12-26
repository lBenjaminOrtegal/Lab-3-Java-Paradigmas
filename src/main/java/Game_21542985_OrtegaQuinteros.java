import java.util.ArrayList;
import java.util.List;

/**
 * Clase Game
 * Representa un juego, almacenando su información y parametros
 * Esta clase incluye atributos para identificar a los jugadores, identificar el estado actual del tablero
 * y representar el historial de juego
 */
public class Game_21542985_OrtegaQuinteros implements InterfazGame_21542985_OrtegaQuinteros {
    private final Player_21542985_OrtegaQuinteros player1;
    private final Player_21542985_OrtegaQuinteros player2;
    private final Board_21542985_OrtegaQuinteros board;
    private int currentTurn;
    private final List<int[]> history;

    // Constructor

    /**
     * Constructor de la clase Game
     * Crea un juego reuniendo las clases anteriores (player y board)
     *
     * @param player1 Jugador 1 del juego, es un objeto de la clase Player
     * @param player2 Jugador 2 del juego, es un objeto de la clase Player
     * @param board Tablero del juego, es un objeto de la clase Board
     * @param currentTurn Turno actual del juego
     * Además, se crea una lista para representar el historial del juego
     */
    public Game_21542985_OrtegaQuinteros(Player_21542985_OrtegaQuinteros player1, Player_21542985_OrtegaQuinteros player2, Board_21542985_OrtegaQuinteros board, int currentTurn) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentTurn = currentTurn;
        this.history = new ArrayList<>();
    }

    // Selectores

    /**
     * getPlayer1() de la clase Game
     * Retorna el player1 del juego
     */
    public Player_21542985_OrtegaQuinteros getPlayer1() {
        return player1;
    }

    /**
     * getPlayer2() de la clase Game
     * Retorna el player2 del juego
     */
    public Player_21542985_OrtegaQuinteros getPlayer2() {
        return player2;
    }

    /**
     * getBoard() de la clase Game
     * Retorna el tablero del juego
     */
    public Board_21542985_OrtegaQuinteros getBoard() {
        return board;
    }

    /**
     * boardGetState() de la clase Game
     * Llama al método mostrarBoard() de la clase Board con el tablero del juego
     */
    public void boardGetState() {
        getBoard().mostrarBoard();
    }

    /**
     * getCurrentPlayer() de la clase Game
     * Retorna el jugador con el turno en curso del juego
     * Se verifica quien fue el último jugador en jugar a traves del historial del juego
     */
    public Player_21542985_OrtegaQuinteros getCurrentPlayer() {
        if (history.isEmpty()) {
            return player1;
        }
        else if (history.get(history.size() - 1)[0] == player1.getId()) {
            return player2;
        }
        return player1;
    }

    /**
     * getCurrentTurn() de la clase Game
     * Retorna el turno actual del juego
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    // Modificadores

    /**
     * endGame() de la clase Game
     * Finaliza un juego actualizando las estadisticas de los jugadores dependiendo del resultado de la partida
     */
    public void endGame() {
        int ganador = getBoard().entregarGanador(getPlayer1(), getPlayer2());
        if (ganador == 0) {
            getPlayer1().actualizarEstadisticas("draw");
            getPlayer2().actualizarEstadisticas("draw");
        }
        else if (ganador == getPlayer1().getId()) {
            getPlayer1().actualizarEstadisticas("win");
            getPlayer2().actualizarEstadisticas("loss");
        }
        else if (ganador == getPlayer2().getId()){
            getPlayer1().actualizarEstadisticas("loss");
            getPlayer2().actualizarEstadisticas("win");
        }
    }

    /**
     * realizarMovimiento() de la clase Game
     * Realiza un movimiento en el juego
     * @param player Jugador que realiza la jugada
     * @param columna Indice de la columna en donde se realiza la jugada
     */
    public void realizarMovimiento(Player_21542985_OrtegaQuinteros player, int columna) {
        if (getCurrentPlayer() == player) {
            getBoard().jugarFicha(columna, String.valueOf(player.getColor().charAt(0)));
            currentTurn++;
            if (player == getPlayer1()) {
                getPlayer1().restarPiezaPlayer();
            }
            else {
                getPlayer2().restarPiezaPlayer();
            }
            history.add(new int[] {player.getId(), columna});
            if (getBoard().entregarGanador(getPlayer1(), getPlayer2()) != 0) {
                System.out.println("\n¡VICTORIA! Jugador "+ getBoard().entregarGanador(getPlayer1(), getPlayer2()) + " ha ganado");
                endGame();
                boardGetState();
                System.out.println("\n### Estadisticas Actualizadas ###");
                getPlayer1().mostrarEstadisticas();
                getPlayer2().mostrarEstadisticas();
            }
            else if (esEmpate()) {
                System.out.println("\n¡EMPATE!");
                endGame();
                boardGetState();
                System.out.println("\n### Estadisticas Actualizadas ###");
                getPlayer1().mostrarEstadisticas();
                getPlayer2().mostrarEstadisticas();
            }
            else {
                boardGetState();
            }
        }
        else {
            System.out.println("No es tu turno de jugar!");
        }
    }

    // Otros

    /**
     * historial() de la clase Game
     * Imprime el historial del juego en pantalla
     */
    public void historial() {
        for (int i = 0; i < history.size(); i++) {
            int[] movimiento = history.get(i); // Obtiene el movimiento actual
            int jugador = movimiento[0];
            int columna = movimiento[1];
            System.out.println((i + 1) + ". Jugador " + jugador + " jugó en columna " + columna);
        }
    }

    /**
     * esEmpate() de la clase Game
     * Determina si el juego actual es un empate verificando las piezas restantes de los jugadores y verificando si hay victoria
     * @return {@code true} si el juego finaliza en empate; {@code false} en caso contrario
     */
    public boolean esEmpate() {
        if (board.entregarGanador(getPlayer1(), getPlayer2()) == 0 && player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0) {
            return true;
        }
        return board.sePuedeJugar() && player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0;
    }

    /**
     * mostrarJuego() de la clase Game
     * Imprime los parametros del juego
     */
    public void mostrarJuego() {
        System.out.println("Tablero Actual:");
        boardGetState();
        System.out.println("Turno Actual: " + getCurrentTurn());
        System.out.println("Jugador en Turno: " + getCurrentPlayer().getName());
        System.out.println("Historial del Juego: ");
        historial();
        getPlayer1().mostrarEstadisticas();
        getPlayer2().mostrarEstadisticas();
    }
}