package App;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationBoard extends JPanel {
	private JLabel level,target,score,movesLeft,levelInput,targetInput,scoreInput,movesLeftInput;
	private JButton saveButton;
	private int currentScore;
	private int goalScore;
	private int currentLevel;
	private static InformationBoard instance;

	public InformationBoard(){
		
		level = new JLabel("Level");
		target = new JLabel("Lines");
		score = new JLabel("Score");
		movesLeft = new JLabel("Moves");
		levelInput = new JLabel("");
		targetInput = new JLabel("0");
		scoreInput = new JLabel("0");
		movesLeftInput = new JLabel("0");
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
		
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		
//		levelInput.setText(""+scoreCalculator.getLevel());
//		linesInput.setText(""+scoreCalculator.getLinesDeleted());
//		scoreInput.setText(""+scoreCalculator.getScore());
		
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
		scoreInput.setText(""+currentScore);
	}
	
	public void setCurrentLevel(int currentLevel){
		levelInput.setText(""+currentLevel);
	}	
	
	public int getCurrentLevel(){
		return Integer.parseInt(levelInput.getText());
	}
}
