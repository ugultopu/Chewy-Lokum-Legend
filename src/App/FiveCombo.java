package App;

import java.util.*;

public class FiveCombo extends Combo implements LokumGeneratingCombo{
	private FiveComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public FiveCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		//test = new FiveComboTest();
		this.comboPriority = 4;
		
		
	}
	
	public void generateLokum(){
		Lokum midLokum = lokums.get(2);
		int x = midLokum.getRowIndex();
		int y = midLokum.getColumnIndex();
		this.generatedLokum = new BombLokum(x, y);
	}
	
	public Lokum getGeneratedLokum(){
		
		return generatedLokum;
	}
	
	public void addGeneratedLokumtoQueue(){
		BombLokum copy = (BombLokum) copyLokum(generatedLokum);
		LokumGenerateEvent lge = new LokumGenerateEvent(copy);
		EventDispatchQueue.getInstance().addEvent(lge);
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

	@Override
	public Lokum copyLokum(Lokum lok) {
		int x = lok.getRowIndex();
		int y = lok.getColumnIndex();
		return new BombLokum(x, y);
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		Score.getInstance().scoreUpdateBombForm();
		
	}
}
