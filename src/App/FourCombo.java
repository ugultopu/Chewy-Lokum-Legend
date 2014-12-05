package App;

import java.util.ArrayList;


public class FourCombo extends Combo{
	private FourComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public FourCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		//test = new FourComboTest();
		this.comboPriority = 2;
		Score.getInstance().scoreUpdateStripedForm();
		Score.getInstance().setUpdated(true);
	}
	
	
	
	private void generateLokum(){
		Lokum midLokum = lokums.get(1);
		Lokum nextLokum = lokums.get(2);
		int xMid = midLokum.getRowIndex();
		int yMid = midLokum.getColumnIndex();
		int xNext = nextLokum.getRowIndex();
		
		String color = midLokum.getLokumColor();
		if((xMid + 1) == xNext){
			this.generatedLokum = new HorizontalStripedLokum(xMid, yMid, color);
		}else{
			this.generatedLokum = new VerticalStripedLokum(xMid, yMid, color);
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

	@Override
	public ArrayList<Lokum> getComboLokums() {
		// TODO Auto-generated method stub
		return lokums;
	}
}
