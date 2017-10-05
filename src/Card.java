import java.util.Comparator;

/**
 * 
 * @author Aidan
 *
 */
public class Card{
	
	private String Suit;
	private int Rank;
	
	/**
	 * 
	 */
	Card() {
		int suit = (int)(Math.random() * 3);
		switch(suit) {
        case 0 :
            Suit = "Clubs"; 
            break;
        case 1 :
        	Suit = "Diamonds";
            break;
        case 2 :
        	Suit = "Hearts";
            break;
        case 3 :
        	Suit = "Spades";
            break;
        default :
        	Suit = "ERROR";
		}
		Rank = (int)(Math.random() * 12);
	}
	
	/**
	 * 
	 * @param suitGiven
	 * @param rankGiven
	 */
	Card(int suitGiven, int rankGiven) {
		switch(suitGiven) {
        case 0 :
            Suit = "Clubs"; 
            break;
        case 1 :
        	Suit = "Diamonds";
            break;
        case 2 :
        	Suit = "Hearts";
            break;
        case 3 :
        	Suit = "Spades";
            break;
        default :
        	Suit = "ERROR";
     }
		Rank = rankGiven;
	}
	
	/**
	 * 
	 * @param suitGiven
	 * @param rankGiven
	 */
	private Card(String suitGiven, String rankGiven) {
		Suit = suitGiven;
		
		switch(rankGiven) {
        case "Ace" :
            Rank = 0; 
            break;
        case "Two" :
        	Rank = 1;
            break;
        case "Three" :
        	Rank = 2;
            break;
        case "Four" :
        	Rank = 3;
            break;
        case "Five" :
        	Rank = 4; 
            break;
        case "Six" :
        	Rank = 5;
            break;
        case "Seven" :
        	Rank = 6;
            break;
        case "Eight" :
        	Rank = 7;
            break;
        case "Nine" :
        	Rank = 8; 
            break;
        case "Ten" :
        	Rank = 9;
            break;
        case "Jack" :
        	Rank = 10;
            break;
        case "Queen" :
        	Rank = 11;
            break;
        case "King" :
        	Rank = 12;
            break;
        default :
        	Rank = -1;
     }
	}
	
	/**
	 * 
	 * @param suitGiven
	 * @param rankGiven
	 */
	private Card(String suitGiven, int rankGiven) {
        Suit = suitGiven;
		Rank = rankGiven;
	}
	
	/**
	 * 
	 * @param suitGiven
	 * @param rankGiven
	 */
	private Card(int suitGiven, String rankGiven) {
		switch(suitGiven) {
        case 0 :
           Suit = "Clubs"; 
           break;
        case 1 :
        	Suit = "Diamonds";
            break;
        case 2 :
        	Suit = "Hearts";
            break;
        case 3 :
        	Suit = "Spades";
            break;
        default :
        	Suit = "ERROR";
     }
		
		switch(rankGiven) {
        case "Ace" :
            Rank = 0; 
            break;
        case "Two" :
        	Rank= 1;
            break;
        case "Three" :
        	Rank = 2;
            break;
        case "Four" :
        	Rank = 3;
            break;
        case "Five" :
        	Rank = 4; 
            break;
        case "Six" :
        	Rank = 5;
             break;
        case "Seven" :
        	Rank = 6;
             break;
        case "Eight" :
        	Rank = 7;
             break;
        case "Nine" :
        	Rank = 8; 
             break;
        case "Ten" :
        	Rank = 9;
             break;
        case "Jack" :
        	Rank = 10;
             break;
        case "Queen" :
        	Rank = 11;
             break;
        case "King" :
        	Rank = 12;
             break;
        default :
        	Rank = -1;
     }
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSuit() {
		return Suit;
	}
	
	/**
	 * 
	 * @return
	 */
	private int getRank() {
		return Rank;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	boolean compareTo(Card b){
		
		if(getSuitInt() < b.getSuitInt()) {return true;}
		if(getSuitInt() > b.getSuitInt()) {return false;}
		if(Rank > b.getRank()) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private int getSuitInt() {
		if(Suit == "Clubs") {return 0;}else{
			if(Suit == "Diamonds") {return 1;}else{
				if(Suit == "Hearts") {return 2;}else{
					if(Suit == "Spades") {return 3;}else {
					return -1;	
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private String getRankString() {
		switch(Rank) {
		case 0 :
            return "Ace";
		case 1 :
            return "Two";
        case 2 :
            return "Three";
        case 3 :
            return "Four";
        case 4 :
            return "Five";
        case 5 :
            return "Six";
        case 6 :
            return "Seven";
        case 7 :
            return "Eight";
        case 8 :
            return "Nine";
        case 9 :
            return "Ten";
        case 10 :
            return "Jack";
        case 11 :
            return "Queen";
        case 12 :
            return "King";
        default :
        	return " ";
     }
	}
	
	/**
	 * 
	 */
	public String toString() {
		return (getRankString() + " of " + Suit);
	}
}
