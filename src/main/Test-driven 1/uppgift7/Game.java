package uppgift7;

public class Game {
    private GameWheel wheel;

    // Konstruktor
    public Game(GameWheel wheel) {
        this.wheel = wheel;
    }

    // Spelmetod
    public int play() {
        Slice[] spins = new Slice[3];
        int totalPrize = 0;
        boolean sameColor = true;

        for (int i = 0; i < 3; i++) {
            spins[i] = wheel.spinWheel();  // Använder fältet
            totalPrize += spins[i].getPrizeAmount();
            System.out.println("Spin " + (i + 1) + " - " + spins[i]);

            if (i > 0 && !spins[i].getColor().equals(spins[0].getColor())) {
                sameColor = false;
            }
        }

        if (sameColor) {
            totalPrize *= 2;
            System.out.println("Tre " + spins[0].getColor() + " = dubbla vinsten!");
        }

        System.out.println("Total vinst: $" + totalPrize);
        return totalPrize;
    }
}
