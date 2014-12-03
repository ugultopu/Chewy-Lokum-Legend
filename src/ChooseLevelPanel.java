
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ChooseLevelPanel extends JPanel {
	
	private JLabel label;
	private ChooseLevelPanel instance;
	private int numberOfLevels;
	
	private ChooseLevelPanel() {
		
		label = new JLabel("Choose Level",JLabel.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 50));
		label.setForeground(Constants.TITLE_COLOR);
		numberOfLevels = 5;		

		setLayout(new GridBagLayout());
		setBackground(Constants.GAME_BACKGROUND_COLOR);
		setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		GridBagConstraints c = new GridBagConstraints();

		c.gridx= 0;
		c.gridy= 0;
		c.insets = new Insets(10,10,10,10);		
		add(label, c);
		
		int counterX = 0;
		int counterY = 1;
		
		for(int n=1;n<numberOfLevels+1;n++){
			
			if(n%3 == 0){
				counterX=0;
				counterY++;
			}
			
			c.gridx= counterX;
			c.gridy= counterY;
			
			JButton newButton = new JButton("Level " + n);
			add(newButton,c);
			
//			add ActionListeners
			
			counterX++;
		}
	}
	
	public ChooseLevelPanel getInstance(){
		if(instance==null){
			instance = new ChooseLevelPanel();
		}
		return instance;
	}
	
	public void resetInstance(){
		instance = null;
	}	
}
