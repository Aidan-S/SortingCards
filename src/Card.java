import java.util.Comparator;

public class Card{
	
	private String Suit;
	private int Rank;
	
	Card() {
		
	}
	
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

	private Card(String suitGiven, int rankGiven) {
        Suit = suitGiven;
		Rank = rankGiven;
	}

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
	
	private String getSuit() {
		return Suit;
	}
	
	private int getRank() {
		return Rank;
	}
	
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
	
	public String toString() {
		return (getRankString() + " of " + Suit);
	}
}
