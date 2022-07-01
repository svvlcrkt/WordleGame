import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class TextPanel extends JPanel{
    	public JTextField text;
    	public TextPanel() {
    		this.setLayout(new GridLayout(1,1));
    		text=new JTextField();
    		
    		//text.setVisible(true);
    		this.add(text);
    	}
    }