package App;

import java.util.*;

public class FiveCombo extends Combo{
	private FiveComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public FiveCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		test = new FiveComboTest();
		
	}
	
	private void generateLokum(){
		Lokum midLokum = lokums.get(2);
		int x = midLokum.getRowIndex();
		int y = midLokum.getColumnIndex();
		String color = midLokum.getLokumColor();
		this.generatedLokum = new BombLokum(x, y, color);
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	public class FiveComboTest{
		public FiveComboTest(){
			if(lokums == null){
				System.out.println("Lokums in five combo is null");
			}else{
				for(int i = 0; i < lokums.size(); i++){
					Lokum lokum = lokums.get(i);
					System.out.println("Five lokum combo with lokums: " + lokum.toString() + ", ");
					System.out.println("Generated: " + generatedLokum.toString());
				}
			}
		}
	}

	@Override
	public ArrayList<Lokum> getComboLokums() {
		// TODO Auto-generated method stub
		return lokums;
	}
}
