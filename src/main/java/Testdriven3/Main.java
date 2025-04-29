package Testdriven3;

import java.util.*;

public class Main {

    public static int getCardValue(Card card) {
        return switch (card.getValue()) {
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> Integer.parseInt(card.getValue());
        };
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void showConfetti(String winnerName) {
        String[] symbols = {"✨", "🎉", "💥", "🌟", "🔥", "🎊"};
        Random random = new Random();

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("🎊 GRATTIS " + winnerName.toUpperCase() + " – DU VANN! 🎊");
        System.out.println("╚════════════════════════════════════╝");

        for (int i = 0; i < 5; i++) {
            StringBuilder line = new StringBuilder("  ");
            for (int j = 0; j < 30; j++) {
                line.append(symbols[random.nextInt(symbols.length)]);
            }
            System.out.println(line);
            pause(150);
        }

        System.out.println("🎉 Spelet är över – tack för att du spelade!");
    }

    public static String playGame(Scanner scanner) {
        String aiName = "Datorn";
        System.out.print("Vad heter du, modiga spelare? ");
        String player = scanner.nextLine();

        System.out.println("\nVälkommen, " + player + "! Du spelar mot " + aiName + ".");
        pause(1000);

        List<Card> deck = DeckGenerator.generateDeck();
        DeckGenerator.shuffleDeck(deck);

        int playerScore = 0;
        int aiScore = 0;
        List<Card> playerPlayedCards = new ArrayList<>();
        List<Card> aiPlayedCards = new ArrayList<>();
        int round = 1;

        while (deck.size() >= 6 && round <= 4) {
            System.out.println("\n--- Omgång " + round + " ---");
            System.out.println("Tryck [Enter] för att dra tre kort...");
            scanner.nextLine();

            // Spelaren drar 3 kort
            List<Card> playerHand = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                playerHand.add(DeckGenerator.drawCard(deck));
            }

            System.out.println("\nDina kort:");
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.println((i + 1) + ": " + playerHand.get(i));
            }

            int val = -1;
            while (val < 1 || val > 3) {
                System.out.print("Välj ett kort att spela (1-3): ");
                try {
                    val = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    val = -1;
                }
            }
            Card chosenCard = playerHand.get(val - 1);
            int playerVal = getCardValue(chosenCard);
            System.out.println(" Du spelade: " + chosenCard + " (+" + playerVal + ")");
            playerPlayedCards.add(chosenCard);
            playerScore += playerVal;

            pause(800);
            System.out.println("\n " + aiName + " funderar...");
            pause(1000);

            // AI drar 3 kort och väljer bästa
            List<Card> aiHand = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                aiHand.add(DeckGenerator.drawCard(deck));
            }

            Card aiCard = aiHand.get(0);
            for (Card c : aiHand) {
                if (getCardValue(c) > getCardValue(aiCard)) {
                    aiCard = c;
                }
            }

            int aiVal = getCardValue(aiCard);
            System.out.println(aiName + " spelade: " + aiCard + " (+" + aiVal + ")");
            aiPlayedCards.add(aiCard);
            aiScore += aiVal;

            pause(800);
            System.out.println("🔢 Ställning: " + player + " " + playerScore + " – " + aiName + " " + aiScore);
            round++;
        }

        pause(1000);
        System.out.println("\n--- DINA SPELADE KORT ---");
        playerPlayedCards.forEach(c -> System.out.println(c + " (" + getCardValue(c) + " poäng)"));

        System.out.println("\n--- " + aiName + "s SPELADE KORT ---");
        aiPlayedCards.forEach(c -> System.out.println(c + " (" + getCardValue(c) + " poäng)"));

        System.out.println("\n--- SLUTRESULTAT ---");
        System.out.println(player + ": " + playerScore + " poäng");
        System.out.println(aiName + ": " + aiScore + " poäng");

        if (playerScore > aiScore) {
            System.out.println("🎉 " + player + " vinner! Otroligt!");
            showConfetti(player);
            return "spelare";
        } else if (aiScore > playerScore) {
            System.out.println(" " + aiName + " vinner! Bättre lycka nästa gång.");
            showConfetti(aiName);
            return "dator";
        } else {
            System.out.println(" Det blev oavgjort! Dags för sudden death!");
            while (deck.size() >= 6) {
                System.out.println("\n--- Sudden Death ---");
                System.out.println("Tryck [Enter] för att dra tre kort...");
                scanner.nextLine();

                // Spelare
                List<Card> playerHand = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    playerHand.add(DeckGenerator.drawCard(deck));
                }

                System.out.println("Dina kort:");
                for (int i = 0; i < playerHand.size(); i++) {
                    System.out.println((i + 1) + ": " + playerHand.get(i));
                }

                int val = -1;
                while (val < 1 || val > 3) {
                    System.out.print("Välj ett kort att spela (1-3): ");
                    try {
                        val = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        val = -1;
                    }
                }
                Card playerCard = playerHand.get(val - 1);
                int playerVal = getCardValue(playerCard);
                System.out.println(" Du spelade: " + playerCard + " (+" + playerVal + ")");

                // AI
                pause(800);
                System.out.println("\n " + aiName + " funderar...");
                pause(1000);

                List<Card> aiHand = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    aiHand.add(DeckGenerator.drawCard(deck));
                }

                Card aiCard = aiHand.get(0);
                for (Card c : aiHand) {
                    if (getCardValue(c) > getCardValue(aiCard)) {
                        aiCard = c;
                    }
                }
                int aiVal = getCardValue(aiCard);
                System.out.println(aiName + " spelade: " + aiCard + " (+" + aiVal + ")");

                if (playerVal > aiVal) {
                    System.out.println("\n " + player + " vinner sudden death!");
                    showConfetti(player);
                    return "spelare";
                } else if (aiVal > playerVal) {
                    System.out.println("\n " + aiName + " vinner sudden death!");
                    showConfetti(aiName);
                    return "dator";
                } else {
                    System.out.println(" Oavgjort igen... drar nya kort!");
                }
            }

            System.out.println("\nKortleken tog slut! Ingen vann ");
            return "oavgjort";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int spelareVinster = 0;
        int aiVinster = 0;
        int oavgjorda = 0;
        boolean spelaIgen = true;

        while (spelaIgen) {
            String resultat = playGame(scanner);

            switch (resultat) {
                case "spelare" -> spelareVinster++;
                case "dator" -> aiVinster++;
                case "oavgjort" -> oavgjorda++;
            }

            System.out.println("\n📊 Statistik hittills:");
            System.out.println("🏆 Dina vinster:     " + spelareVinster);
            System.out.println("🤖 Datorns vinster:  " + aiVinster);
            System.out.println("➖ Oavgjorda:         " + oavgjorda);

            System.out.print("\nVill du spela igen? (j/n): ");
            String svar = scanner.nextLine().trim().toLowerCase();
            spelaIgen = svar.equals("j");
        }

        System.out.println("\nTack för att du spelade! ");
    }
}
