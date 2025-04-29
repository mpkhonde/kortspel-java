package uppgift4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CalculatorService calculator = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🧮 Välkommen till min interaktiva miniräknare!");
        System.out.print("Skriv första talet: ");
        int a = scanner.nextInt();

        System.out.print("Skriv andra talet: ");
        int b = scanner.nextInt();

        System.out.println("\nVälj ett räknesätt:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraktion (-)");
        System.out.println("3. Multiplikation (*)");
        System.out.println("4. Division (/)");

        System.out.print("Ditt val (1-4): ");
        int val = scanner.nextInt();

        System.out.println("\n--- Resultat ---");

        switch (val) {
            case 1:
                System.out.println(a + " + " + b + " = " + calculator.addNumbers(a, b));
                break;
            case 2:
                System.out.println(a + " - " + b + " = " + calculator.subtractNumbers(a, b));
                break;
            case 3:
                System.out.println(a + " * " + b + " = " + calculator.multiplyNumbers(a, b));
                break;
            case 4:
                try {
                    System.out.println(a + " / " + b + " = " + calculator.divideNumbers(a, b));
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Ogiltigt val. Välj mellan 1 och 4.");
        }

        System.out.println("\nTack för att du räknade med mig! 👋");
        scanner.close();
    }
}
