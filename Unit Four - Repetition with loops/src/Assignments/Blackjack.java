package Assignments;

import java.util.Scanner;

public class Blackjack {

    static Scanner in = new Scanner(System.in);
    static final int MIN_BET = 5;
    static final int STARTING_WALLET = 500;
    private static final int WIN = 1;
    private static final int LOST = -1;
    private static final int TIE = 0;
    private static final int NUM_SUITS = 0;
    private static final String HEARTS = "H";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final int NUM_VALUES = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    

    public static void main(String[] args) {
        
        int wallet = STARTING_WALLET;
        boolean stillPlaying = true;

        while(stillPlaying){
        int bet = getBet(wallet);
        String playerHand = getCard() + " " + getCard();

        String dealerHand = getCard();

        displayHand(playerHand, false, "Player: ");
        displayHand(dealerHand, true, "Dealer: ");

        int result = playHand(playerHand, dealerHand);

        if (result == WIN)
            wallet += bet;
        else if (result == LOST)
            wallet -= bet;

        if (wallet < MIN_BET){
            stillPlaying = false;
            System.out.println("You are broke! Get a job to finance this addiciton!");
        }else 
            stillPlaying = playAgain();

        }
        
        
    }

    private static boolean playAgain() {
        return false;
    }

    //return WIN if player wins, LOST if player loses, and TIE if it is a tie.

    private static int playHand(String playerHand, String dealerHand) {
        return 0;
    }

    private static void displayHand(String cards, boolean isHidden, String label){
        String result = label;
        if (isHidden)
            result += label + "XX " + cards;
        else 
            result += label + cards;

        System.out.println(result );

    }

    private static String getCard() {
        return getValue() + getSuit();
    }

    private static String getSuit() {

        int iSuit = (int) (Math.random() * NUM_SUITS + 1);

        if (iSuit == 1)
            return HEARTS;
        else if (iSuit == 2)
            return SPADES;
        else if (iSuit == 3)
            return CLUBS;
        else
            return DIAMONDS;

        }

    private static String getValue() {
        int iValue = (int) (Math.random() * NUM_VALUES + 1);
        ;if (iValue == 1)
            return ACE;
        else if (iValue == 11)
            return JACK;
        else if (iValue == 12)
            return QUEEN;
        else if (iValue == 13)
            return KING;
        else
            return "" + iValue;
    }

    private static int getBet(int maxBet) {

        boolean validBet = false;
        int bet = 0;
        while(!validBet){
            System.out.print("Please enter a bet (MIN: $" + MIN_BET + "): ");
            try{
                bet = Integer.parseInt(in.nextLine());

                if (bet > maxBet)
                    System.out.print("Please enter a bet (MAX: $" + maxBet + "): ");
                else if(bet < MIN_BET)
                    System.out.println("Please enter a bet (MIN: $" + MIN_BET + "): ");
                else
                    validBet = true;
            }catch(NumberFormatException ex){
                System.out.println("Invalid Bet");
                
            }   
        }
        return bet; 
    }
    

 }

