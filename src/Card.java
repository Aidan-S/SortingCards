import java.util.Comparator;

public class Card implements Comparator{
	
	private String Suit;
	private int Rank;
	
	public Card() {
		
	}
	
	private Card(int suitGiven, int rankGiven) {
		switch(suitGiven) {
        case 0 :
            Suit = "Clubs"; 
            break;
        case 1 :
        	Suit = "Hearts";
            break;
        case 2 :
        	Suit = "Spades";
            break;
        case 3 :
        	Suit = "Diamonds";
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
        	Suit = "Hearts";
            break;
        case 2 :
        	Suit = "Spades";
            break;
        case 3 :
        	Suit = "Diamonds";
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
	
	private String name() {
		return (Suit+ " of " + Rank);
	}
	
	private int getSuitInt() {
		return ;
	}
	
	private String getRankString() {
		return ;
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
