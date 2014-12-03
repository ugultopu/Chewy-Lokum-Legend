package App;

import java.util.ArrayList;


public abstract class Combo {
	public int scoreAward;
	public ArrayList<Lokum> lokums; 
	public abstract ArrayList<Lokum> getComboLokums();
	public abstract Lokum getGeneratedLokum();
	public void addLokumToCombo(Lokum argLokum){
		lokums.add(argLokum);
	}
}
