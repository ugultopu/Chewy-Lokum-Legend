package App;

import java.util.ArrayList;


public abstract class Combo {
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
}
