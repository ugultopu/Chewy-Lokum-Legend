package App;

import java.util.ArrayList;

public class LCombo extends Combo{
	private LComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public LCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		//test = new LComboTest();
		this.comboPriority = 3;
		Score.getInstance().scoreUpdateWrappedForm();
		Score.getInstance().setUpdated(true);
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	private void generateLokum(){
		Lokum midLokum = lokums.get(2);
		int x = midLokum.getRowIndex();
		int y = midLokum.getColumnIndex();
		String color = midLokum.getLokumColor();
		this.generatedLokum = new WrappedLokum(x, y, color);
	}
	
	public class LComboTest{
		public LComboTest(){
			if(lokums == null){
				System.out.println("Lokums in L combo is null");
			}else{
				for(int i = 0; i < lokums.size(); i++){
					Lokum lokum = lokums.get(i);
					System.out.println("L lokum combo with lokums: " + lokum.toString() + ", ");
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
