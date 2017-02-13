package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vector2UIWrapper extends JPanel{
	private static final long serialVersionUID = 4718084293292900561L;
	
	private JLabel label;
	private JTextField X, Y;
	
	public Vector2UIWrapper(String labelText, Vector2 defaultSettings, Dimension dimenstions){
		if(labelText == null){
			label = new JLabel("");
		}else{
			label = new JLabel(labelText);
		}
		
		if(defaultSettings == null){
			X = new JTextField("0");
			Y = new JTextField("0");
		}else{
			X = new JTextField("" + defaultSettings.x);
			Y = new JTextField("" + defaultSettings.y);
		}
		
		if(dimenstions == null){
			label.setPreferredSize(new Dimension(150,50));
			X.setPreferredSize(new Dimension(200,40));
			Y.setPreferredSize(new Dimension(200, 40));
		}else{
			label.setPreferredSize(dimenstions);
			X.setPreferredSize(dimenstions);
			Y.setPreferredSize(dimenstions);
		}
		
		setLayout(new FlowLayout());
		
		add(label);
		add(X);
		add(Y);
	}
	
	private int getValue(JTextField field){
		try{
			return Integer.parseInt(field.getText());
		}catch(Exception ex){
			field.setText("");
			throw new IllegalArgumentException("Non-Integer values not allowed on JTextField " + field.getName());
		}
	}
	
	public Vector2 getVector(){
		return new Vector2(getValue(X),getValue(Y));
	}
}