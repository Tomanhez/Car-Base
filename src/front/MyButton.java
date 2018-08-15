package front;

import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {
	public MyButton(String n) {
		super(n);
		Font font = new Font("serif",Font.BOLD,25);
		this.setFont(font);
	}
}
