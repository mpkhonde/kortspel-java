package uppgift6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj ett alternativ:");
            System.out.println("1. Addera två tal (sträng)");
            System.out.println("2. Multiplicera två tal (sträng)");
            System.out.println("3. Dividera två tal (sträng)");
            System.out.println("4. Testa om 0.1 + 0.2 ≈ 0.3");
            System.out.println("0. Avsluta");
            System.out.print("Val: ");
            int val = scanner.nextInt();
            scanner.nextLine(); // rensa raden

            switch (val) {
                case 1 -> {
                    System.out.print("Ange första talet: ");
                    String a = scanner.nextLine();
                    System.out.print("Ange andra talet: ");
                    String b = scanner.nextLine();
                    System.out.println("Resultat: " + service.parseAndAdd(a, b));
                }
                case 2 -> {
                    System.out.print("Ange första talet: ");
                    String a = scanner.nextLine();
                    System.out.print("Ange andra talet: ");
                    String b = scanner.nextLine();
                    System.out.println("Resultat: " + service.parseAndMultiply(a, b));
                }
                case 3 -> {
                    System.out.print("Ange första talet: ");
                    String a = scanner.nextLine();
                    System.out.print("Ange andra talet: ");
                    String b = scanner.nextLine();
                    try {
                        System.out.println("Resultat: " + service.parseAndDivide(a, b));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Fel: " + e.getMessage());
                    }
                }
                case 4 -> {
                    boolean ärNära = service.areClose(0.1 + 0.2, 0.3);
                    System.out.println("0.1 + 0.2 ≈ 0.3? " + ärNära);
                }
                case 0 -> {
                    System.out.println("Avslutar...");
                    return;
                }
                default -> System.out.println("Ogiltigt val!");
            }
        }
    }
}
