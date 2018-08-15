package front;

import java.awt.Font;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {
	public MyJLabel(String n) {
		super(n);
		Font font = new Font("serif",Font.BOLD,28);
		this.setFont(font);
	}
}
