package uppgift7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameWheel wheel = new GameWheel();
        Game game = new Game(wheel);
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Startar spelet med hjulet:");
        wheel.print();

        boolean running = true;

        while (running) {
            System.out.println("\n Välj ett alternativ:");
            System.out.println("1. Scramble hjulet");
            System.out.println("2. Sortera hjulet");
            System.out.println("3. Spela");
            System.out.println("4. Avsluta");

            System.out.print("Ditt val: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    wheel.scramble();
                    System.out.println(" Hjulet scramble: ");
                    wheel.print();
                    break;

                case "2":
                    wheel.sort();
                    System.out.println(" Hjulet sorterat: ");
                    wheel.print();
                    break;

                case "3":
                    System.out.println(" Snurrar hjulet...");
                    int totalPoints = game.play();
                    System.out.println(" Du fick totalt: " + totalPoints + " poäng!");
                    break;

                case "4":
                    System.out.println(" Tack för att du spelade!");
                    running = false;
                    break;

                default:
                    System.out.println(" Ogiltigt val, försök igen.");
            }
        }

        scanner.close();
    }
}
