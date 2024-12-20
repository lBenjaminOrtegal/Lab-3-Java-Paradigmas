import java.util.ArrayList;
import java.util.List;

/**
 * Clase Game
 * Representa un juego, almacenando su información y parametros
 * Esta clase incluye atributos para identificar a los jugadores, identificar el estado actual del tablero
 * y representar el historial de juego
 */
public class Game {
    public Player player1;
    public Player player2;
    public Board board;
    public int currentTurn;
    public List<int[]> history;

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
    public Game(Player player1, Player player2, Board board, int currentTurn) {
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
    public Player getPlayer1() {
        return player1;
    }

    /**
     * getPlayer2() de la clase Game
     * Retorna el player2 del juego
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * getBoard() de la clase Game
     * Retorna el tablero del juego
     */
    public Board getBoard() {
        return board;
    }

    /**
     * getCurrentTurn() de la clase Game
     * Retorna el turno actual del juego
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * getHistory() de la clase Game
     * Retorna el historial en forma de lista del juego, cada elemento tiene la forma (id: int, columna: int)
     */
    public List<int[]> getHistory() {
        return history;
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
}