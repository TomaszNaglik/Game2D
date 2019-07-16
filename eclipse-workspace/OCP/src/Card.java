
public class Card {
	
	private String rank;
	private String suit;
	
	public Card (String r, String s) {
		if(r == null || s == null)
			throw new IllegalArgumentException();
		rank = r;
		suit = s;
	}
	
	public String toString() {
		return rank +" "+ suit;
	}
	
}
