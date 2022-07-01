import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

class UserPanelKeyboard extends JPanel{

        //private JTextField userInput;
        private JButton okButton;
        private JButton visButton;
        private JButton playButton;
        public JButton backspace;
        public String st[]={"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
		public JButton buttonList[];
		public String buffer="";
		//public JTextField playerText;
		//public JTextField visitorText;

        

        public UserPanelKeyboard(){
            this.setLayout(new GridLayout(3,9));
            
            //userInput= new JTextField();
            //userInput.setVisible(true);
            okButton=new JButton("Ok");
            //playButton= new JButton("Player");
            visButton=new JButton("Visitor");
            //okButton.setVisible(true);
            //this.add(userInput);
            
			int n=st.length;
			buttonList=new JButton[n];
		
			for(int i=0;i<n;i++) {
				buttonList[i]= new JButton(""+st[i]);
				buttonList[i].setOpaque(true);
				
	            
				add(buttonList[i]);
				
				}

			
		
			backspace= new JButton("DEL");
			add(backspace);
			this.add(okButton);
			//this.add(playButton);
			this.add(visButton);
			
			
        }
        
        public JButton getBackspace() {
			return backspace;
		}

		public void setBackspace(JButton backspace) {
			this.backspace = backspace;
		}



		//public JTextField getUserInput(){
            //return userInput;
        //}
        //public void setUserInput(JTextField userInput) {
			//this.userInput = userInput;
		//}

		public JButton getOkButton(){
            return okButton;
        }
		
		//public JButton getPlayButton(){
          //  return playButton;
        //}
		public JButton getVisButton(){
            return visButton;
        }
    } 