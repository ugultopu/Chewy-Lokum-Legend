import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.LinkedList;
import java.util.Iterator;

public class GamePanel extends JPanel {
	private static int LabelXPadding = Constants.SCREEN_WIDTH*11/16;  
	private static int LabelYPadding = Constants.SCREEN_HEIGHT*6/16;
	
	protected BlockBoard blockboard;
	private GameInformationPanel informationPanel;
//	protected GameOverPanel gameOverPanel;
	protected boolean running=true;
//	private ScoreCalculator scoreCalculator;
	private static GamePanel instance;
	
	public GamePanel() {
		super();
		
//		scoreCalculator = new ScoreCalculator();
		
		informationPanel = new GameInformationPanel(scoreCalculator);
		
		add(informationPanel);
		informationPanel.setBounds(LabelXPadding, LabelYPadding, 
				Constants.INFORMATIONPANEL_SIZE,Constants.INFORMATIONPANEL_SIZE);
		

		blockboard = new BlockBoard(ownerFrame, scoreCalculator);
				
		nextPiecePanel = new NextPiecePanel(ownerFrame);
		
		requestFocusInWindow();
		
		new Thread(new Runnable(){

			public void run() {

				while(running){
					gameUpdate();
					scoreUpdate();
				}				
			}
			
		}).start();
		
		
		
		setLayout(null);
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		add(informationPanel);
		informationPanel.setBounds(LabelXPadding, LabelYPadding, 
				Constants.INFORMATIONPANEL_SIZE,Constants.INFORMATIONPANEL_SIZE);
		
		add(blockboard);
		blockboard.setBounds(40, 60, 600, 540);
		
		
		
				
		
	}
	public void startGame(){
		running=true;
	}
	
//	public void endGame(){
//		running = false;
//		gameOverPanel = new GameOverPanel(ownerFrame, scoreCalculator.getScore());
//		remove(blockboard);
//		
//		gameOverPanel.setBounds(40, 60, 360, 540);
//		add(gameOverPanel);
//		gameOverPanel.repaint();
//	}
		
//	private void scoreUpdate(){
//		if(scoreCalculator.updated){
//			informationPanel.repaint();
//			scoreCalculator.updated = false;
//		}
//		
//	}
	
	public static GamePanel getInstance(){
		if(instance==null){
			instance = new GamePanel();
		}
		return instance;
	}
	
	public void resetInstance(){
		instance = null;
	}	


	public void paint(Graphics g){
		/* For some reason background color won't change so a fillRect is put in to background */
		g.setColor(Constants.GAME_BACKGROUND_COLOR);
		g.fillRect(0,0,Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		g.setColor(new Color(0,0,0));
		g.fillRect(440, 60,220,150);
		g.setColor(new Color(0,0,0));
    	g.fillRect(30,50, 380, 560);
    	
    	informationPanel.repaint();
		blockboard.repaint();
	}

}
