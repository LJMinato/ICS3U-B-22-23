//Was having trouble pushing to gitHub, so it may have submitted at like 12:02 AM.


/*Works for the most part, but updated scores and hands do not pass into the next turn, so no one can ever really win the game.
 * 
 * I also apologize for the sheer length, and it not even working. I had tried the new approach you showed me but I would have had to recode most of my original code, as it was all hardcoded
 * and used a ton of sysout's (as well as how I count score).
*/

package Assignments;

import java.util.Scanner;

public class GoFish {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final String DIAMONDS = "D";
    private static final String JACK = "J";
    private static final String ACE = "A";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int NUM_VALUES = 13;
    private static int PLAYER1_SCORE = 0;
    private static int PLAYER2_SCORE = 0;
    private static int PLAYER3_SCORE = 0;
    private static int PLAYER4_SCORE = 0;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
      
      boolean stillPlaying = true;


      //Creates the 4 different player hands (player1 is the human player).
      String player1Hand = getCard() + getCard() + getCard() + getCard() + getCard();
      String player2Hand = getCard() + getCard() + getCard() + getCard() + getCard();
      String player3Hand = getCard() + getCard() + getCard() + getCard() + getCard();
      String player4Hand = getCard() + getCard() + getCard() + getCard() + getCard();

      String newPlayer1Hand = minusPair(player1Hand, 1);
      String newPlayer2Hand = minusPair(player2Hand, 2);
      String newPlayer3Hand = minusPair(player3Hand, 3);
      String newPlayer4Hand = minusPair(player4Hand, 4);

      
      while (stillPlaying){

         System.out.println("Your turn! ");
         System.out.println(targetFish(1, newPlayer1Hand, newPlayer2Hand, newPlayer3Hand, newPlayer4Hand, PLAYER1_SCORE));
         String player2Turn = (targetFish(2, newPlayer2Hand, newPlayer1Hand, newPlayer3Hand, newPlayer4Hand, PLAYER2_SCORE));
         System.out.println(player2Turn);
         String player3Turn = (targetFish(3, newPlayer3Hand, newPlayer1Hand, newPlayer2Hand, newPlayer4Hand, PLAYER3_SCORE));
         System.out.println(player3Turn);
         String player4Turn = (targetFish(4, newPlayer4Hand, newPlayer1Hand, newPlayer2Hand, newPlayer3Hand, PLAYER4_SCORE));
         System.out.println(player4Turn);


         //Detects if any of the player's scores are 10 or above, it will print whoever has 10 or above as the winner.
         if ((PLAYER1_SCORE >= 10) || (PLAYER2_SCORE >= 10) || (PLAYER3_SCORE >= 10) || (PLAYER4_SCORE >= 10)){
            if (PLAYER1_SCORE >= 10){
               System.out.println("You win!");
            }

            if (PLAYER2_SCORE >= 10){
               System.out.println("Player 2 wins!");
            }

            if (PLAYER3_SCORE >= 10){
                  System.out.println("Player 3 wins!");
            }

            if (PLAYER4_SCORE >= 10){
               System.out.println("Player 4 wins!");
            }
            

            System.out.print("Would you like to play again? (Y)es or (N)o ");

            //Creates a variable for the player's input
            String playAgain = in.nextLine().toUpperCase();
            //If they say yes, it resets all of the player's hands.
            if (playAgain.equals("Y") || playAgain.equals("YES")){
               player1Hand = "" + getCard() + getCard() + getCard() + getCard() + getCard();
               player2Hand = "" + getCard() + getCard() + getCard() + getCard() + getCard();
               player3Hand = "" + getCard() + getCard() + getCard() + getCard() + getCard();
               player4Hand = "" + getCard() + getCard() + getCard() + getCard() + getCard();

               newPlayer1Hand = minusPair(player1Hand, 1);
               newPlayer2Hand = minusPair(player2Hand, 2);
               newPlayer3Hand = minusPair(player3Hand, 3);
               newPlayer4Hand = minusPair(player4Hand, 4);

               System.out.println("NEW GAME");
               System.out.println("................................................");

               stillPlaying = true;
            }
            //If they say no, it will say "thank you for playing", and stop asking for player's inputs.
            else if(playAgain.equals("N") || playAgain.equals("NO")){
               System.out.println("Thank you for playing! ");

               stillPlaying = false;
            }

            

   
         }
      }

      


   }
    //Asks the player which opponent they want to take from, as well as the card they want. Depending on the player number, it will automatically execute for the non - human players.
      private static String targetFish(int player, String currentHand, String opponent1Hand, String opponent2Hand, String opponent3Hand, int score){
         String result = "";

            String validInputs = "2345678910JQKA";

            int playerSelect = 0;

            String selectedCard = "";

            String fish = "";

            boolean validFisher = false;

            boolean validCard = false;


         //NOTE: The reason my code is so incredibly long is that I have to check what the player is, and then check the input of the player, and accordingly print their new hand and score.
         if (player == 1){

         
            //This while loop checks if the player's input is valid.
            while(!validFisher){
               System.out.println("Which player would you like to take a card from? Please type 2 (player 2), 3 (player 3), or 4 (player 4)");
               System.out.print("Your hand is: ");
               System.out.println(currentHand);

               fish += in.nextLine();
               
               if ((fish.equals("2")) || (fish.equals("3")) || (fish.equals("4")))
                  validFisher = true;
                  
               else{
                  fish = "";
                  System.out.println("Please type a valid response. ");
               }
            }

            if (fish.equals("2")){

               while (!validCard){

                  System.out.println("Which card would you like to take from player 2? (input the number or face card value)");

                  selectedCard = in.nextLine().toUpperCase();

                  if(((currentHand.indexOf(selectedCard)) == -1) && !(validInputs.contains(selectedCard))){
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }

                  //If there is no match, add another card to the player's hand as the "Go fish".
                  else if (((opponent1Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                     currentHand = getCard() + " " + currentHand;

                     //Prints go fish, and all the players' new hand.
                     System.out.println("GO FISH!");
                     System.out.println();

                     System.out.print("Your hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent1Hand);
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);
                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.println("Next turn.........................");

                     validCard = true;
                     
                  }

                  else if (opponent1Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                     if (opponent1Hand.contains(selectedCard)){
                        score++;
                     }

                     //The reason you'll see a lot of (currentHand.length() - 14) is because the hand displays as the hand as well as the score, so I have to isolate just the hand if I want to edit it.
                     currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);

                     currentHand = minusPair(currentHand, 1);

                     currentHand = currentHand.substring(0, currentHand.length()) + score;

                     opponent1Hand = selectedCard + getSuit() + opponent1Hand.substring(0, opponent1Hand.length()-14);

                     opponent1Hand = minusPair(opponent1Hand, 2);

                     if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
                     //This will check for pairs in the new hand, so if I get another pair with my hand having one card, 
                     //it will generate a new 5 card hand, search for pairs, take them out, and display the new hand and score.
                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 1);
         
                     System.out.print("Your hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent1Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.println("Next turn.........................");

                     validCard = true;
                  }

                  else {
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }


                  

   
               }
            }

            if (fish.equals("3")){

               while (!validCard){

                  System.out.println("Which card would you like to take from player 3? (input the number or face card value)");

                  selectedCard = in.nextLine().toUpperCase();

                  if(((currentHand.indexOf(selectedCard)) == -1) && !(validInputs.contains(selectedCard))){
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }

                  else if (((opponent2Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                     currentHand = getCard() + " " + currentHand;

                     System.out.println("GO FISH!");
                     System.out.print("Your hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent1Hand);
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);
                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);


                     System.out.println("Next turn.........................");

                     validCard = true;
                     
                  }

                  else if (opponent2Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                     if (opponent2Hand.contains(selectedCard)){
                        score++;
                     }

                     currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);

                     currentHand = minusPair(currentHand, 1);

                     currentHand = currentHand.substring(0, currentHand.length()) + score;

                     opponent2Hand = selectedCard + getSuit() + opponent2Hand.substring(0, opponent2Hand.length()-14);

                     opponent2Hand = minusPair(opponent2Hand, 3);

                     if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 1);
         
                        System.out.print("Your hand is: ");
                        System.out.println(currentHand);
   
                        System.out.print("Player 2's hand is: ");
                        System.out.println(opponent1Hand);
                        
                        System.out.print("Player 3's hand is: ");
                        System.out.println(opponent2Hand);
   
                        System.out.print("Player 4's hand is: ");
                        System.out.println(opponent3Hand);

                        System.out.println("Next turn.........................");

                     validCard = true;
                  }

                  else {
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }


                  

   
               }
            }

            if (fish.equals("4")){

               while (!validCard){

                  System.out.println("Which card would you like to take from player 4? (input the number or face card value)");

                  selectedCard = in.nextLine().toUpperCase();

                  if(((currentHand.indexOf(selectedCard)) == -1) && !(validInputs.contains(selectedCard))){
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }

                  else if (((opponent3Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                     currentHand = getCard() + " " + currentHand;

                     

                     System.out.println("GO FISH!");
                     System.out.print("Your hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent1Hand);
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);
                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);


                     System.out.println("Next turn.........................");

                     validCard = true;
                     
                  }

                  else if (opponent3Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                     if (opponent3Hand.contains(selectedCard)){
                        score++;
                     }

                     currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);

                     currentHand = minusPair(currentHand, 1);

                     currentHand = currentHand.substring(0, currentHand.length()) + score;

                     opponent3Hand = selectedCard + getSuit() + opponent3Hand.substring(0, opponent3Hand.length()-14);

                     opponent3Hand = minusPair(opponent3Hand, 4);

                     if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 1);
         
                        System.out.print("Your hand is: ");
                        System.out.println(currentHand);
   
                        System.out.print("Player 2's hand is: ");
                        System.out.println(opponent1Hand);
                        
                        System.out.print("Player 3's hand is: ");
                        System.out.println(opponent2Hand);
   
                        System.out.print("Player 4's hand is: ");
                        System.out.println(opponent3Hand);

                        System.out.println("Next turn.........................");

                     validCard = true;
                  }

                  else {
                     selectedCard = "";
                     System.out.println("Please type a valid response. ");
                  }


                  

   
               }
            }
         }

         //Looks for matches as a computer. I do not need to add a valid input while loop, because the computer can only select a number from 2 - 4.
         //Basically the same as if the player == 1, but I just remove asking the computer for players and cards. It automatically gets randomly assigned.
         //The following if statements (if player == x) are all the same, but just with the player numbers adjusted for each computer player.
         if (player == 2){

            //Selects a random player to choose a card from.
            playerSelect = (int) (Math.random() * 4) + 2;
            String selectString = playerSelect + "";
            fish = selectString;

            if (fish.equals("-1"));
               fish = "2";

            if (fish.equals("2")){

               while(!validCard){

                  //Chooses a random card from the selected player's deck.
                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }


               //If there is a match, add one to the computer player's score, and take away the cards from this player and the selected player's deck.
               if (opponent1Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent1Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 2);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent1Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent1Hand.substring(0, opponent1Hand.length()-14);
   
                  opponent1Hand = minusPair(opponent1Hand, 1);


                  //Prints off the hands, currentHand being for whatever the variable player is equal to.
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 2);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);



                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               //Will print if the computer gets a Go fish.
               else if (((opponent1Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;

                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("3")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if (opponent2Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent2Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 2);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent2Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent2Hand.substring(0, opponent2Hand.length()-14);
   
                  opponent2Hand = minusPair(opponent2Hand, 3);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 2);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent2Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                  System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("4")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if ((opponent3Hand.length() - 14) < 4 || (opponent3Hand.length()-14) < 4){
                     
                  if (opponent3Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 2);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent3Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent3Hand.substring(0, opponent3Hand.length()-14);
   
                  opponent3Hand = minusPair(opponent3Hand, 4);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 2);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent3Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(currentHand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent2Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }          

   
               }
      if (player == 3){

            playerSelect = (int) (Math.random() * 4) + 2;
            String selectString = playerSelect + "";
            fish = selectString;

            if (fish.equals("-1"));
               fish = "2";

            if (fish.equals("2")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if (opponent1Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent1Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent1Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent1Hand.substring(0, opponent1Hand.length()-14);
   
                  opponent1Hand = minusPair(opponent1Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent1Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("3")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if (opponent2Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent2Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent2Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent2Hand.substring(0, opponent2Hand.length()-14);
   
                  opponent2Hand = minusPair(opponent2Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent2Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;

                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("4")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if ((opponent3Hand.length() - 14) < 4 || (opponent3Hand.length()-14) < 4){
                     
                  if (opponent3Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent3Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent3Hand.substring(0, opponent3Hand.length()-14);
   
                  opponent3Hand = minusPair(opponent3Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent3Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(currentHand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(opponent3Hand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }          

   
               }

      if (player == 4){

            playerSelect = (int) (Math.random() * 4) + 2;
            String selectString = playerSelect + "";
            fish = selectString;

            if (fish.equals("-1"));
               fish = "2";

            if (fish.equals("2")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if (opponent1Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent1Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent1Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent1Hand.substring(0, opponent1Hand.length()-14);
   
                  opponent1Hand = minusPair(opponent1Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent1Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("3")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if (opponent2Hand.indexOf(selectedCard) >= 0 && (currentHand.contains(selectedCard))){
                     
                  if (opponent2Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent2Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent2Hand.substring(0, opponent2Hand.length()-14);
   
                  opponent2Hand = minusPair(opponent2Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent2Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }

            if (fish.equals("4")){

               while(!validCard){

                  int randomCard = (int) (Math.random()*(currentHand.length()-14));
      
                  if(randomCard%3==0){
                      selectedCard = currentHand.charAt(randomCard)+"";
                     validCard = true;
                  }

                  else
                     validCard = false;
      
               }

               if ((opponent3Hand.length() - 14) < 4 || (opponent3Hand.length()-14) < 4){
                     
                  if (opponent3Hand.contains(selectedCard)){
                     score++;
                  }
   
                  currentHand = selectedCard + getSuit() + " " + currentHand.substring(0, currentHand.length() - 14);
   
                  currentHand = minusPair(currentHand, 1);
   
                  currentHand = currentHand.substring(0, currentHand.length()) + score;
   
                  opponent3Hand = selectedCard + getSuit() + selectedCard + getSuit() + opponent3Hand.substring(0, opponent3Hand.length()-14);
   
                  opponent3Hand = minusPair(opponent3Hand, 2);
   
                  if ((currentHand.length() - 14) < 4 || (currentHand.length()-14) < 4)
                     currentHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();

                     currentHand = minusPair(currentHand.substring(0, currentHand.length() - 14), 3);
      
                     System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
               }

               else if (((opponent3Hand.indexOf(selectedCard)) == -1) && (validInputs.contains(selectedCard))){
                  currentHand = getCard() + " " + currentHand;
                  
                  System.out.print("Your hand is: ");
                     System.out.println(opponent1Hand);

                     System.out.print("Player 2's hand is: ");
                     System.out.println(opponent2Hand);
                     
                     System.out.print("Player 3's hand is: ");
                     System.out.println(opponent3Hand);

                     System.out.print("Player 4's hand is: ");
                     System.out.println(currentHand);
   
                     System.out.println("Next turn.........................");
   
                  validCard = true;
                        
               }
            }          

   
               }
      
            return "";
            }

   //Will take away pairs and increase score depending on the number of pairs.
   public static String minusPair(String hand, int player) {

      hand = hand.replace(" ", "");

      String newPlayer1Hand = " ";

      int handScore = 0;

        String keepCards = "";

        String Triplets = "";

        for (int i = 0; i < hand.length() / 2; i++) {
            boolean foundPair = false;
            for (int j = 0; j < hand.length() / 2; j++) {

               //Finds 10s, replaces them with "t" so that it doesn't mess up any iteration.
               hand = hand.replace("10", "t");
               

               if (i != j && hand.charAt(2 * i) == hand.charAt(2 * j)) {
                  foundPair = true;
                  break;
               }

            }

            //if it is not a pair, the card will be added to keepCards
            if (!foundPair) {
                keepCards += hand.substring(2 * i, 2 * i + 2) + " ";
            }

            //will edit the hand accordingly if there are 3 cards, so it only removes 2 of them.
            else{
                Triplets = hand.substring(2 * i, 2 * i + 2) + " ";
            }
        }

      //Checks score based on the length of the hand without the matched pairs.
      if (keepCards.length() == 9)
         handScore = 1;
      if (keepCards.length() == 3)
         handScore = 2;
      if (keepCards.length() == 15)
         handScore = 0;

         //the total score is the hand scores added after each turn, and display score is the same as total score, but is different for each player.
         int totalScore = 0;
         int displayScore = 0;
         totalScore = totalScore + handScore;

         //Detects if there is an error with the removal of cards, so that if it removes the wrong number of cards, keepCards adds one of the triplet numbers.
        if((keepCards.length() == 4) || (keepCards.length() == 0)){
         keepCards += Triplets;
         }

         //Turns the "t"s back into 10s
         keepCards = keepCards.replace("t", "10");

        //displays the new edited hand as well as the score
         if (player == 1){
            PLAYER1_SCORE = totalScore;
            displayScore = PLAYER1_SCORE;
            newPlayer1Hand = keepCards;
            return (newPlayer1Hand) + "-- Score is: " + displayScore;
         }
         if (player == 2){
            PLAYER2_SCORE = PLAYER2_SCORE + totalScore;
            displayScore = PLAYER2_SCORE;
            String newPlayer2Hand = keepCards;
            return (newPlayer2Hand) + "-- Score is: " + displayScore;
         }
         if (player == 3){
            PLAYER3_SCORE = PLAYER3_SCORE + totalScore;
            displayScore = PLAYER3_SCORE;
            String newPlayer3Hand = keepCards;
            return (newPlayer3Hand) + "-- Score is: " + displayScore;
         }
         if (player == 4){ 
            PLAYER4_SCORE = PLAYER4_SCORE + totalScore;
            displayScore = PLAYER4_SCORE;
            String newPlayer4Hand = keepCards;
            return (newPlayer4Hand) + "-- Score is: " + displayScore;
         }

        return "";
    }

    

    //Replaces the opponent's card with an "XX ".
    private static void displayHand(String cards, boolean isHidden, String label) {
        String result = label;
      if (isHidden){
         for(int i = 0; i < cards.length() / 3; i++);{
            result += "XX ";
         }
      }
      else{
         result += cards;
      }
      System.out.println(result);
   }

      //Creates a card with a number/face value and a suit.
    private static String getCard(){
        return getValue()+getSuit();
    }
    //Generates a suit
    private static String getSuit() {
        int iSuit = (int) (Math.random() * NUM_SUITS) + 1;
        if (iSuit == 1)
           return HEARTS;
        else if (iSuit == 2)
           return SPADES;
        else if (iSuit == 3)
           return CLUBS;
        else
           return DIAMONDS;
    }

   //Generates a value
    private static String getValue() {
        int iValue = (int) (Math.random() * NUM_VALUES) + 1;
        if (iValue == 1)
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
}
