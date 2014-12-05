package App;

import java.util.ArrayList;
import java.util.Comparator;


public abstract class Combo implements Comparator<Combo>{
	public int scoreAward;
	public ArrayList<Lokum> lokums;
	int comboPriority;
	
	public abstract ArrayList<Lokum> getComboLokums();
	
	public abstract Lokum getGeneratedLokum();
	
	public void addLokumToCombo(Lokum argLokum){
		lokums.add(argLokum);
	}
	
	public abstract void addGeneratedLokumtoQueue();
	
	public boolean hasHigherPriority(Combo argCombo){
		return this.comboPriority > argCombo.comboPriority;
	}
	public boolean hasSamePriority(Combo argCombo){
		return this.comboPriority == argCombo.comboPriority;
	}
	public boolean hasLowerPriority(Combo argCombo){
		return this.comboPriority < argCombo.comboPriority;
	}
	
	public void addComboToLokums(){
		ArrayList<Lokum> comboLokums = this.getComboLokums();
		for(int comboLokumsIndex=0;comboLokumsIndex<comboLokums.size();comboLokumsIndex++){
			comboLokums.get(comboLokumsIndex).addComboToComboList(this);
		}
	}

	@Override
	public int compare(Combo c1, Combo c2) {
		// TODO Auto-generated method stub
		if(c1.comboPriority < c2.comboPriority)
			return 1;
		else if(c1.comboPriority == c2.comboPriority)
			return 0;
		else
			return -1;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if( !(obj instanceof Combo) )
			return false;
		/*
		 * if here, then obj is an instance of Combo. I guess checking for sub-type equality is not a must. So just
		 * do not perform it. 
		 */
		Combo argCombo = (Combo) obj;
		ArrayList<Lokum> argComboLokums = argCombo.getComboLokums();
		if( this.lokums.size() != argComboLokums.size() )
			return false;
		/*
		 * if here, then sizes of comboLokums of two combos are the same. So check if
		 * each element is present in one another.
		 */
		for(int i=0;i<lokums.size();i++){
			Lokum currentLokum = lokums.get(i);
			if(!argComboLokums.contains(currentLokum))
				return false;
		}
		/*
		 * if here, then it has passed all tests. So return true.
		 */
		return true;
	}
	
}
