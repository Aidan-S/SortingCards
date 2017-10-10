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
	
	private static final int deckNum = 52;
	
	/**
	 * 
	 */
	private Deck() {
		makeCards();
		//keep track of top card
		top = cards.length;
	}
	
	/**
	 * 
	 * @param given when a card array is given, I made it for picking cards
	 */
	private Deck(Card[] given) {
		//equate the arrays
		cards = given;
		//keep track of top card
		top = cards.length;
	}
	
	/**
	 * 
	 * @param sorted whether the cards are to be sorted
	 */
	private Deck(Boolean sorted) {
		makeCards();
		//shuffle if wanted
		if(!sorted) {
			shuffle();
		}
		//keep track of top card
		top = cards.length;
	}
	
	private void makeCards() {
		cards = new Card[deckNum];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			//go 1 card at a time
			suit= i/13;
			rank = 12 - (i - (suit * 13));
			cards[i] = new Card(suit, rank);
		}
	}
	
	/**
	 * 
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
	 * @param d2 the second deck to be compared
	 * @return whether they are the same
	 */
	private boolean equals(Deck d2){
		//serves as a comparator that I made before making a comparator
		//compare lengths first so i can be safe to cheak line by line
		if(cards.length != d2.cards.length) {
			return false;
		}
		for(int i = 0; i < cards.length; i++ ) {
			//cheak line by line
			if(cards[i].compareTo(d2.cards[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 */
	private void selectionSort(){
		 //find the smallest card and then move to the front
		 for (int i = 0; i < cards.length - 1; i++){  
	        int index = i;  
	        for (int j = i + 1; j < cards.length; j++){  
	            //find the smallest
	            if (cards[j].compareTo(cards[index])){  
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
	 * @param array array to be merge sorted
	 */
	private void mergeSort(Card[] array) {
        if (array.length > 1) {
            // split array into two halves
            Card[] left = leftHalf(array);
            Card[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves
            merge(array, left, right);
        }
    }
	/**
	 * 
	 * @param array the left half of the array as an array
	 * @return left sorted
	 */
    private Card[] leftHalf(Card[] array) {
        int size1 = array.length / 2;
        //keep shrinking into smaller parts
        Card[] left = new Card[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    /**
     * 
     * @param array the right half of the array as an array
     * @return right sorted
     */
    private Card[] rightHalf(Card[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        //keep shrinking into smaller parts
        Card[] right = new Card[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    /**
     * 
     * @param result takes in the 2 halfs
     * @param left left half as an array
     * @param right right half as an array
     */
    private void merge(Card[] result, Card[] left, Card[] right) {
        //left index
    	int i1 = 0;  
        //right index
    	int i2 = 0;  
        
    	//combine the 2 halfs
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]))) {
                //take from left
            	result[i] = left[i1];   
                i1++;
            }else{
                //take from right
            	result[i] = right[i2];  
                i2++;
            }
        }
    }
    
    /**
     * 
     * @param hands number of hands to be dealt
     * @param cardNum number of cards in a single hand
     * @return array of Decks to be the different hands
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
	 * @return card that was removed from the deck
	 */
    private Card pick() {
    	//make array to replace cards
    	Card[] newCards = new Card[cards.length-1];
    	int t = (int)(Math.random() * (cards.length));
    	Card taken = cards[t];
    	cards[t] = null;
    	//make a card to hold picked card
    	boolean s = true;
    	for(int i = 0; i < cards.length; i++) {
    		//remake array without the selection/null
    		if(cards[i] != null) {
    			if(s) {
    				newCards[i] = cards[i];
    			}else {
    				newCards[i-1] = cards[i];
    			}
    		}else {
    			s = false;
    		}
    	}
    	cards = newCards;
    	//keep track of top card
    	top = cards.length;
    	return taken;
    }
    
    /**
     * 
     * @param fName file to be used as a print writer
     * @return printwriter
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
     * @param args test my stuffs
     */
	public static void main(String[] args) {
		PrintWriter out = outputFile("output.txt");
		//new shuffled deck
		Deck myDeck = new Deck(false);
		//sort it
		myDeck.mergeSort(myDeck.cards);
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
