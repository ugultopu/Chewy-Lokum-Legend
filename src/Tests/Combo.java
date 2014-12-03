public class ThreeCombo{
	public String toString(){
		String lokumString = "";
		for(int i = 0; i < lokums.length; i++){
			lokumString += lokums.get(i).toString + "\n";
		}
		return "Three Lokum Combo With Lokums: " + lokumString;
	}
}

public class FourComboTest{
	private static lokum generatedLokum
	public void generateLokumTest(){
		setUp();
		//See if the generated lokum is true.
		System.out.println(generatedLokum.toString())
	}
}

public class FiveComboTest {
	private static Lokum generatedLokum;
	public void generateLokumTest(){
		setUp();
		//See if the generated lokum is true.
		System.out.println(generatedLokum.toString())

	}
}

public class LComboTest{

	private static Lokum generatedLokum;
	public void generateLokumTest(){
		setUp();
		//See if the generated lokum is true
		System.out.println(generatedLokum.toString())

	}
}

public class TComboTest{

	private static Lokum generatedLokum;

	public void generateLokumTest(){
		setUp();
		//See if the generated lokum is true.
		System.out.println(generatedLokum.toString())
	}
}

public interface LokumGeneratingCombo{
	/**
	 *Generates the proper lokum if the combo is correct
	 *@requires lokums != null, lokums.length bigger than 3
	 *@ensures lokums != null, generatedLokum instance of SpecialLokum
	 *generatedLokum the proper lokum generated
	 */
	public void generateLokum();
}

public class FourCombo() extends Combo implements LokumGeneratingCombo{
	public void generateLokum(){
		if(lokums == null)
			return;
		if(lokums.length < 4){
			return;
		}

		return StripedLokum
	}

	public String toString(){
		String lokumString = "";
		for(int i = 0; i < lokums.length; i++){
			lokumString += lokums.get(i).toString + "\n";
		}
		return "Five Lokum Combo With Lokums: " + lokumString;
	}

}

public class FiveCombo() extends Combo implements LokumGeneratingCombo{
	public void generateLokum(){
		if(lokums == null)
			return;
		if(lokums.length < 4){
			return;
		}

		return WrappedLokum
	}

	public String toString(){
		String lokumString = "";
		for(int i = 0; i < lokums.length; i++){
			lokumString += lokums.get(i).toString + "\n";
		}
		return "Five Lokum Combo With Lokums: " + lokumString;
	}

}

public class TCombo() extends Combo implements LokumGeneratingCombo{
	public void generateLokum(){
		if(lokums == null)
			return;
		if(lokums.length < 4){
			return;
		}
		return BombLokum
	}
	public String toString(){
		String lokumString = "";
		for(int i = 0; i < lokums.length; i++){
			lokumString += lokums.get(i).toString + "\n";
		}
		return "T Lokum Combo With Lokums: " + lokumString;
	}
}

public class LCombo() extends Combo implements LokumGeneratingCombo{
	public void generateLokum(){
		if(lokums == null)
			return;
		if(lokums.length < 4){
			return;
		}

		return BombLokum
	}
	public String toString(){
		String lokumString = "";
		for(int i = 0; i < lokums.length; i++){
			lokumString += lokums.get(i).toString + "\n";
		}
		return "L Lokum Combo With Lokums: " + lokumString;
	}
}

public abstract class Combo{
	public Int scoreAward;
	public lokums = ArrayList<LogicField>()
}
