import java.util.Comparator;

public class Compare implements Comparator<Card>{

	public boolean equals(Card c1, Card c2) {
		//return if they are the same
		if(c1.getSuitInt() == c2.getSuitInt()) {
			if(c1.getRank() == c2.getRank()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compare(Card c1, Card c2) {
		if(c1 == null) {
			return 1;
		}
		if(c2 == null) {
			return -1;
		}
		if(c1.getSuitInt() == c2.getSuitInt()) {
			if(c1.getRank() == c2.getRank()) {
				return 0;
			}else{
				return c1.getRank() - c2.getRank();
			}
		}else{
			return c1.getSuitInt() - c2.getSuitInt();
		}
	}
	
}
