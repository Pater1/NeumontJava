package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorWindow extends JFrame{
	private static final long serialVersionUID = 2078102684083347496L;
	
	private JLabel message;
	private JButton okay;
	
	public ErrorWindow(String message, boolean includeButton){
		if(message == null) throw new IllegalArgumentException("message required");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.message = new JLabel(message);
		add(this.message);
		
		if(includeButton){
			this.okay = new JButton("Okay"){
			private static final long serialVersionUID = -4351183024138249319L;
			{
				addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					}
				);
			}};
			
			add(okay);
		}
	}
}
