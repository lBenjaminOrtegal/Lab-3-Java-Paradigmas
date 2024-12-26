import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player_21542985_OrtegaQuinteros player1 = null;
        Player_21542985_OrtegaQuinteros player2 = null;
        Game_21542985_OrtegaQuinteros G0 = null;
        Board_21542985_OrtegaQuinteros B0 = new Board_21542985_OrtegaQuinteros();
        String nombre1;
        String nombre2;
        String color1;
        String color2;
        int fichas = 0;

        int opcion;
        int cantidad_players = 0;
        String desicion = "0";

        while (!desicion.equals("S")) {
            mostrarMenu();
            System.out.print("\nIngrese su opcion: ");
            if (!scanner.hasNextInt()) { // comprobación opcion
                System.out.println("\nIngresa un numero (1-6) en este apartado.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("### Crear Nuevo Juego ###");

                    System.out.println("--- Configuración Jugador 1 ---");
                    System.out.print("Ingrese nombre del jugador 1: ");
                    nombre1 = scanner.next();
                    System.out.print("Color asignado: ");
                    color1 = scanner.next();

                    System.out.println("\n--- Configuración Jugador 2 ---");
                    System.out.print("Ingrese nombre del jugador 2: ");
                    nombre2 = scanner.next();
                    System.out.print("Color asignado: ");
                    color2 = scanner.next();

                    System.out.println("\n--- Configuración del Juego ---");
                    System.out.print("Ingrese cantidad de fichas por jugador (4-21): ");

                    int flag = 0;
                    while (flag == 0) { // comprobación fichas
                        if (!scanner.hasNextInt()) {
                            System.out.println("\nDebes ingresar un numero (4-21) en este apartado.");
                            scanner.next();
                            continue;
                        }
                        fichas = scanner.nextInt();
                        if (fichas < 4 || fichas > 21) {
                            System.out.println("\nDebes ingresar un numero (4-21) en este apartado.");
                            continue;
                        }
                        flag = 1;
                    }

                    System.out.println("\n¡Juego creado exitosamente!");
                    cantidad_players++;
                    player1 = new Player_21542985_OrtegaQuinteros(cantidad_players, nombre1, color1,0, 0, 0, fichas);
                    cantidad_players++;
                    player2 = new Player_21542985_OrtegaQuinteros(cantidad_players, nombre2, color2, 0, 0, 0, fichas);
                    G0 = new Game_21542985_OrtegaQuinteros(player1, player2, B0, 1);
                    break;
                case 2:
                    System.out.println("Estado Actual del Tablero:");
                    B0.mostrarBoard();
                    break;
                case 3:
                    if (G0 == null) {
                        System.out.println("\nNo hay juegos creados.");
                    }
                    else if (G0.esEmpate() || G0.getBoard().entregarGanador(G0.getPlayer1(), G0.getPlayer2()) != 0) {
                        System.out.println("\n### Este juego esta terminado ###");
                        break;
                    }
                    else {
                        System.out.println("\n### Realizar Jugada ###");
                        System.out.println("Turno de: " + G0.getCurrentPlayer().getName() + " (" + G0.getCurrentPlayer().getColor() + ")");
                        System.out.println("Fichas restantes: " + G0.getCurrentPlayer().getRemainingPieces());

                        int columna = 0;
                        System.out.print("Seleccione columna (0-6): ");
                        int columnFlag = 0;
                        while (columnFlag == 0) { // comprobación columna
                            if (!scanner.hasNextInt()) {
                                System.out.println("\nDebes ingresar un numero (0-6) en este apartado.");
                                scanner.next();
                                continue;
                            }
                            columna = scanner.nextInt();
                            if (columna < 0 || columna > 6) {
                                System.out.println("\nDebes ingresar un numero (0-6) en este apartado.");
                                continue;
                            }
                            columnFlag = 1;
                        }
                        System.out.println("Movimiento realizado: ");
                        G0.realizarMovimiento(G0.getCurrentPlayer(), columna);
                    }
                    break;
                case 4:
                    if (player1 == null) {
                        System.out.println("\nNo hay jugadores creados.");
                    }
                    else {
                        System.out.println("\nEstadisticas Generales:");
                        player1.mostrarEstadisticas();
                        player2.mostrarEstadisticas();
                    }
                    break;
                case 5:
                    if (G0 == null) {
                        System.out.println("\nNo hay juegos creados.");
                    }
                    else {
                        System.out.println("Juego completo detallado:");
                        G0.mostrarJuego();
                    }
                    break;
                case 6:
                    System.out.println("¿Está seguro que desea salir? (S/N): ");
                    desicion = scanner.next();
                    if (desicion.equals("s".toUpperCase()) || desicion.equals("s")) {
                        System.out.println("¡Gracias por jugar Conecta4!");
                        return;
                    }
                    else if (desicion.equals("N") || desicion.equals("n")) {
                        System.out.println("Entendido, volviendo al menu principal.");
                        break;
                    }
                default:
                    System.out.println("Opcion incorrecta, ingresala nuevamente.");
                    break;
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\n### Conecta4 - Menú Principal ###");
        System.out.println("Bienvenido al juego Conecta4");
        System.out.println("Seleccione una opción:\n");
        System.out.println("1. Crear nuevo juego");
        System.out.println("2. Visualizar estado actual");
        System.out.println("3. Realizar jugada");
        System.out.println("4. Ver estadísticas generales");
        System.out.println("5. Ver juego completo");
        System.out.println("6. Salir del juego");
    }
}