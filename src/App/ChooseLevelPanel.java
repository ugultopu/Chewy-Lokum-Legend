package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ChooseLevelPanel extends JPanel {
	
	private JLabel label;
	private static ChooseLevelPanel instance;
	private int numberOfLevels;
	
	private ChooseLevelPanel() {
		
		label = new JLabel("Choose Level",JLabel.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setForeground(Constants.TITLE_COLOR);
		numberOfLevels = 20;		

		setLayout(new GridBagLayout());
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		GridBagConstraints c = new GridBagConstraints();

		c.gridx= 0;
		c.gridy= 0;
		c.insets = new Insets(30,30,30,30);		
//		add(label, c);
		
		int counterX = 0;
		int counterY = 0;
		
		for(int n=0;n<numberOfLevels;n++){
			
			if(n%4 == 0){
				counterX=0;
				counterY++;
			}
			
			c.gridx= counterX;
			c.gridy= counterY;
			
			JButton newButton = new JButton("Level " + (n + 1));
			add(newButton,c);
			
//			add ActionListeners
			
			counterX++;
		}
	}
	
	public static ChooseLevelPanel getInstance(){
		if(instance==null){
			instance = new ChooseLevelPanel();
		}
		return instance;
	}
	
	public void resetInstance(){
		instance = null;
	}	
}
