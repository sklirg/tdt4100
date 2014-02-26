package interfaces.cardComparator;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	private char[] suits = {'S','H','D','C'};
	private boolean ess;
	private char trumf;

	public CardComparator(boolean ess, char trumf){
		this.trumf = trumf;
		this.ess = ess;
	}
	public int compare(Card card1, Card card2) {

		if (card1.getSuit() != card2.getSuit()) {
			if(card1.getSuit() == this.trumf){
				return 1;
			}else if (card2.getSuit() == this.trumf){
				return -1;
			}
			int verdiCard1 = 0;
			int verdiCard2 = 0;
			for (int i = 0; i < suits.length; i++) {
				if(card1.getSuit() == suits[i]){		
					verdiCard1 = i;
				}
				if (card2.getSuit()== suits[i]){
					verdiCard2 = i;
				}
			}
			if (verdiCard1>verdiCard2){
				return -1;
			}else{
				return 1;
			}
		}
		else if (ess){
			if(card1.getFace() == 1 && card2.getFace() != 1){
				return 1;
			}else if(card1.getFace() != 1 && card2.getFace() == 1){
				return -1;
			}else{
				if( card2.getFace() > card1.getFace()){
					return -1;
				}else if( card2.getFace() < card1.getFace()){
					return 1;
				}
				else{
					return 0;
				}
			}
		}else{

			if( card2.getFace() > card1.getFace()){
				return -1;
			}else if( card2.getFace() < card1.getFace()){
				return 1;
			}
			else{
				return 0;
			}		
		}
	}
}
