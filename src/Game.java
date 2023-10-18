import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will play the Game
 */
public class Game {
    private final Deck deck;
    private final Scanner input;
    private Player dealer;
    private ArrayList<Player> players;

    public Game(int players) {
        this.deck = new Deck();
        this.input = new Scanner(System.in);

        this.dealer = new Player("Dealer");

        this.players = new ArrayList<>();
        for (int p = 0; p < players; p++) {
            this.players.add(new Player("Player " + (p + 1)));
        }

    }

    /**
     * Main game loop
     */
    public void Play() {
        while (true) {
            startGame();
            if (initialDisplay()) {
                endGame();
            } else {
                for (Player player : this.players) {
                    playGame(player);
                }
                playDealer();
                endGame();
            }
            System.out.print("Play Again? (Yes/No) ");
            String again = input.nextLine();
            if (again.substring(0, 1).equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void playDealer() {
        while (true) {
            if (dealer.isBust() || dealer.getValue() > 16) {
                break;
            }
            dealer.addCard(deck.deal());
        }
    }

    private void playGame(Player player) {
        System.out.println();
        System.out.print(player.getName() + "'s turn");
        while (true) {
            displayPlayer(player);
            if (player.isBlackjack()) {
                System.out.println(player.getName() + "Has Blackjack");
            } else if (player.getValue() < 21 && !player.isBust()) {
                if (standHit()) {
                    break;
                }
                player.addCard(this.deck.deal());
            }
        }
    }

    private boolean standHit() {
        boolean returnvalue = false;
         System.out.println("Dealer has " + this.dealer.getCards().get(0).getValue() + " points");
        while (true) {
            System.out.print("Stand or Hit? ");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("hit")) {
                break;
            } else if (response.equalsIgnoreCase("stand")) {
                returnvalue = true;
                break;
            }
        }
        return returnvalue;
    }

    private void endGame() {
        if (!this.dealer.isBlackjack()) {
            displayPlayer(dealer);
            for (Player player : this.players) {
                if (player.isBust()) {
                    System.out.println(player.getName() + " has busted");
                } else {
                    
                    if (player.getValue() > dealer.getValue() || dealer.isBust()) {
                        System.out.print(player.getName() + " has won!!!!");
                    } else {
                        System.out.print(player.getName() + " has lost");
                    }
                }
                System.out.println(", with " +player.getValue() +" points");
            }
        }
    }

    private Boolean initialDisplay() {
        boolean returnValue = false;
        if (this.dealer.isBlackjack()) {
            System.out.println("Dealer has Blackjack, game over, you all lose.");
            returnValue = true;
        } else {
            System.out.println();
            System.out.println("Dealer has");
            System.out.print(this.dealer.getCards().get(0));
            System.out.println(this.dealer.getCardValue());
            for (Player player : this.players) {
                displayPlayer(player);
            }
        }
        return returnValue;
    }

    private void displayPlayer(Player player) {
        System.out.println();
        System.out.println(player.getName() + " has");
        for (Card card : player.getCards()) {
            System.out.print(card);
        }
        System.out.println(player.getCardValue());
    }

    private void startGame() {
        this.dealer.NewHand();
        for (Player player : this.players) {
            player.NewHand();
        }
        for (int x = 0; x < 2; x++) {
            this.dealer.addCard(deck.deal());
            for (Player player : this.players) {
                player.addCard(deck.deal());
            }
        }
    }
}
