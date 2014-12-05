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
}
