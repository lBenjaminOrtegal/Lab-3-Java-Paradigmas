public class Player {
    public int id;
    public int wins;
    public int losses;
    public int draws;
    public int remainingPieces;
    public String name;
    public String color;

    // Constructor

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

    public int getId() {
        return id;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getRemainingPieces() {
        return remainingPieces;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    // Otros

    public void mostrarPlayer() {
        System.out.println("Estadisticas de " + name);
        System.out.println("Id: " + id);
        System.out.println("Color: " + color);
        System.out.println("Victorias: " + wins);
        System.out.println("Derrotas: " + losses);
        System.out.println("Empates: " + draws);
        System.out.println("Piezas Restantes: " + remainingPieces);
    }
}