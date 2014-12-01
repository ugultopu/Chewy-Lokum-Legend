import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Box {

	private LogicField logicField;
	private Image image;
	private int side;
	

	public Box(LogicField logicField){
		this.logicField = logicField;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g1 = (Graphics2D) g;

		g.setColor(Constants.GAME_BACKGROUND_COLOR);
		
		if(logicField instanceof EmptyLogicField){
			g.fillRect(logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side);
		} else if(logicField instanceof ObstacleBox){
			g.setColor(Color.BLACK);
			g.fillRect(logicField.getX(),  Constants.BOARD_HEIGHT - logicField.getY(), side, side);
		} else {
			logicField = (Lokum) logicField;
		}
		
		if(logicField instanceof NormalLokum){
			switch(logicField.getColor()){
				case Constants.LOKUM_COLOR_RED:
					ImageIcon redNormalLokumImage = new ImageIcon("images/normalredlokum.png");
					image = redNormalLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;
				case Constants.LOKUM_COLOR_GREEN:
					ImageIcon yellowNormalLokumImage = new ImageIcon("images/normalgreenlokum.png");
					image = yellowNormalLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_BROWN:
					ImageIcon brownNormalLokumImage = new ImageIcon("images/normalbrownlokum.png");
					image = brownNormalLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_WHITE:
					ImageIcon whiteNormalLokumImage = new ImageIcon("images/normalwhitelokum.png");
					image = whiteNormalLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;						
				default: g.fillRect(logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side);
			}
		}
		
		if(logicField instanceof StrippedLokum){
			switch(logicField.getColor()){
				case Constants.LOKUM_COLOR_RED:
					ImageIcon redStrippedLokumImage = new ImageIcon("images/strippedredlokum.png");
					image = redStrippedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;
				case Constants.LOKUM_COLOR_GREEN:
					ImageIcon yellowStrippedLokumImage = new ImageIcon("images/strippedgreenlokum.png");
					image = yellowStrippedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_BROWN:
					ImageIcon brownStrippedLokumImage = new ImageIcon("images/strippedbrownlokum.png");
					image = brownStrippedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_WHITE:
					ImageIcon whiteStrippedLokumImage = new ImageIcon("images/strippedwhitelokum.png");
					image = whiteStrippedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;						
				default: g.fillRect(logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side);
			}
		}
		
		if(logicField instanceof WrappedLokum){
			switch(logicField.getColor()){
				case Constants.LOKUM_COLOR_RED:
					ImageIcon redWrappedLokumImage = new ImageIcon("images/wrappedredlokum.png");
					image = redWrappedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;
				case Constants.LOKUM_COLOR_GREEN:
					ImageIcon yellowWrappedLokumImage = new ImageIcon("images/wrappedgreenlokum.png");
					image = yellowWrappedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_BROWN:
					ImageIcon brownWrappedLokumImage = new ImageIcon("images/wrappedbrownlokum.png");
					image = brownWrappedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;	
				case Constants.LOKUM_COLOR_WHITE:
					ImageIcon whiteWrappedLokumImage = new ImageIcon("images/wrappedwhitelokum.png");
					image = whiteWrappedLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;						
				default: g.fillRect(logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side);
			}
		}
			if(logicField instanceof BombLokum){
					ImageIcon bombLokumImage = new ImageIcon("images/bomblokum.png");
					image = bombLokumImage.getImage();
					g.drawImage(image, logicField.getX(), Constants.BOARD_HEIGHT - logicField.getY(), side, side, null); break;
			} else {
				g.fillRect(logicField.getX(),  Constants.BOARD_HEIGHT - logicField.getY(), side, side);
			}
	}
}