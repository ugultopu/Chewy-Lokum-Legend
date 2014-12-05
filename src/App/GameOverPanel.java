package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameOverPanel extends JPanel{

	private static GameOverPanel instance;
	private JLabel gameOver,victory;
	private JButton replay, nextLevel, mainMenu;
	private boolean win;

	public GameOverPanel(){

		victory = new JLabel("Victory!");
		gameOver = new JLabel("Game Over"); 
		nextLevel = new JButton("Next Level");
		replay = new JButton("Replay");
		mainMenu= new JButton("Main Menu");

		if (win==true){
			add(victory);
			victory.setBounds(0, 50, 360, 60);
			victory.setForeground(Color.BLACK);
			victory.setFont(new Font("Tahoma", Font.BOLD, 40));
			victory.setHorizontalAlignment(SwingConstants.CENTER);

			add(nextLevel);
			nextLevel.setBounds(40, 200, 130, 50);
			nextLevel.setBorderPainted(false);
			nextLevel.setFocusPainted(false);
		}

		if (win==false){
			add(gameOver);
			gameOver.setBounds(0, 50, 360, 60);
			gameOver.setForeground(Color.BLACK);
			gameOver.setFont(new Font("Tahoma", Font.BOLD, 40));
			gameOver.setHorizontalAlignment(SwingConstants.CENTER);

			add(replay);
			replay.setBounds(40, 200, 130, 50);
			replay.setBorderPainted(false);
			replay.setFocusPainted(false);
		}

		add(mainMenu);
		mainMenu.setBounds(190, 200, 130, 50);
		mainMenu.setBorderPainted(false);
		mainMenu.setFocusPainted(false);

		replay.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				InformationBoard.getInstance().setCurrentLevel(InformationBoard.getInstance().getCurrentLevel());				
				ApplicationWindow.removePanel(GamePanel.getInstance());
				ApplicationWindow.addPanel(GamePanel.getInstance());
				GamePanel.getInstance().requestFocusInWindow();
				GamePanel.getInstance().startGame();
				GamePanel.getInstance().repaint();
			}

		});

		nextLevel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				InformationBoard.getInstance().setCurrentLevel(InformationBoard.getInstance().getCurrentLevel()+1);
				ApplicationWindow.removePanel(GamePanel.getInstance());
				ApplicationWindow.addPanel(GamePanel.getInstance());
				GamePanel.getInstance().requestFocusInWindow();
				GamePanel.getInstance().startGame();
				GamePanel.getInstance().repaint();
			}

		});


		mainMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationWindow.removePanel(GamePanel.getInstance());
				ApplicationWindow.addPanel(MenuPanel.getInstance());
				MenuPanel.getInstance().repaint();
			}
		});

		repaint();
	}

	public void setWin(boolean result){
		if(result==true)
		this.win=true;
		else
		this.win=false;
	}
	
	public boolean getWinState(){
		return this.win;
	}
	
	public static GameOverPanel getInstance(){
		if(instance==null){
			instance = new GameOverPanel();
		}
		return instance;
	}
	
	public static void resetInstance(){
		instance = new GameOverPanel();
	}	
}
