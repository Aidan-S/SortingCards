import java.util.Comparator;

/**
 * 
 * @author Aidan Scannell
 * @date: October 15, 2017
 * 
 */
public class Card{
	
	private String suit;
	private int rank;
	
	private static final String ace = "Ace";
	private static final String two = "Two"; 
	private static final String three = "Three"; 
	private static final String four = "Four"; 
	private static final String five = "Five"; 
	private static final String six = "Six"; 
	private static final String seven = "Seven"; 
	private static final String eight = "Eight"; 
	private static final String nine = "Nine"; 
	private static final String ten = "Ten"; 
	private static final String jack = "Jack";
	private static final String queen = "Queen";
	private static final String king = "King";
	
	private static final String spades = "Spades";
	private static final String clubs = "Clubs";
	private static final String diamonds = "Diamonds";
	private static final String hearts = "Hearts";
	
	/**
	 * 
	 */
	public Card() {
		//assign random values
		int rSuit = (int)(Math.random() * 3);
		suit = numToSuit(rSuit);
		
		rank = (int)(Math.random() * 12);
	}
	
	/**
	 * 
	 * @param suitGiven int indicating the suit to be used
	 * @param rankGiven int indicating the rank to be used
	 */
	public Card(int suitGiven, int rankGiven) {
		//use switches to set rank and suit
		suit = numToSuit(suitGiven);
     
		rank = rankGiven - 1;
	}
	
	/**
	 * 
	 * @param suitGiven string indicating the suit to be used
	 * @param rankGiven string indicating the rank to be used
	 */
	public Card(String suitGiven, String rankGiven) {
		//use switches to set rank and suit
		suit = suitGiven;
		
		rank = stringToRank(rankGiven);
     
	}
	
	/**
	 * 
	 * @param suitGiven String indicating the suit to be used
	 * @param rankGiven int indicating the rank to be used
	 */
	public Card(String suitGiven, int rankGiven) {
		//set rank and suit
		suit = suitGiven;
		rank = rankGiven - 1;
	}
	
	/**
	 * 
	 * @param suitGiven int indicating the suit to be used
	 * @param rankGiven suit indicating the rank to be used
	 */
	public Card(int suitGiven, String rankGiven) {
		//use switches to set rank and suit
		suit = numToSuit(suitGiven);
		rank = stringToRank(rankGiven);
	
	}
	
	/**
	 * 
	 * @return the suit as a string
	 */
	public String getSuit() {
		//get the suit string
		return suit;
	}
	
	/**
	 * 
	 * @return the rank as an int
	 */
	public int getRank() {
		//get the rank int
		return rank;
	}
	

	/**
	 * 
	 * @return an int to indicate the cards suit
	 */
	public int getSuitInt() {
		//return suit as int
		return stringToNum(suit);
	}
	
	/**
	 * 
	 * @return a string to indicate the cards rank
	 */
	public String getRankString() {
		//return int as string
		return numToRank(rank);
     }
	

	/**
	 * 
	 * @param rankGiven
	 * @return
	 */
	private String numToRank(int rankGiven){
		//return int as string
		switch(rankGiven) {
		case 0 :
            return ace;
        case 1 :
			return two;
	    case 2 :
	        return three;
	    case 3 :
		    return four;
		case 4 :
		    return five;
		case 5 :
		    return six;
		case 6 :
		    return seven;
		case 7 :
			return eight;
        case 8 :
        	return nine;
		case 9 :
	        return ten;
        case 10 :
		    return jack;
		case 11 :
	        return queen;
        case 12 :
        	return king;
        default :
        	return " ";
		}
	}
	
	/**
	 * 
	 * @param rankGiven
	 * @return
	 */
	private int stringToRank(String rankGiven) {
		switch(rankGiven) {
        case ace :
            return 0;
        case two :
        	return 1;
        case three :
        	return 2;
        case four :
        	return 3;
        case five :
        	return 4;
        case six :
        	return 5;
        case seven :
        	return 6;
        case eight :
        	return 7;
        case nine :
        	return 8;
        case ten :
        	return 9;
        case jack :
        	return 10;
        case queen :
        	return 11;
        case king :
        	return 12;
        default :
        	return -1;
     }
	}
	
	/**
	 * 
	 * @param suitGiven
	 * @return
	 */
	private String numToSuit(int suitGiven) {
		//use switches to set rank and suit
				switch(suitGiven) {
		        case 0 :
		           return clubs; 
		        case 1 :
		        	return diamonds;
		        case 2 :
		        	return hearts;
		        case 3 :
		        	return spades;
		        default :
		        	return "ERROR";
				}
	}
	
	/**
	 * 
	 * @param suitgiven
	 * @return an int to represent a suit
	 */
	private int stringToNum(String suitgiven) {
		//return suit as int
				if(suitgiven == clubs) {return 0;}else{
					if(suitgiven == diamonds) {return 1;}else{
						if(suitgiven == hearts) {return 2;}else{
							if(suitgiven == spades) {return 3;}else {
							return -1;	
							}
						}
					}
				}
	}

	/**
	 * 
	 */
	public String toString() {
		//turn object into a string
		return (getRankString() + " of " + suit);
	}

	/**
	 * 
	 * @param b- the other card to be compared
	 * @return -1 if this.card is smaller, 1 if its bigger, or 0 if its the same as card b
	 */
	public int compareTo(Card b) {
		if(getSuitInt() < b.getSuitInt()) {return -1;}
		if(getSuitInt() > b.getSuitInt()) {return 1;}
		if(rank > b.getRank()) {
			return -1;
		}
		if(rank < b.getRank()) {
			return 1;
		}
		return 0;
	}	
}
