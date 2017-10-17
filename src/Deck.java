import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author Aidan Scannell
 * @date: October 15, 2017
 *
 */
public class Deck {
	
	 //required fields 
	
	//array of my cards
	Card[] cards;
	//keep track of top card
	int top;
	
	//card array for merge sort
	Card[] temp;
	
	//number of cards in a default deck
	private static final int deckNum = 52;
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: fill array with cards in order
	 * @param args:none 
	 * @return: none
	 */
	private Deck() {
		//set all the cards in Card[] cards
		makeCards();
		//keep track of top card
		top();
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: fill array will given array
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
	 * @method: fill an array and shuffle it if sorted is false
	 * @param args: boolean sorted
	 * @return: none
	 */
	private Deck(Boolean sorted) {
		//set all the cards in Card[] cards
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
	 * @method: for the constructors, fill up array in order
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
			rank = (suit * 13) - i + 13;
			cards[i] = new Card(suit, rank);
		}
	}
	
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: String of cards in columns if there's 52 cards else just return all of them as string
 	 * @param args: words- all the cards as a string to be returned
	 * @return: the string to be printed
	 */
	public String toString() {
		//Convert object to string
		String words = "";
		if(top + 1 == deckNum) {
			for(int i = 0; i < deckNum; i+=4 ) {
				//add the lines in columns 
				words += String.format("%-18s %-18s %-18s %-18s\n", cards[i].toString(), cards[i + 1].toString(), cards[i + 2].toString(), cards[i + 3].toString());
			}
		}else{
			for(int i = 0; i < top + 1; i++ ) {
				//add 1 at a time if it isn't a perfect deck
				if(cards[i] != null) {	
					words += cards[i].toString();
					words += "\n";
				}
			}
		}
		return words;
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: shuffle the order of the cards
	 * @param args: index- index of random card, temp- temporary random card
	 * @return: none
	 */
	private void shuffle(){
	    //randomly mix up cards
		int index;
	    Card temp;
	    Random random = new Random();
	    for (int i = top - 1; i > 0; i--){
	        index = random.nextInt(i + 1);
	        //switch
	        temp = cards[index];
	        cards[index] = cards[i];
	        cards[i] = temp;
	    }
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: return whether or no the decks have the same cards
	 * @param args: d2- the other deck to be compared
	 * @return: boolean- if the decks are the same
	 */
	private boolean equals(Deck second){
		//serves as a comparator that I made before making a comparator
		//compare lengths first so i can be safe to check line by line
		if(top != second.top) {
			return false;
		}
		
		Deck d1 = new Deck(cards);
		Deck d2 = new Deck(second.cards);
		d1.selectionSort();
		d2.selectionSort();
		
		for(int i = 0; i < d1.cards.length; i++) {
			if(d1.cards[i].compareTo(d2.cards[i]) != 0) {
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: sort the cards by putting the smallest at the front and then shifting forward
	 * @param args: index- keep track of a needed placehold
	 * @return: none
	 */
	private void selectionSort(){
		 //find the smallest card and then move to the front
		 for (int i = 0; i < top - 1; i++){  
	        int index = i;  
	        for (int j = i + 1; j < top; j++){  
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
	 * @method: sort the deck 
	 * @param args: temp- temporary card array
	 * @return: none
	 */
	public void mergeSort () {
		int n = top;
		temp = new Card[n];
		recurse(cards , 0, n - 1);
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: recursive helper method for mergeSort
	 * @param args: deck- the deck of cards, from/to- where I'm looking at
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
	 * @method: merging helper method for mergeSort
	 * @param args: deck- the deck of cards, from/middle/to- what set of cards I'm looking at
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
		
		while (i <= middle && k != top) {
			temp[k] = deck[i];
			i++;
			k++;
		}
		
		while (j <= to && k != top) {
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
	 * @method: deal a certain number of hands of cards
	 * @param args:  hands- num of hands, cardNum- number of cards in a hand, taken- array of cards taken, hand- array of decks/hands
	 * @return: array of decks/hands
	 */
	private Deck[] deal(int hands, int cardNum) {
		//make sure its possible
		if(hands * cardNum > top) {
			return null;
		}
		Deck[] hand= new Deck[hands];
		Card[] taken = new Card[cardNum];
		//fill up each hand
		for(int i = 0; i < hands; i++) {
			for(int j = 0; j < cardNum; j++) {
				taken[j] = takeTop();	
			}
			hand[i] = new Deck(taken);
			taken = new Card[cardNum];
		}
		//return the hands
		return hand;
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: take card off top and shift the array
	 * @param args: r- card that was taken
	 * @return: the card that was taken
	 */
	private Card takeTop(){
		//make sure there are cards to take
		if(top > 0){
			Card r = cards[0];
		
			//take the top card and shift down
			for(int i = 0; i < cards.length; i++) {
				if(i + 1 < cards.length) {
					cards[i] = cards[i + 1];
				}else{
					cards[i] = null;
				}
			}
			top--;
			return r;
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: pick a random card
	 * @param args: taken- card removed
	 * @return: the card that was selected
	 */
    private Card pick() {
		//make sure there are cards to take
    	if(top > 0){	
    		int t = (int)(Math.random() * (cards.length - 1));
    		Card taken = cards[t];
    		cards[t] = null;
    		//take a random card and the fix the array
    		for(int i = t; i < cards.length; i++) {
    			if(i + 1 < cards.length) {
    				cards[i] = cards[i + 1];
    			}else{
    				cards[i] = null;
    			}
    		}
    		//keep track of top card
    		top();
    		return taken;
    	}else{
    		return null;
    	}	
    }
    
    /**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: create a print writer
	 * @param args: filename- name of file to be used, output- the print writer that is returned
	 * @return: print writer
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
	 * @method: set top card value
	 * @param args: top- top card
	 * @return: none
	 */
    private void top() {
    	//set top to the last non-null card's index
    	for(int i = 0; i < cards.length; i++) {
    		if(cards[i] != null) {
    			top = i;
    		}
    	}
    }
    
    /**
	 * 
	 * @user: Aidan-S
	 * @date: October 15, 2017
	 * @method: Test all of my methods
	 * @param args: myDeck- sample deck of cards, out- where I'm printing, second- second deck to compare to myDeck, hands- hands that are dealt
	 * @return: none
	 */
	public static void main(String[] args) {
		PrintWriter out = outputFile("output.txt");
		//new shuffled deck
		Deck myDeck = new Deck(false);
		//print deck to show shuffled
		out.println(myDeck.toString());
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
		Deck second = new Deck();
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
		//show effect of deal()
		out.println(myDeck.toString());
		
		//show that the shuffles can deal with null values
		myDeck.shuffle();
		myDeck.mergeSort();
		myDeck.shuffle();
		myDeck.selectionSort();
		out.println(myDeck.toString());
		
		//close up printer
		out.close();
	}

	

}
