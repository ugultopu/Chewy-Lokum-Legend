import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {
	protected MenuPanel menu;
	protected GamePanel game;
	protected static ApplicationWindow instance;

	public ApplicationWindow() {
		super("TestisCrush");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(game!=null){
					game.running=false;
				}
				System.exit(0);
			}
		});
		
		setLayout(new GridLayout(1,1));
		setVisible(true);
		setResizable(false);
		
		menu = MenuPanel.getInstance();
		
		add(menu);
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
}