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
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		
		System.out.print(myDeck.toString());
	}

}
