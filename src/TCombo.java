import java.util.ArrayList;

public class TCombo {
	private TComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public TCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		test = new TComboTest();
	
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	public void generateLokum(){
		Lokum midLokum = lokums.get(2);
		int midx = midLokum.getRowIndex();
		int midy = midLokum.getColumnIndex();
		String midColor = midLokum.getLokumColor();
		this.generatedLokum = new WrappedLokum(midx, midy, midColor);
	}
	
	public ArrayList<Lokum> getComboLokums(){
		return lokums;
	}
	
	public class TComboTest{
		public TComboTest(){
			if(lokums == null){
				System.out.println("Lokums in T combo is null");
			}else{
				for(int i = 0; i < lokums.size(); i++){
					Lokum lokum = lokums.get(i);
					System.out.println("T lokum combo with lokums: " + lokum.toString() + ", ");
					System.out.println("Generated: " + generatedLokum.toString());
				}
			}
		}
	}
}
