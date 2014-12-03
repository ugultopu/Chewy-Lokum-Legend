package App;

import java.util.ArrayList;


public class FourCombo extends Combo{
	private FourComboTest test;
	private ArrayList<Lokum> lokums;
	private String fourComboType; //Horizontal, vertical
	private Lokum generatedLokum;
	
	public FourCombo(ArrayList<Lokum> lokums, String fourComboType){
		this.lokums = lokums;
		this.fourComboType = fourComboType;
		generateLokum();
		test = new FourComboTest();
	}
	
	public ArrayList<Lokum> getComboLokums(){
		return lokums;
	}
	
	private void generateLokum(){
		Lokum midLokum = lokums.get(1);
		int x = midLokum.getRowIndex();
		int y = midLokum.getColumnIndex();
		String color = midLokum.getLokumColor();
		if(fourComboType.equals("horizontal")){
			this.generatedLokum = new HorizontalStripedLokum(x, y, color);
		}else{
			this.generatedLokum = new VerticalStripedLokum(x, y, color);
		}
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	public class FourComboTest{
		public FourComboTest(){
			if(lokums == null){
				System.out.println("Lokums in four combo is null");
			}else{
				for(int i = 0; i < lokums.size(); i++){
					Lokum lokum = lokums.get(i);
					System.out.println("Four lokum combo with lokums: " + lokum.toString() + ", ");
					System.out.println("Generated: " + generatedLokum.toString());
				}
			}
		}
	}
}
