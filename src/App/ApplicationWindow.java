package App;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationWindow extends JFrame {
	
	protected static GamePanel game;
	protected static ApplicationWindow instance;

	public ApplicationWindow() {
		super("TestisCrush");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setLayout(new GridLayout(1,1));
		setVisible(true);
		setResizable(false);
		
		game = GamePanel.getInstance();
		
		add(game);
	}
	
	public static ApplicationWindow getInstance(){
		if(instance==null){
			instance = new ApplicationWindow();
		}
		return instance;
	}
	
	public void resetInstance(){
		instance = null;
	}
	
	public static void addPanel(JPanel panel){
		instance.add(panel);
	}
	
	public static void removePanel(JPanel panel){
		instance.remove(panel);
	}
	
}