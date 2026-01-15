import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Casino.");
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("What is your age? ");
        int age = readInt(input);

        Player player = new Player(name, age);
        Deck deck = new Deck();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Type: play, money, or quit");
            System.out.print("> ");
            String choice = input.nextLine();

            if (choice.equals("money")) {
                System.out.println("You have $" + player.getMoney());
            }

            else if (choice.equals("quit")) {
                System.out.println("Goodbye. You leave with $" + player.getMoney());
                running = false;
            }

            else if (choice.equals("play")) {

                if (player.getMoney() <= 0) {
                    System.out.println("You have no money left. Game over.");
                    running = false;
                }

                else {
                    int bet = getBet(input, player);

                    Hand playerHand = new Hand();
                    Hand dealerHand = new Hand();

                    System.out.println();
                    System.out.println("--- START ROUND ---");

                    Card pCard = deck.draw();
                    playerHand.add(pCard);
                    System.out.println(player.getName() + " draws: " + pCard);

                    Card dCard = deck.draw();
                    dealerHand.add(dCard);
                    System.out.println("Dealer draws: " + dCard);

                    System.out.println(player.getName() + " total: " + playerHand.getValue());
                    System.out.println("Dealer total: " + dealerHand.getValue());

                    boolean playerTurn = true;

                    while (playerTurn) {

                        if (playerHand.isBust()) {
                            playerTurn = false;
                        }

                        else {
                            System.out.print("Type hit or stand: ");
                            String move = input.nextLine();

                            if (move.equals("hit")) {
                                Card c = deck.draw();
                                playerHand.add(c);
                                System.out.println(player.getName() + " draws: " + c);
                            }

                            else if (move.equals("stand")) {
                                playerTurn = false;
                            }

                            else {
                                System.out.println("Please type hit or stand.");
                                continue;
                            }

                            System.out.println(player.getName() + " total: " + playerHand.getValue());
                            System.out.println("Dealer total: " + dealerHand.getValue());
                        }
                    }

                    if (!playerHand.isBust()) {

                        System.out.println();
                        System.out.println("--- DEALER TURN ---");

                        while (dealerHand.getValue() < 17) {
                            Card c = deck.draw();
                            dealerHand.add(c);
                            System.out.println("Dealer draws: " + c);
                            System.out.println("Dealer total: " + dealerHand.getValue());
                        }
                    }

                    System.out.println();
                    System.out.println("--- FINAL HANDS ---");
                    System.out.println(player.getName() + ": " + playerHand);
                    System.out.println("Dealer: " + dealerHand);

                    int p = playerHand.getValue();
                    int d = dealerHand.getValue();

                    if (playerHand.isBust()) {
                        System.out.println("You bust. You lose $" + bet);
                        player.lose(bet);
                    }
                    else if (dealerHand.isBust()) {
                        System.out.println("Dealer busts. You win $" + bet);
                        player.win(bet);
                    }
                    else if (p > d) {
                        System.out.println("You win $" + bet);
                        player.win(bet);
                    }
                    else if (p < d) {
                        System.out.println("You lose $" + bet);
                        player.lose(bet);
                    }
                    else {
                        System.out.println("Tie. You keep your bet.");
                    }

                    System.out.println("Money now: $" + player.getMoney());
                }
            }

            else {
                System.out.println("Unknown option.");
            }
        }

        input.close();
    }

    public static int getBet(Scanner input, Player player) {
        int bet = 0;
        boolean ok = false;

        while (!ok) {
            System.out.print("Enter bet: ");
            bet = readInt(input);

            if (player.canBet(bet)) {
                ok = true;
            } else {
                System.out.println("Invalid bet. You have $" + player.getMoney());
            }
        }
        return bet;
    }

    public static int readInt(Scanner input) {
        int value = 0;
        boolean ok = false;

        while (!ok) {
            String s = input.nextLine();
            try {
                value = Integer.parseInt(s);
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Enter a whole number: ");
            }
        }
        return value;
    }
}
