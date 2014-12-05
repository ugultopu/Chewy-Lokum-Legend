package App;

import java.util.ArrayList;

public class LCombo extends Combo implements LokumGeneratingCombo{
	private LComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public LCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		//test = new LComboTest();
		this.comboPriority = 3;
		Score.getInstance().scoreUpdateWrappedForm();
	}
	
	public Lokum getGeneratedLokum(){
		
		return generatedLokum;
	}
	
	public void generateLokum(){
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

	@Override
	public Lokum copyLokum(Lokum lok) {
		int x = lok.getRowIndex();
		int y = lok.getColumnIndex();
		String color = lok.getLokumColor();
		return new WrappedLokum(x, y, color);
	}

	@Override
	public void addGeneratedLokumtoQueue() {
		// TODO Auto-generated method stub
		WrappedLokum copy = (WrappedLokum) copyLokum(generatedLokum);
		LokumGenerateEvent lge = new LokumGenerateEvent(copy);
		EventDispatchQueue.getInstance().addEvent(lge);
	}
}
