import java.util.*;

public class FiveCombo {
	private FiveComboTest test;
	private ArrayList<Lokum> lokums;
	private Lokum generatedLokum;
	
	public FiveCombo(ArrayList<Lokum> lokums){
		this.lokums = lokums;
		generateLokum();
		test = new FiveComboTest();
		
	}
	
	public void generateLokum(){
		this.generatedLokum = new BombLokum(.....);
	}
	
	public Lokum getGeneratedLokum(){
		return generatedLokum;
	}
	
	public ArrayList<Lokum> getComboLokums(){
		return lokums;
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
}
