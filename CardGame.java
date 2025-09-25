//Xandra Quevedo and Brenda Romero
//9/23/25
//Card game with OOD

//package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	//Initialize empty array lists for a card deck and the player's cards -XQ
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();

	//main method
	public static void main(String[] args) {
		
		//A try-catch is used to read from the cards.txt file, to ensure
		//that an error is printed if the file does not exist -XQ
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}
		
		//The deck is initialized.
		//(New cards are made as long as the file card.txt still has text to read.) -XQ
		while(input.hasNext()) {
			//A String array "fields" is made, containing Scanner input from the file.
			//Split is used with the regular expression "," to grab the parts of the file
			//split at the commas. -XQ
			String[] fields = input.nextLine().split(",");

			//This creates a new card using the fields array, with the one int value using
			//parseInt to convert to an integer. Trim cuts out the whitespace. -XQ
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			//The new card is added to the deck. -XQ
			deckOfCards.add(newCard);
		}//end while

		//Calls a shuffle method to shuffle the deck. -XQ
		shuffle();

		//Uncommented this to exemplify the hearts and diamonds bug.
		for(Card c: deckOfCards) {
			System.out.println(c);
		}
			System.out.println();

		//deal the player 4 cards
		for(int i = 0; i < 4; i++) {
			//A card is removed from the deck and added to the player's cards. -XQ
			playerCards.add(deckOfCards.remove(i));
		}
		
		//The player's cards are printed. -XQ
		System.out.println("Player's cards:");
		//This is an enhanced for/for-each loop. For every Card c in playerCards,
		//Card c is printed. -XQ
		for(Card c: playerCards)
			System.out.println(c);

		//Prints out whether the player has a 2 of a kind.
		/*
			Edit by XQ on Sep 23, 3:11 PM:
		This print function felt a little improper, so I decided to 
		spruce it up a little by using a boolean variable set to
		the 2-kind method, and an if statement using it to print
		a distinct message for either case.
		*/
		//System.out.println("pairs is " + checkFor2Kind());
		boolean twoOfAKind = checkFor2Kind();
		if (twoOfAKind) {
			System.out.println("You have a pair.");
		}
		else {
			System.out.println("You do not have a pair.");
		}

	}//end main

	//Shuffle method
	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			/*
			The (int) phrase below converts the Math.random function
			to an int when it's normally double.
			Math.random returns a value between 0.0 and 1.0 (with 1.0 excluded).
			This is multiplied by the size of the deck, 52, 
			to get a random card index. -XQ
			*/
			int index = (int) (Math.random() * deckOfCards.size());

			//A new Card object, c, equals a now-removed Card.
			//(Note that the .remove method returns the removed card, which is why this works.) -XQ
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			//The removed card is added to the end of the ArrayList. -XQ
			deckOfCards.add(c);
		}//end for
	}//end shuffle
	

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {
		
		//A nested for loop is used to compare the current card to every other card
		//after it, and if any are equal, count increases.
		//Note that the for loop's range is limited to less than size - 1, 
		//ensuring no out of bounds access. -XQ
		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
