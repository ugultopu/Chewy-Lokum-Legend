package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class LevelBoard extends JPanel {

	private JLabel label;
	private static LevelBoard instance;
	private int numberOfLevels = Constants.NUMBER_OF_LEVELS;

	private LevelBoard() {

		setLayout(new GridBagLayout());
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);

		GridBagConstraints c = new GridBagConstraints();

		c.gridx= 0;
		c.gridy= 0;
		c.insets = new Insets(30,30,30,30);		

		int counterX = 0;
		int counterY = 0;

		for(int n=0;n<numberOfLevels;n++){

			if(n%Constants.NUMBER_OF_COLUMNS == 0){
				counterX=0;
				counterY++;
			}

			c.gridx= counterX;
			c.gridy= counterY;

			JButton newButton = new JButton("Level " + (n + 1));
			add(newButton,c);
			counterX++;
			
			newButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
//				ADD LEVEL INFORMATION	
					ApplicationWindow.removePanel(ChooseLevelPanel.getInstance());
					ApplicationWindow.addPanel(GamePanel.getInstance());
					GameBoard.getInstance().requestFocusInWindow();
					GamePanel.getInstance().startGame();
					GamePanel.getInstance().repaint();
				}
			});
		}
	}

	public static LevelBoard getInstance(){
		if(instance==null){
			instance = new LevelBoard();
		}
		return instance;
	}

	public void resetInstance(){
		instance = null;
	}	
}