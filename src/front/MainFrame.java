package front;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		super("Komis - Baza");
		
		add(new MainPanel());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
