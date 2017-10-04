import java.util.Random;

public class Deck {

	Card[] cards;
	int top;
	
	private Deck() {
		cards = new Card[52];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			suit= i/13;
			rank = 12 - (i - (suit * 13));
			cards[i] = new Card(suit, rank);
		}
		top = cards.length;
	}
	
	private Deck(Card[] given) {
		cards = given;
		top = cards.length;
	}
	
	private Deck(Boolean sorted) {
		cards = new Card[52];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			suit= i/13;
			rank = 12 - (i - (suit * 13));
			cards[i] = new Card(suit, rank);
		}
		if(!sorted) {
			int index;
		    Card temp;
		    Random random = new Random();
		    for (int i = cards.length - 1; i > 0; i--)
		    {
		        index = random.nextInt(i + 1);
		        temp = cards[index];
		        cards[index] = cards[i];
		        cards[i] = temp;
		    }
		}
		top = cards.length;
	}
	
	public String toString() {
		String words = "";
		if(cards.length == 52) {
			for(int i = 0; i < cards.length; i+=4 ) {
				words += String.format("%-18s %-18s %-18s %-18s\n", cards[i].toString(), cards[i + 1].toString(), cards[i + 2].toString(), cards[i + 3].toString());
			}
		}else{
			for(int i = 0; i < cards.length; i++ ) {
				System.out.println(cards[i].toString());
			}
		}
		return words;
	}
	
	private void shuffle(){
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
	
	private boolean equals(Deck d2){
		if(cards.length != d2.cards.length) {
			return false;
		}
		for(int i = 0; i < cards.length; i++ ) {
			if(cards[i] != d2.cards[i]) {
				return false;
			}
		}
		return true;
	}
	
	private void selectionSort(){
		
		 for (int i = 0; i < cards.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < cards.length; j++){  
	                if (cards[j].compareTo(cards[index])){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            Card smallerNumber = cards[index];   
	            cards[index] = cards[i];  
	            cards[i] = smallerNumber;  
	        }  
	}

	private void mergeSort(Card[] array) {
        if (array.length > 1) {
            // split array into two halves
            Card[] left = leftHalf(array);
            Card[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }
    
    private Card[] leftHalf(Card[] array) {
        int size1 = array.length / 2;
        Card[] left = new Card[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    private Card[] rightHalf(Card[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        Card[] right = new Card[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    private void merge(Card[] result, Card[] left, Card[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]))) {
                result[i] = left[i1];    // take from left
                i1++;
            }else{
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
    
	private Deck[] deal(int hands, int cardNum) {
		if(hands * cardNum > cards.length) {
			return null;
		}
		Deck[] hand= new Deck[hands];
		Card[] taken = new Card[cardNum];
		for(int i = 0; i < hand.length; i++) {
			for(int j = 0; j < cardNum; j++) {
				taken[j] = pick();
			}
			hand[i] = new Deck(taken);
			taken = new Card[cardNum];
		}

		return hand;
	}
	
    private Card pick() {
    	Card[] newCards = new Card[cards.length-1];
    	int t = (int)(Math.random() * (cards.length));
    	Card taken = cards[t];
    	cards[t] = null;
    	boolean s = true;
    	for(int i = 0; i < cards.length; i++) {
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
    	top = cards.length;
    	return taken;
    }
    
	public static void main(String[] args) {
		Deck myDeck = new Deck();

		
		System.out.println(myDeck.toString());
	}

}
