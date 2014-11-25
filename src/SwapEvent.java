
public class SwapEvent extends GameEvent {
	
	Lokum swapLokum1;
	Lokum swapLokum2;
	
	public SwapEvent(Lokum swapLokum1, Lokum swapLokum2){
		this.swapLokum1 = swapLokum1;
		this.swapLokum2 = swapLokum2;
	}
	
	@Override
	public void executeEvent() {
		GameBoardPanel.changeLokum(swapLokum1);
		GameBoardPanel.changeLokum(swapLokum2);
		GameBoardPanel.getInstance().repaint();
	}

}
