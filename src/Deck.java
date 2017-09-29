public class Deck {

	Card[] cards;
	
	private Deck() {
		cards = new Card[52];
		int rank;
		int suit;
		for(int i = 0; i < cards.length; i++ ) {
			suit= i/13;
			rank= i/4;
			cards[i] = new Card();
		}
	}
	
	public String toString() {
		return "no";
	}
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		
	}

}
