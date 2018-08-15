package front;

import java.awt.Font;

import javax.swing.JTextField;

public class MyJTextField extends JTextField {
	public MyJTextField(int e) {
		super(e);
		Font font = new Font("serif",Font.BOLD,25);
		this.setFont(font);
	}
}
