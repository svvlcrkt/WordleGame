import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Date; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisitorPage implements ActionListener{
	static Color myGreen = new Color(119,170,95,255);
	static Color myYellow = new Color(197,180,74,255);
	static Color myGray = new Color(121,124,126,255);
	public static JFrame gameFrame;
    private static WordPanel[] WordPanelArray = new WordPanel[6];
    public VisPanel VisPanel;
    public TextPanel textPanel;
    public WordPanel wordPanel;
    public static TimerPart visTimerPart;
    public  String wordDrag="";
    public String deleteDrag="";
    public AnimationPart animationPart;
    public static String playerWord="";
    public static String wordleWord="";
    public static int count=0;
    
    class VisPanel extends JPanel{
    	
    	public JButton playButton;
    	
    	public VisPanel() {
    		playButton= new JButton("Player");
        	this.add(playButton);
    	}
    	public JButton getPlayButton(){
            return playButton;
        }
    	
    }



	public VisitorPage() {
		gameFrame= new JFrame("Wordle Game Visitor Mode");
        gameFrame.setSize(750, 600);
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setLayout(new GridLayout(7,1));
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        visTimerPart = new TimerPart();
        gameFrame.add(visTimerPart.counterLabel);
        for(int i=0; i<5;i++){
            WordPanelArray[i]= new WordPanel();
            gameFrame.add(WordPanelArray[i]);
        }
        
        VisPanel= new VisPanel();
        VisPanel.getPlayButton().addActionListener(this);

        gameFrame.add(VisPanel);
        gameFrame.revalidate();

	}
	
	public static void getUserWord(String word) {
		playerWord=word;
		isWordleWordEqualTo(playerWord);
		count++;
	}
	public static void previousWords() {
		try {
			String prevWordsDirectory = System.getProperty("user.dir");
			Path prevWordsPath=Paths.get(prevWordsDirectory+"/src/wordsTried.txt");
	      File prevWord = new File(String.valueOf(prevWordsPath));
	      Scanner wordReader = new Scanner(prevWord);
	      
	      while(wordReader.hasNextLine()) {
	    	  String triedWord = wordReader.nextLine();
	    	  isWordleWordEqualTo(triedWord);
	    	  count++;
	      }
	      
	      wordReader.close();
		}
	 catch (FileNotFoundException hs) {
	      System.out.println("An error occurred.");
	      hs.printStackTrace();
	    }
	     
	      
	}
	public static void getTimerValues( int min, int sec) {
		visTimerPart.minute=min;
		visTimerPart.second=sec;
	}
	public static void getWordleWord(String word) {
		wordleWord=word;
	}

	
	private static boolean isWordleWordEqualTo(String playerWord ) {
		List<String> wordleWordsList=Arrays.asList(wordleWord.split(""));
		String[] userWordsArray= playerWord.split("");
		List<Boolean> wordMatchList= new ArrayList<>();
		
		for(int i=0; i<5;i++) {
			if(wordleWordsList.contains(userWordsArray[i])) {
				if(wordleWordsList.get(i).equals(userWordsArray[i])) {
					getActivePanel().setPanelText(userWordsArray[i], i, myGreen);
					wordMatchList.add(true);
				}
				else {
					getActivePanel().setPanelText(userWordsArray[i], i, myYellow);
					wordMatchList.add(false);
					
				}
			}
			else {
				getActivePanel().setPanelText(userWordsArray[i], i, myGray);

				wordMatchList.add(false);
			}
		}
		return !wordMatchList.contains(false);
	}
	public static WordPanel getActivePanel() {
		return VisitorPage.WordPanelArray[count];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==VisPanel.getPlayButton()) {
			try {
				visTimerPart.timer.stop();
				JOptionPane.showMessageDialog(null, "Game will start in a few seconds...", "You picked player mode", JOptionPane.INFORMATION_MESSAGE);
				Thread.sleep(3000);  
				gameFrame.getContentPane().removeAll();
				gameFrame.dispose();
				new IntroPart();
			}
			catch(InterruptedException ex)
		      {
		          ex.printStackTrace();
		      }
		}
		
	}
	

}
