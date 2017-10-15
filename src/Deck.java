import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author Aidan
 *
 */
public class Deck {
	
	 //required fields 
	
	//array of my cards
	Card[] cards;
	//keep track of top card
	int top;
	
	Card[] temp;
	
	private static final int deckNum = 52;
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: fill array with cards in order
	 * @param args:none 
	 * @return: none
	 */
	private Deck() {
		makeCards();
		//keep track of top card
		top();
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: fill array will given array
	 * @param args: Card array given
	 * @return: none
	 */
	private Deck(Card[] given) {
		//equate the arrays
		cards = given;
		//keep track of top card
		top();
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: fill an array and shuffle it if sorted is false
	 * @param args: boolean sorted
	 * @return: none
	 */
	private Deck(Boolean sorted) {
		makeCards();
		//shuffle if wanted
		if(!sorted) {
			shuffle();
		}
		//keep track of top card
		top();
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: for the constructors, fill up array in order
	 * @param args: rank- rank for card, suit- suit for card
	 * @return: none
	 */
	private void makeCards() {
		//create an array and fill it
		cards = new Card[deckNum];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			//go 1 card at a time
			suit= i/13;
			//multiply suit by i to get the section of cards to look at
			//then subtract i and add 13 to get to rank
			rank = 13 - (i - (suit * 13));
			cards[i] = new Card(suit, rank);
		}
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: String of cards in columns if there's 52 cards else just return all of them as string
 	 * @param args: words- all the cards as a string to be returned
	 * @return: the string to be printed
	 */
	public String toString() {
		//Convert object to string
		String words = "";
		if(cards.length == deckNum) {
			for(int i = 0; i < cards.length; i+=4 ) {
				//add the lines in columns 
				words += String.format("%-18s %-18s %-18s %-18s\n", cards[i].toString(), cards[i + 1].toString(), cards[i + 2].toString(), cards[i + 3].toString());
			}
		}else{
			for(int i = 0; i < cards.length; i++ ) {
				//add 1 at a time if it isn't a perfect deck
				words += cards[i].toString();
				words += "\n";
			}
		}
		return words;
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: index- index of random card, temp- temporary random card
	 * @return: none
	 */
	private void shuffle(){
	    //randomly mix up cards
		int index;
	    Card temp;
	    Random random = new Random();
	    for (int i = cards.length - 1; i > 0; i--){
	        index = random.nextInt(i + 1);
	        temp = cards[index];
	        cards[index] = cards[i];
	        cards[i] = temp;
	    }
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: return whether or no the decks have the same cards
	 * @param args: d2- the other deck to be compared
	 * @return: boolean- if the decks are the same
	 */
	private boolean equals(Deck d2){
		//serves as a comparator that I made before making a comparator
		//compare lengths first so i can be safe to check line by line
		if(cards.length != d2.cards.length) {
			return false;
		}
		for(int i = 0; i < cards.length; i++ ) {
			//cheak line by line
			if(cards[i].compareTo(d2.cards[i]) == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: sort the cards by putting the smallest at the front and then shifting forward
	 * @param args: index- keep track of a needed placehold
	 * @return: none
	 */
	private void selectionSort(){
		 //find the smallest card and then move to the front
		 for (int i = 0; i < cards.length - 1; i++){  
	        int index = i;  
	        for (int j = i + 1; j < cards.length; j++){  
	            //find the smallest
	            if (cards[j].compareTo(cards[index]) == -1){  
	                index = j; 
	            }  
	        }  
	        Card smallerNumber = cards[index];   
	        cards[index] = cards[i];  
	        cards[i] = smallerNumber;  
	     }  
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: sort the deck 
	 * @param args: temp- temporary card array
	 * @return: none
	 */
	public void mergeSort () {
		int n = cards.length;
		temp = new Card[n];
		recurse(cards , 0, n - 1);
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: recursive helper method for mergeSort
	 * @param args: 
	 * @return: none
	 */
	private void recurse (Card[] deck, int from, int to) {	
		if (to - from < 2) {
			if (to > from && deck[to].compareTo(deck[from]) == -1) {
				Card cardTemp = deck[to];
				deck[to] = deck[from];
				deck[from] = cardTemp;
			}		
		}else{
			int middle = (from + to) / 2;
			recurse(deck, from, middle);
			recurse(deck, middle + 1, to);
			merge(deck, from, middle, to);
		}
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: merging helper method for mergeSort
	 * @param args: 
	 * @return: none
	 */
	private void merge (Card[] deck, int from, int middle, int to) {
		int i = from;
		int j = middle + 1;
		int k = from;
		
		while (i <= middle && j <=to) {
			if ((deck[i].compareTo(deck[j]) == -1)) {
				temp[k] = deck[i];
				i++;
			}else{
				temp[k] = deck[j];
				j++;
			}
			k++;		
		}
		
		while (i <= middle && k != deckNum) {
			temp[k] = deck[i];
			i++;
			k++;
		}
		
		while (j <= to && k != deckNum) {
			temp[k] = deck[j];
			j++;
			k++;
		}
		
		for (k = from; k <= to; k++) {
			deck[k] = temp[k];
		}
		
		this.cards = deck;
	}
	
	
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: 
	 * @return: 
	 */
	private Deck[] deal(int hands, int cardNum) {
		//make sure its possible
		if(hands * cardNum > cards.length) {
			return null;
		}
		Deck[] hand= new Deck[hands];
		Card[] taken = new Card[cardNum];
		//fill in each hand with random cards using pick method
		for(int i = 0; i < hand.length; i++) {
			for(int j = 0; j < cardNum; j++) {
				taken[j] = pick();
			}
			hand[i] = new Deck(taken);
			taken = new Card[cardNum];
		}
		return hand;
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: 
	 * @return: 
	 */
    private Card pick() {
    	int t = (int)(Math.random() * (cards.length - 1));
    	Card taken = cards[t];
    	cards[t] = null;
    	//make a card to hold picked card
    	boolean s = true;
    	for(int i = 0; i < cards.length; i++) {
    		if(cards[i] == null) {
    			if(i - 1 == cards.length) {
    				cards[i] = null;
    			}else {
    				cards[i] = cards[i + 1];
    			}
    		}
    	}
    	//keep track of top card
    	top();
    	return taken;
    }
    
    /**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: 
	 * @return: 
	 */
    private static PrintWriter outputFile(String fName) {
    	//make a printwriter with the given file but if there's an issue return null instead	
    	File fileName = new File(fName);
   		PrintWriter output = null;
  		try {
   			output = new PrintWriter(fileName);
  		} catch (FileNotFoundException ex) {
  			System.out.print("Cannot open " + fName);
   			return null;
  		}
 		return output;
	}
    
    /**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: 
	 * @return: 
	 */
    private void top() {
    	for(int i = cards.length - 1; i >= 0; i++) {
    		if(cards[i] != null) {
    			top = i;
    			break;
    		}
    	}
    }
    
    /**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @ method: 
	 * @param args: 
	 * @return: 
	 */
	public static void main(String[] args) {
		PrintWriter out = outputFile("output.txt");
		//new shuffled deck
		Deck myDeck = new Deck(true);
		//sort it
		myDeck.mergeSort();
		//print it
		out.println(myDeck.toString());
		//shuffle again
		myDeck.shuffle();
		//sort with new sort
		myDeck.selectionSort();
		//print again
		out.println(myDeck.toString());
		//new deck to compare
		Deck second = new Deck(true);
		//compare and print results
		if(myDeck.equals(second)) {
			out.println("The 2 decks are the same");
		}else{
			out.println("The 2 Decks are different");
		}
		//print out hands dealt
		Deck[] hands = myDeck.deal(3, 6);
		for(int i = 0; i < hands.length; i++) {
			out.println(hands[i].toString());
			out.println("\n");
		}
		out.println("Finished");
		//close up printer
		out.close();
	}

	

}
