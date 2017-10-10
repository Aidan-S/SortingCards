import java.util.Comparator;

/**
 * 
 * @author Aidan : he did this code stuffs
 *
 */
public class Card{
	
	private String Suit;
	private int Rank;
	
	/**
	 * 
	 */
	public Card() {
		//assign random values
		int suit = (int)(Math.random() * 3);
		Suit = numToSuit(suit);
		
		Rank = (int)(Math.random() * 12);
	}
	
	/**
	 * 
	 * @param suitGiven int indicating the suit to be used
	 * @param rankGiven int indicating the rank to be used
	 */
	public Card(int suitGiven, int rankGiven) {
		//use switches to set rank and suit
		Suit = numToSuit(suitGiven);
     
		Rank = rankGiven;
	}
	
	/**
	 * 
	 * @param suitGiven string indicating the suit to be used
	 * @param rankGiven string indicating the rank to be used
	 */
	private Card(String suitGiven, String rankGiven) {
		//use switches to set rank and suit
		Suit = suitGiven;
		
		Rank = stringToRank(rankGiven);
     
	}
	
	/**
	 * 
	 * @param suitGiven String indicating the suit to be used
	 * @param rankGiven int indicating the rank to be used
	 */
	private Card(String suitGiven, int rankGiven) {
		//set rank and suit
		Suit = suitGiven;
		Rank = rankGiven;
	}
	
	/**
	 * 
	 * @param suitGiven int indicating the suit to be used
	 * @param rankGiven suit indicating the rank to be used
	 */
	private Card(int suitGiven, String rankGiven) {
		//use switches to set rank and suit
		Suit = numToSuit(suitGiven);
		Rank = stringToRank(rankGiven);
	
	}
	
	/**
	 * 
	 * @return the suit as a string
	 */
	private String getSuit() {
		//get the suit string
		return Suit;
	}
	
	/**
	 * 
	 * @return the rank as an int
	 */
	public int getRank() {
		//get the rank int
		return Rank;
	}
	
	/**
	 * 
	 * @param b the card that is being compared
	 * @return whether the cards are the same
	 */
	public boolean compareTo(Card b){
		//return true if the card is supposed to be higher in the deck
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
	 * @return an int to indicate the cards suit
	 */
	private int getSuitInt() {
		//return suit as int
		return stringToNum(Suit);
	}
	
	/**
	 * 
	 * @return a string to indicate the cards rank
	 */
	private String getRankString() {
		//return int as string
		return numToRank(Rank);
     }
	

//----------------------------------------------------------------------------------------------------------------------------
	private String numToRank(int Rank){
		//return int as string
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
	
	private int stringToRank(String rankGiven) {
		switch(rankGiven) {
        case "Ace" :
            return 0;
        case "Two" :
        	return 1;
        case "Three" :
        	return 2;
        case "Four" :
        	return 3;
        case "Five" :
        	return 4;
        case "Six" :
        	return 5;
        case "Seven" :
        	return 6;
        case "Eight" :
        	return 7;
        case "Nine" :
        	return 8;
        case "Ten" :
        	return 9;
        case "Jack" :
        	return 10;
        case "Queen" :
        	return 11;
        case "King" :
        	return 12;
        default :
        	return -1;
     }
	}
	
	private String numToSuit(int suitGiven) {
		//use switches to set rank and suit
				switch(suitGiven) {
		        case 0 :
		           return "Clubs"; 
		        case 1 :
		        	return "Diamonds";
		        case 2 :
		        	return "Hearts";
		        case 3 :
		        	return "Spades";
		        default :
		        	return "ERROR";
				}
	}
	
	private int stringToNum(String suitgiven) {
		//return suit as int
				if(suitgiven == "Clubs") {return 0;}else{
					if(suitgiven == "Diamonds") {return 1;}else{
						if(suitgiven == "Hearts") {return 2;}else{
							if(suitgiven == "Spades") {return 3;}else {
							return -1;	
							}
						}
					}
				}
	}
//--------------------------------------------------------------------------------------------------------------------------	
	/**
	 * 
	 */
	public String toString() {
		//turn object into a string
		return (getRankString() + " of " + Suit);
	}
}
