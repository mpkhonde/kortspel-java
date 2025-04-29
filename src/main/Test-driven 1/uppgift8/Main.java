package uppgift8;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        Scanner scanner = new Scanner(System.in);

        // Förifyllda produkter
        service.addProduct(new Product("Bok", 150));
        service.addProduct(new Product("Penna", 50));
        service.addProduct(new Product("Laptop", 10000));
        service.addProduct(new Product("Musmatta", 100));

        boolean kör = true;

        while (kör) {
            System.out.println("\n📋 MENY - Välj ett alternativ:");
            System.out.println("1. Visa en produkt och pris");
            System.out.println("2. Visa totalpris");
            System.out.println("3. Visa totalpris med valfri rabatt");
            System.out.println("4. Lägg till ny produkt");
            System.out.println("5. Ta bort en produkt");
            System.out.println("0. Avsluta");
            System.out.print("Ditt val: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    List<Product> produkter = service.getProducts();
                    for (int i = 0; i < produkter.size(); i++) {
                        System.out.println((i + 1) + ". " + produkter.get(i).getName());
                    }
                    System.out.print("Välj produktnummer: ");
                    try {
                        int val = Integer.parseInt(scanner.nextLine());
                        if (val >= 1 && val <= produkter.size()) {
                            Product vald = produkter.get(val - 1);
                            System.out.println("🛍️ Du valde: " + vald.getName());
                            System.out.println("💰 Pris: " + vald.getPrice() + " kr");
                        } else {
                            System.out.println("❗ Ogiltigt val.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❗ Skriv ett giltigt nummer.");
                    }
                }

                case "2" -> {
                    double total = service.getTotalPrice();
                    System.out.println("💳 Totalt pris: " + total + " kr");
                }

                case "3" -> {
                    try {
                        System.out.print("Ange rabatt i procent (ex. 10): ");
                        double rabatt = Double.parseDouble(scanner.nextLine());
                        double totalMedRabatt = service.getTotalPriceWithDiscount(rabatt);
                        System.out.printf("🎉 Totalpris med %.0f%% rabatt: %.2f kr\n", rabatt, totalMedRabatt);
                    } catch (NumberFormatException e) {
                        System.out.println("❗ Felaktig inmatning. Skriv en siffra.");
                    }
                }

                case "4" -> {
                    System.out.print("Ange produktnamn: ");
                    String namn = scanner.nextLine();

                    System.out.print("Ange pris: ");
                    try {
                        double pris = Double.parseDouble(scanner.nextLine());
                        Product ny = new Product(namn, pris);
                        service.addProduct(ny);
                        System.out.println("✅ Produkten \"" + namn + "\" tillagd!");
                    } catch (NumberFormatException e) {
                        System.out.println("❗ Felaktigt pris. Ange en siffra.");
                    }
                }

                case "5" -> {
                    List<Product> produkter = service.getProducts();

                    if (produkter.isEmpty()) {
                        System.out.println("🛒 Det finns inga produkter att ta bort.");
                        break;
                    }

                    System.out.println("📦 Produkter i listan:");
                    for (int i = 0; i < produkter.size(); i++) {
                        System.out.println((i + 1) + ". " + produkter.get(i).getName());
                    }

                    System.out.print("Ange numret på produkten du vill ta bort: ");
                    try {
                        int val = Integer.parseInt(scanner.nextLine());
                        if (val >= 1 && val <= produkter.size()) {
                            Product borttagen = produkter.remove(val - 1);
                            System.out.println("❌ Produkten \"" + borttagen.getName() + "\" togs bort.");
                        } else {
                            System.out.println("❗ Ogiltigt val.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❗ Ange ett giltigt nummer.");
                    }
                }

                case "0" -> {
                    kör = false;
                    System.out.println("👋 Tack för att du använde produktvisaren!");
                }

                default -> System.out.println("❗ Ogiltigt menyval. Försök igen.");
            }
        }

        scanner.close();
    }
}
