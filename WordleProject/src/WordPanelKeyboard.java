import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class WordPanelKeyboard extends JPanel{
        JLabel[] wordColumns= new JLabel[5];
        public WordPanelKeyboard(){
            this.setLayout(new GridLayout(1,5) );
            Border blackBorder =BorderFactory.createLineBorder(Color.lightGray);
            for(int i=0;i<5;i++){
                wordColumns[i]= new JLabel();
                wordColumns[i].setText("");
                wordColumns[i].setHorizontalAlignment(JLabel.CENTER);
                wordColumns[i].setOpaque(true);
                wordColumns[i].setBorder(blackBorder);
            
                this.add(wordColumns[i]);
            }
        }
        public void setPanelText(String charValue,int position, Color color){
            this.wordColumns[position].setText(charValue);
            this.wordColumns[position].setBackground(color);
        }
        
        public void clearWordPanel() {
        	for(int i=0;i<5;i++) {
        		wordColumns[i].setText("");
        	}
        }
        
    }