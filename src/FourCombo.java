import java.util.ArrayList;


public class FourCombo {
	private FourComboTest test;
	private ArrayList<Lokum> lokums;
	private String fourComboType; //Horizontal, vertical
	private Lokum generatedLokum;
	private String fourComboType;
	
	public FourCombo(ArrayList<Lokum> lokums, String fourComboType){
		this.lokums = lokums;
		this.fourComboType = fourComboType;
		this.fourComboType = fourComboType;
		generateLokum();
		test = new FourComboTest();
	}
	
	public ArrayList<Lokums> getComboLokums(){
		return lokums;
	}
	
	public void generateLokum(){
		if(fourComboType.equals("horizontal")){
			this.generatedLokum = new HorizontalStripedLokum(...);
		}else{
			this.generatedLokum = new VerticalStripedLokum(...);
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
