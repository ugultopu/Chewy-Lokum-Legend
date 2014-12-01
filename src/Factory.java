
public class Factory {
	public static Lokum createLokum(String color, int x, int y, String type){
		if(type == "NormalLokum"){
			return new NormalLokum(x, y, color);
		}else if(type == "VerticalStripedLokum"){
			return new VerticalStripedLokum(x, y, color);
		}else if(type == "HorizontalStripedLokum"){
			return new HorizontalStripedLokum(x, y, color);
		}else if(type == "WrappedLokum"){
			return new WrappedLokum(x, y, color);
		}else if(type == "BombLokum"){
			return new BombLokum(x, y, null);
		}else{
			System.out.println("Foctory error: No such lokum.");
			return null;
		}
		
	}
	
	public static Merge createMerge(Lokum l1, Lokum l2){
		if(l1 instanceof HorizontalStripedLokum || l1 instanceof VerticalStripedLokum && l2 instanceof VerticalStripedLokum || l2 instanceof HorizontalStripedLokum){
			System.out.println("Striped + Striped Merge");
			return new StripedStripedMerge(l1, l2);
		}else if(l1 instanceof StripedLokum || l1 instanceof WrappedLokum && l2 instanceof WrappedLokum || l2 instanceof StripedLokum){
			System.out.println("Striped + Wrapped Merge");
			return new StripedWrappedMerge(l1, l2);
		}else if(l1 instanceof BombLokum || l2 instanceof BombLokum){
			System.out.println("Bomb Merge");
			return new BombMerge(l1, l2);
		}else if(l1 instanceof WrappedLokum && l2 instanceof WrappedLokum){
			System.out.println("Wrapped + Wrapped Merge");
			return new WrappedWrappedMerge(l1, l2);
		}else{
			System.out.println("NOT A MERGE");
			return null;
		}
	}
}
