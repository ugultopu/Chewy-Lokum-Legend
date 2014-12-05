package App;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationBoard extends JPanel {
	private JLabel level,target,score,movesLeft,levelInput,targetInput,scoreInput,movesLeftInput;
	private JButton saveButton;
	private int currentScore;
	private int goalScore = 1000000000;
	private int currentLevel;
	private int moves=99;
	private static InformationBoard instance;

	public InformationBoard(){
		
		level = new JLabel("Level");
		target = new JLabel("Target");
		score = new JLabel("Score");
		movesLeft = new JLabel("Moves");
		levelInput = new JLabel("");
		targetInput = new JLabel(""+goalScore);
		scoreInput = new JLabel(""+currentScore);
		movesLeftInput = new JLabel(""+moves);
		saveButton = new JButton("Save Game");
		
		setLayout(null);
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		
		add(level);
		level.setBounds(0, 0,80,30);
		level.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(target);
		target.setBounds(0, 60, 80, 30);
		target.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(score);
		score.setBounds(0, 120, 80, 30);
		score.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(movesLeft);
		movesLeft.setBounds(0, 180, 80, 30);
		movesLeft.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(levelInput);
		levelInput.setBounds(100, 0,80,30);
		levelInput.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(targetInput);
		targetInput.setBounds(100, 60, 80, 30);
		targetInput.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(scoreInput);
		scoreInput.setBounds(100, 120, 80, 30);
		scoreInput.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(movesLeftInput);
		movesLeftInput.setBounds(100, 180, 80, 30);
		movesLeftInput.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		add(saveButton);
		saveButton.setBounds(0, 240, 150, 50);
		saveButton.setBorderPainted(false);
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SaveGame.saveBoardToXML();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		level.setOpaque(true);
		level.setBackground(Constants.GAME_BACKGROUND_COLOR);
		level.setForeground(Constants.TITLE_COLOR);
		
		target.setOpaque(true);
		target.setBackground(Constants.GAME_BACKGROUND_COLOR);
		target.setForeground(Constants.TITLE_COLOR);
		
		score.setOpaque(true);
		score.setBackground(Constants.GAME_BACKGROUND_COLOR);
		score.setForeground(Constants.TITLE_COLOR);
		
		movesLeft.setOpaque(true);
		movesLeft.setBackground(Constants.GAME_BACKGROUND_COLOR);
		movesLeft.setForeground(Constants.TITLE_COLOR);
		
		levelInput.setOpaque(true);
		levelInput.setBackground(Constants.GAME_BACKGROUND_COLOR);
		levelInput.setForeground(Constants.TITLE_COLOR);
		
		targetInput.setOpaque(true);
		targetInput.setBackground(Constants.GAME_BACKGROUND_COLOR);
		targetInput.setForeground(Constants.TITLE_COLOR);
		
		scoreInput.setOpaque(true);
		scoreInput.setBackground(Constants.GAME_BACKGROUND_COLOR);
		scoreInput.setForeground(Constants.TITLE_COLOR);
		
		movesLeftInput.setOpaque(true);
		movesLeftInput.setBackground(Constants.GAME_BACKGROUND_COLOR);
		movesLeftInput.setForeground(Constants.TITLE_COLOR);
		
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SaveGame.saveBoardToXML();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ApplicationWindow.removePanel(GamePanel.getInstance());
				ApplicationWindow.addPanel(MenuPanel.getInstance());
				MenuPanel.getInstance().requestFocusInWindow();
				MenuPanel.getInstance().repaint();
			}
		});
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		
    	level.repaint();
    	target.repaint();
    	score.repaint();
    	movesLeft.repaint();
    	
    	levelInput.repaint();
    	targetInput.repaint();
    	scoreInput.repaint();
    	movesLeftInput.repaint();
    	
    	saveButton.repaint();
	}
	
	public static InformationBoard getInstance(){
		if(instance==null){
			instance = new InformationBoard();
		}
		return instance;
	}
	
	public static void resetInstance(){
		instance = null;
	}

	public void updateScore(int currentScore) {
		this.currentScore = currentScore;
		scoreInput.setText(""+currentScore);
		if(this.currentScore==this.goalScore || this.currentScore>this.goalScore){
			GameOverPanel.getInstance().setWin(true);
			GamePanel.getInstance().endGame();			
		}
	}
	
	public void decreaseMoves(){
		this.moves--;
		movesLeftInput.setText(""+moves);
		if(moves==0){
			GameOverPanel.getInstance().setWin(false);
			GamePanel.getInstance().endGame();			
		}
	}
	
	public void setCurrentLevel(int currentLevel){
		this.currentLevel = currentLevel;
		levelInput.setText(""+currentLevel);
	}
	
	public int getCurrentLevel(){
		return Integer.parseInt(levelInput.getText());
	}
	
	public void setCurrentScore(int currentScore){
		this.currentScore = currentScore;
		scoreInput.setText(""+currentScore);
	}
	
	public int getCurrentScore(){
		return this.currentScore;
	}
	
	public void setMovesLeft(int moves){
		this.moves = moves;
		movesLeftInput.setText(""+moves);
	}
	
	public int getMovesLeft(){
		return this.moves;
	}

	public void setGoalScore(int goalScore) {
		this.goalScore = goalScore;
		targetInput.setText(""+goalScore);
	}

	public int getGoalScore() {
		return goalScore;
	}
}