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
	
	public String toString() {
		String words = "";
		for(int i = 0; i < cards.length; i++ ) {
			words = words + cards[i].toString() + "\n";
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
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		Deck second = new Deck();
		if(equals(myDeck, second)) {
			System.out.println("They're the same");
		}else{
			System.out.println("They're different");
		}
		myDeck.shuffle();
		if(equals(myDeck, second)) {
			System.out.println("They're the same");
		}else{
			System.out.println("They're different");
		}
		System.out.print(myDeck.toString());
	}

}
