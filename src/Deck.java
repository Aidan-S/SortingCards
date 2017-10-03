import java.util.Random;

public class Deck {

	Card[] cards;
	
	private Deck() {
		cards = new Card[52];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			suit= i/13;
			rank = 12 - (i - (suit * 13));
			cards[i] = new Card(suit, rank);
		}
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
	}
	
	public String toString() {
		String words = "";
		for(int i = 0; i < cards.length; i+=4 ) {
			words += String.format("%-18s %-18s %-18s %-18s\n", cards[i].toString(), cards[i + 1].toString(), cards[i + 2].toString(), cards[i + 3].toString());
		}
		return words;
	}
	
	private void shuffle(){
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
	
	private static boolean equals(Deck d1, Deck d2){
		if(d1.cards.length != d2.cards.length) {
			return false;
		}
		for(int i = 0; i < d1.cards.length; i++ ) {
			if(d1.cards[i] != d2.cards[i]) {
				return false;
			}
		}
		return true;
	}
	
	private void SelectionSort(){
		
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
	
	private void MergeSort(){
		
		
	}
	
	private Deck[] Deal(int hands, int cardNum) {
		Deck[] hand= new Deck[hands];
		//Card picked = cards[];
		return hand;
	}
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		
		System.out.print(myDeck.toString());
		
		myDeck.shuffle();
		
		myDeck.SelectionSort();
		
		System.out.print(myDeck.toString());
	}

}
