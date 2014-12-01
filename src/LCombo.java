import java.util.ArrayList;

public class LCombo {
	private LComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public LCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		test = new LComboTest();
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	public void generateLokum(){
		this.generatedLokum = new WrappedLokum(.....);
	}
	
	public ArrayList<Lokum> getComboLokums(){
		return lokums;
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
}
