package App;

import java.util.*;

public class ThreeCombo extends Combo {
	private ThreeComboTest test;
	private ArrayList<Lokum> lokums;

	public ThreeCombo(ArrayList<Lokum> lokums){
		//test = new ThreeComboTest();
		this.lokums = lokums;
		this.comboPriority = 1;
		Score.getInstance().scoreUpdateThreeCombo();
		Score.getInstance().setUpdated(true);
	}
	
//Test for the method:
	public class ThreeComboTest{
		public ThreeComboTest(){
			if(lokums == null){
				System.out.println("Lokums in three combo is null");
			}else{
				for(int i = 0; i < lokums.size(); i++){
					Lokum lokum = lokums.get(i);
					System.out.println("Three lokum combo with lokums: " + lokum.toString() + ", ");
				}
			}
		}
	}

	@Override
	public Lokum getGeneratedLokum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lokum> getComboLokums() {
		// TODO Auto-generated method stub
		return lokums;
	}
}
