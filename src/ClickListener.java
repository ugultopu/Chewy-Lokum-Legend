
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ClickListener implements MouseListener {
	
	Integer selectedRow = null;
	Integer selectedColumn = null; 
	boolean active = true;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(active){
			if(selectedRow == null || selectedColumn == null){
				selectedRow = convertToRowIndex(e.getY());
				selectedColumn = convertToColumnIndex(e.getX());
			}else{
				int otherRow = convertToRowIndex(e.getY());
				int otherColumn = convertToColumnIndex(e.getX());
				BoardLogic.getInstance().swap(selectedColumn, selectedRow, otherColumn, otherRow);
				selectedRow = null;
				selectedColumn = null;
			}
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(active){
			if(selectedRow != null && selectedColumn != null){
				int otherRow = convertToRowIndex(e.getY());
				int otherColumn = convertToColumnIndex(e.getX());
				if(!(selectedRow == otherRow && selectedColumn == otherColumn)){
					BoardLogic.getInstance().swap(selectedColumn, selectedRow, otherColumn, otherRow);
					selectedRow = null;
					selectedColumn = null;
				}
			}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private int convertToRowIndex(Integer yLocation){
		return (Constants.ANIMATION_WINDOW_HEIGHT-yLocation)/(Constants.ANIMATION_WINDOW_HEIGHT/Constants.SCREEN_HEIGHT);
	}
	
	private int convertToColumnIndex(Integer xLocation){
		return selectedColumn = xLocation/(Constants.ANIMATION_WINDOW_WIDTH/Constants.SCREEN_WIDTH);
	}

}
