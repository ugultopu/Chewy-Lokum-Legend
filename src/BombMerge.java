import java.util.Random;


public class BombMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	private Lokum[][] lokumBoard;

	public BombMerge(Lokum l1, Lokum l2){
		this.l1 = l1;
		this.l2 = l2;
		board = BoardLogic.getInstance();
		lokumBoard = (Lokum[][]) board.getBoard();
	}

	public void destroyMerge(){
		if(l1 instanceof NormalLokum){
			String colorl1 = l1.getLokumColor();
			System.out.println("l1: Normal Lokum, color: " + colorl1 + ", l2: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum =  lokumBoard[i][j];
					if(lokum.getLokumColor().equals(colorl1)){
						NormalLokum newLokum = new NormalLokum(i, j, colorl1);
						newLokum.comboDestroy();
					}
				}
			}
		}else if(l2 instanceof NormalLokum){
			String colorl2 = l2.getLokumColor();
			System.out.println("l2: Normal Lokum, color: " + colorl2 + ", l1: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum = lokumBoard[i][j];
					if(lokum.getLokumColor().equals(colorl2)){
						NormalLokum newLokum = new NormalLokum(i, j, colorl2);
						newLokum.comboDestroy();
					}
				}
			}
		}else if(l1 instanceof StripedLokum){
			Random randomGenerator = new Random();
			String colorl1 = l1.getLokumColor();
			System.out.println("l1: Striped Lokum, color: " + colorl1 + ", l2: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum = lokumBoard[i][j];
					if(lokum.getLokumColor().equals(colorl1)){
						int randomStriped = randomGenerator.nextInt(2);
						if(randomStriped == 0){
							VerticalStripedLokum newLokum = new VerticalStripedLokum(i, j, colorl1);
							newLokum.comboDestroy();
						}else if(randomStriped == 1){
							HorizontalStripedLokum newLokum = new HorizontalStripedLokum(i, j, colorl1);
							newLokum.comboDestroy();
						}else{
							System.out.println("Error at Bomb + Striped Merge");
						}
					}
				}
			}
		}else if(l2 instanceof StripedLokum){
			String colorl2 = l2.getLokumColor();
			Random randomGenerator = new Random();
			System.out.println("l2: Striped Lokum, color: " + colorl2 + ", l1: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum = lokumBoard[i][j];
					if(lokum.getLokumColor().equals(colorl2)){
						int randomStriped = randomGenerator.nextInt(2);
						if(randomStriped == 0){
							VerticalStripedLokum newLokum = new VerticalStripedLokum(i, j, colorl2);
							newLokum.comboDestroy();
						}else if(randomStriped == 1){
							HorizontalStripedLokum newLokum = new HorizontalStripedLokum(i, j, colorl2);
							newLokum.comboDestroy();
						}else{
							System.out.println("Error at Bomb + Striped Merge");
						}
					}
				}
			}
		}else if(l1 instanceof WrappedLokum){
			String colorl1 = l1.getLokumColor();
			System.out.println("l1: Wrapped Lokum, color: " + colorl1 + ", l2: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum = lokumBoard[i][j];
					if(lokum.getColor().equals(colorl1)){
						WrappedLokum newLokum = new WrappedLokum(i, j, colorl1);
						newLokum.comboDestroy();
					}
				}
			}
			destroyMostOccuredColor();
		}else if(l2 instanceof WrappedLokum){
			String colorl2 = l2.getLokumColor();
			System.out.println("l2: Wrapped Lokum, color: " + colorl2 + ", l1: Bomb Lokum, merge.");
			for(int i = 0; i < lokumBoard.length; i++){
				for(int j = 0; j < lokumBoard[i].length; j++){
					Lokum lokum = lokumBoard[i][j];
					if(lokum.getLokumColor().equals(colorl2)){
						WrappedLokum newLokum = new WrappedLokum(i, j, colorl2);
						newLokum.comboDestroy();
					}
				}
			}
			destroyMostOccuredColor();
		}else if(l1 instanceof BombLokum || l2 instanceof BombLokum){
			System.out.println("Anasını siktin.");
		}else{
			System.out.println("FATAL ERROR!: BOMBMERGE");
		}
	}
	
	private void destroyMostOccuredColor(){
		String color = getMostOccuredColor();
		for(int i = 0; i < lokumBoard.length; i++){
			for(int j = 0; j < lokumBoard[i].length; j++){
				Lokum lokum = lokumBoard[i][j];
				if(lokum.getLokumColor().equals(color)){
					lokum.comboDestroy();
				}
			}
		}
	}
	
	private String getMostOccuredColor(){
		int whiteCounter = 0;
		int brownCounter = 0;
		int redCounter = 0;
		int greenCounter = 0;
		String redColor = Constants.LOKUM_COLOR_RED;
		String brownColor = Constants.LOKUM_COLOR_BROWN;
		String whiteColor = Constants.LOKUM_COLOR_WHITE;
		String greenColor = Constants.LOKUM_COLOR_GREEN;
		
		for(int i = 0; i < lokumBoard.length; i++){
			for(int j = 0; j < lokumBoard[i].length; j++){
				Lokum lokum = lokumBoard[i][j];
				String lokumColor = lokum.getLokumColor();
				if(lokumColor.equals(redColor)){
					redCounter++;
				}else if(lokumColor.equals(brownColor)){
					brownCounter++;
				}else if(lokumColor.equals(whiteColor)){
					whiteCounter++;
				}else if(lokumColor.equals(greenColor)){
					greenCounter++;
				}else{
					System.out.println("Not a valid color");
				}
			}
		}
		
		int mostColor = Math.max(Math.max(whiteCounter, greenCounter), Math.max(redCounter, brownCounter));
		if(mostColor == redCounter){
			return redColor;
		}else if(mostColor == greenCounter){
			return greenColor;
		}else if(mostColor == brownCounter){
			return brownColor;
		}else if(mostColor == whiteCounter){
			return whiteColor;
		}else{
			return null;
		}
	}
}
