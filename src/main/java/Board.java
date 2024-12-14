public class Board {
    public String[][] board = new String[6][7];

    // Constructor

    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.board[i][j] = " ";
            }
        }
    }

    // Modificador

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

    public boolean sePuedeJugar() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j].equals(" ")) {
                return true;
            }
        }
        return false;
    }

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
}