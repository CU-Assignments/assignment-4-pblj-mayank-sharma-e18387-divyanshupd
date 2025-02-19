package Medium;


import java.util.*;

class CardCollection {
    private Map<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(cardName);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, Collections.emptyList());
    }

    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards in the collection.");
            return;
        }
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println("Symbol: " + entry.getKey() + " -> Cards: " + entry.getValue());
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection cardCollection = new CardCollection();

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Name: ");
                    String cardName = scanner.nextLine();
                    cardCollection.addCard(symbol, cardName);
                    System.out.println("Card added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Symbol to search: ");
                    symbol = scanner.nextLine();
                    List<String> cards = cardCollection.getCardsBySymbol(symbol);
                    if (cards.isEmpty()) {
                        System.out.println("No cards found for the given symbol.");
                    } else {
                        System.out.println("Cards with symbol " + symbol + ": " + cards);
                    }
                    break;
                case 3:
                    cardCollection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}