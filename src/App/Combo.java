package App;

import java.util.ArrayList;


public abstract class Combo {
	public int scoreAward;
	public ArrayList<Lokum> lokums; 
	public abstract ArrayList<Lokum> getComboLokums();
	public abstract Lokum getGeneratedLokum();
	int comboPriority;
	public void addLokumToCombo(Lokum argLokum){
		lokums.add(argLokum);
	}
	public boolean hasHigherPriority(Combo argCombo){
		return this.comboPriority > argCombo.comboPriority;
	}
	public boolean hasSamePriority(Combo argCombo){
		return this.comboPriority == argCombo.comboPriority;
	}
	public boolean hasLowerPriority(Combo argCombo){
		return this.comboPriority < argCombo.comboPriority;
	}
}
