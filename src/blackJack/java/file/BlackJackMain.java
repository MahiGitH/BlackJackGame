package blackJack.java.file;
import java.io.PrintStream;
import java.util.Scanner;
public class BlackJackMain {
    public static void main(String[] args) {

            System.out.println("♠♥♣♦ Welcome to Blackjack!!!");
            Deck playingDeck = new Deck();
            Deck playerHand = new Deck();
            Deck dealerHand = new Deck();
            playingDeck.createFullDeck();
            playingDeck.shuffleDeck();
            double playerMoney = 500.0;
            Scanner userResponse = new Scanner(System.in);

            while(playerMoney > 0.0) {
                System.out.println("You have $" + playerMoney + ", How much would you like to bet?");
                double playerBet = userResponse.nextDouble();
                if (playerBet > playerMoney) {
                    System.out.println("Sorry, You don't have enough money, you are not allowed to bet");
                    break;
                }

                boolean endRound = false;
                playerHand.draw(playingDeck);
                playerHand.draw(playingDeck);
                dealerHand.draw(playingDeck);
                dealerHand.draw(playingDeck);

                PrintStream var10000;
                Card var10001;
                int userRes;
                do {
                    System.out.println("Your Hand");
                    System.out.println(playerHand.toString());
                    System.out.println("Your Hand Valued At: " + playerHand.cardValue());
                    System.out.println("Dealer Hand Value: " + dealerHand.getCard(0).toString() + " and [hidden]");
                    System.out.println("Would you like to (1)Hit or (2)Stand? ");
                    userRes = userResponse.nextInt();
                    if (userRes == 1) {
                        playerHand.draw(playingDeck);
                        var10000 = System.out;
                        var10001 = playerHand.getCard(playerHand.deckSize() - 1);
                        var10000.println("You Draw A: " + var10001.toString());
                        if (playerHand.cardValue() > 21) {
                            System.out.println("You BUST, Currently Valued At: " + playerHand.cardValue());
                            playerMoney -= playerBet;
                            endRound = true;
                            break;
                        }
                    }
                } while(userRes != 2);

                System.out.println("Dealer Cards: " + dealerHand.toString());
                if (dealerHand.cardValue() > playerHand.cardValue() && !endRound) {
                    System.out.println("Dealer Wins!");
                    playerMoney -= playerBet;
                    endRound = true;
                }

                while(dealerHand.cardValue() < 17 && !endRound) {
                    dealerHand.draw(playingDeck);
                    var10000 = System.out;
                    var10001 = dealerHand.getCard(dealerHand.deckSize() - 1);
                    var10000.println("Dealer Draws: " + var10001.toString());
                }

                System.out.println("Dealer's Hand is Valued At: " + dealerHand.cardValue());
                if (dealerHand.cardValue() > 21 && !endRound) {
                    System.out.println("Dealer BUST! You Win!");
                    playerMoney += playerBet;
                    endRound = true;
                }

                if (playerHand.cardValue() == dealerHand.cardValue() && !endRound) {
                    System.out.println("Push");
                    endRound = true;
                }

                if (playerHand.cardValue() > dealerHand.cardValue() && !endRound) {
                    System.out.println("You Win the Hand!");
                    playerMoney += playerBet;
                    endRound = true;
                }
                else if (endRound == false){
                    System.out.println("You lose the hand");
                    playerMoney -=playerBet;
                    endRound=true;
                }

                playerHand.moveAllToDeck(playingDeck);
                dealerHand.moveAllToDeck(playingDeck);
                System.out.println("End of Hand.");
            }

            System.out.println("Thanks for Playing; The Game is Over!!!");
        }
    }


