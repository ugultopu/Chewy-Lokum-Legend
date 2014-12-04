package App;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.LinkedList;
import java.util.Iterator;

public class GamePanel extends JPanel {
	private static int LabelXPadding = 750;  
	private static int LabelYPadding = 160;
	
//	protected GameOverPanel gameOverPanel;
	protected boolean running=true;
	private static GamePanel instance;
	
	private GamePanel() {
		super();
		
		EventDispatchQueue.resetInstance();
		
		new Thread(new Runnable(){

			public void run() {

				while(running){
					gameUpdate();
				}				
			}
			
		}).start();
		
		
		
		setLayout(null);
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		add(InformationBoard.getInstance());
		InformationBoard.getInstance().setBounds(LabelXPadding,LabelYPadding, 
				Constants.INFORMATION_BOARD_WIDTH,Constants.INFORMATION_BOARD_HEIGHT);
		
		add(GameBoard.getInstance());
//		gameBoard.setBounds(40, 60, 600, 540);
				
	}

	public void startGame(){
		running=true;
	}
	
	public void endGame(){
		running = false;
//		gameOverPanel = new GameOverPanel(ownerFrame, scoreCalculator.getScore());
//		remove(blockboard);
//		
//		gameOverPanel.setBounds(40, 60, 360, 540);
//		add(gameOverPanel);
//		gameOverPanel.repaint();
	}
		
//	private void scoreUpdate(){
//		if(scoreCalculator.updated){
//			informationPanel.repaint();
//			scoreCalculator.updated = false;
//		}
//		
//	}
	
	private void gameUpdate(){
		if(!EventDispatchQueue.getInstance().isEmpty()){
			EventDispatchQueue.getInstance().getEvent().executeEvent();
		}
	}
	
	public static GamePanel getInstance(){
		if(instance==null){
			instance = new GamePanel();
		}
		return instance;
	}
	
	public static void resetInstance(){
		instance = new GamePanel();
	}	


	public void paint(Graphics g){

		g.setColor(Constants.GAME_BACKGROUND_COLOR);
		g.fillRect(0,0,Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		g.setColor(new Color(0,0,0));
		g.fillRect(30,50, Constants.ANIMATION_WINDOW_WIDTH, Constants.ANIMATION_WINDOW_HEIGHT);
		g.fillRect(750, 160, Constants.INFORMATION_BOARD_WIDTH, Constants.INFORMATION_BOARD_HEIGHT);
    	
    	
    	InformationBoard.getInstance().repaint();
		GameBoard.getInstance().repaint();
	}

}
