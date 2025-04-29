package uppgift1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService service = new CalculatorService();

        System.out.println("🔢 Välkommen till miniräknaren!");
        System.out.println("1. Addera");
        System.out.println("2. Subtrahera");
        System.out.println("3. Multiplicera");
        System.out.println("4. Dividera");
        System.out.print("Välj en operation (1-4): ");
        int val = scanner.nextInt();

        System.out.print("Ange första talet: ");
        int tal1 = scanner.nextInt();

        System.out.print("Ange andra talet: ");
        int tal2 = scanner.nextInt();

        switch (val) {
            case 1:
                System.out.println("✅ Resultat: " + tal1 + " + " + tal2 + " = " + service.addNumbers(tal1, tal2));
                break;
            case 2:
                System.out.println("✅ Resultat: " + tal1 + " - " + tal2 + " = " + service.subtractNumbers(tal1, tal2));
                break;
            case 3:
                System.out.println("✅ Resultat: " + tal1 + " * " + tal2 + " = " + service.multiplyNumbers(tal1, tal2));
                break;
            case 4:
                try {
                    System.out.println("✅ Resultat: " + tal1 + " / " + tal2 + " = " + service.divideNumbers(tal1, tal2));
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Fel: " + e.getMessage());
                }
                break;
            default:
                System.out.println("❌ Ogiltigt val.");
        }
    }
}
