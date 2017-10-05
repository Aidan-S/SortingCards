import java.util.Comparator;

public class Compare implements Comparator {
	/**
	 * 
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Card c1=(Card)o1;  
		Card c2=(Card)o2;  
		//return which is bigger with -1, 0 or 1
		return (c1.getRank()) - (c2.getRank());	
	}
	/**
	 * 
	 * @param o1 the first card object to be compared
	 * @param o2 the second card object to be compared
	 * @return whether they are the same
	 */
	public boolean equals(Object o1, Object o2) {
		Card c1=(Card)o1;  
		Card c2=(Card)o2;  
		//return if they are the same
		if(c1.getRank() == c2.getRank()) {
			return true;
		}else{
			return false;
		}
	}
	
}
