package interfaces.cardComparator;
import java.util.*;
public class Card implements Comparable<Card>{
	private char color;
	private int value;
	private char[] suits = {'S','H','D','C'};


	public Card(char color, int value){
		if (color == 'S' ||color == 'H' ||color == 'D' ||color == 'C' ){
			this.color=  color;
		}else{
			throw new IllegalArgumentException("Color must be S, H, D or C");

		}if (value<1 || value>13){
			throw new IllegalArgumentException("Value must be between 1-13");
		}else{
			this.value= value;
		}
	}
	public char getSuit(){
		return this.color;
	}
	public int getFace(){
		return this.value;
	}
	
		public int compareTo(Card card){
			
			if (color != card.getSuit()) {
				int verdiThis = 0;
				int verdiCard = 0;
				for (int i = 0; i < suits.length; i++) {
					if(color == suits[i]){
						verdiThis = i;
					}
					if (card.getSuit()== suits[i]){
						verdiCard = i;
					}
				}
				if (verdiThis>verdiCard){
					return -1;
				}else{
					return 1;
				}
			}
			else{
				if( card.getFace() > this.value){
					return -1;
				}else if( card.getFace() < this.value){
					return 1;
				}
				else{
					return 0;
				}
			}
		}


	public String toString(){
		return String.format("%s", getSuit()) + String.format("%s", getFace());
	}

	public static void main(String[] args) {
		Card card = new Card('S',2);
		Card card1 = new Card('S',3);

		System.out.println(card.compareTo(card1));
	}
}
