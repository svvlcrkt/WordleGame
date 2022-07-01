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
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

public class WordleGameK implements ActionListener{
	Color myGreen = new Color(119,170,95,255);
	Color myYellow = new Color(197,180,74,255);
	Color myGray = new Color(121,124,126,255);
    private JFrame gameFrame;
    private WordPanelKeyboard[] WordPanelArray = new WordPanelKeyboard[5];
    public UserPanelKeyboard userPanel;
    public TextPanel textPanel;
    public WordPanelKeyboard wordPanel;
    public TimerPart timerPart;
    public AnimationPart animationPart;
    
    public CsvWriter player1;
    public CsvReader Reader1;

 
   

//    static int score;
    private String wordleString;
    private int count=0;
    public int visitorPage=0;
   


    public WordleGameK(){

        gameFrame= new JFrame("Wordle Game");
        gameFrame.setSize(750, 600);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new GridLayout(8,1));
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        timerPart=new TimerPart();

        gameFrame.add(timerPart.counterLabel);

        for(int i=0; i<5;i++){
            WordPanelArray[i]= new WordPanelKeyboard();
            gameFrame.add(WordPanelArray[i]);
        }

        textPanel=new TextPanel();
        gameFrame.add(textPanel);
        userPanel= new UserPanelKeyboard();
        userPanel.getOkButton().addActionListener(this);
        int n= userPanel.st.length;
        for(int i=0;i<n;i++) {
        	userPanel.buttonList[i].addActionListener(this);
        }
        
        userPanel.getBackspace().addActionListener(this);
        userPanel.getVisButton().addActionListener(this);
        gameFrame.add(userPanel);
        gameFrame.revalidate();
        
        wordleString=getWordleString();
        VisitorPage.getWordleWord(wordleString);
        System.out.println("Word for the day: "+ wordleString);
        try {
			String wordsDirectory = System.getProperty("user.dir");
			Path wordsPath=Paths.get(wordsDirectory+"/src/wordsTried.txt");
			FileWriter wordsTriedWriter = new FileWriter (String.valueOf(wordsPath));
			PrintWriter pw = new PrintWriter(wordsTriedWriter);
			pw.write("");
			pw.flush();
			pw.close();
			wordsTriedWriter.close();
		} catch (IOException wtw) {
			// TODO Auto-generated catch block
			wtw.printStackTrace();
		}
    }
    //public static void main(String[] args) {

      //  new WordleGameK();
    //}
    @Override
	public void actionPerformed(ActionEvent e) {
    	
		int n= userPanel.st.length;
		if(userPanel.buffer.length()>5) {
			textPanel.text.setText("");
			userPanel.buffer="";
			JOptionPane.showMessageDialog(null, "You cant enter more than 5 letters", "Warning !!", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else {
			
			if(e.getSource()==userPanel.getOkButton()) {

				
				String userWord=this.textPanel.text.getText();		
				
				
				String upperUserWord=userWord.toUpperCase();
				char array[]=upperUserWord.toCharArray();
				String WordArray[]=userWord.split("");
				
				String Player1data = System.getProperty("user.dir");
				String Player1csv=Player1data+"/src/Player.csv";
				
				Reader1=new CsvReader(Player1csv);
				
				String ReaderArray[]=Reader1.dataLine.split(",");
				int value[]= new int[ReaderArray.length];
				for (int i = 0; i < IntroPart.Player.getKeyboardData().letters.length; i++) {
					value[i]=Integer.parseInt(ReaderArray[i]);
					IntroPart.Player.getKeyboardData().numbers[i]=value[i];
				}
				
				
				
				for(int i=0;i<WordArray.length;i++) {
					for (int j = 0; j < IntroPart.Player.getKeyboardData().letters.length; j++) {
						if(IntroPart.Player.getKeyboardData().letters[j]==array[i]) {
							IntroPart.Player.getKeyboardData().numbers[j]++;
						}
					}
					
				}
				System.out.println("Player  keyboard data");
				for (int i = 0; i < IntroPart.Player.getKeyboardData().letters.length; i++) {
					
					System.out.println(IntroPart.Player.getKeyboardData().letters[i]+" "+IntroPart.Player.getKeyboardData().numbers[i]);
					

				}

				player1= new CsvWriter(Player1csv);
				for (int i = 0; i < IntroPart.Player.getKeyboardData().letters.length; i++) {			
					player1.add(Player1csv,IntroPart.Player.getKeyboardData().numbers[i]);

				}
				player1.sb.append("\n");
				
				System.out.println("\n\n");
				
				
				
				
				try {
					if(upperUserWord.length()==5) {
						String wordsDirectory = System.getProperty("user.dir");
						Path wordsPath=Paths.get(wordsDirectory+"/src/wordsTried.txt");
						FileWriter wordWriter = new FileWriter (String.valueOf(wordsPath) , true);
						wordWriter.write(String.valueOf(upperUserWord.trim()));
						wordWriter.write(System.lineSeparator());
						wordWriter.close();
					}
					
				}
				catch(IOException s) {
					s.printStackTrace();

				}
				
				if(userWord.length()==5) {
					if(visitorPage>0) {
						VisitorPage.getUserWord(upperUserWord);
					}
					if(isWordleWordEqualTo(userWord.trim().toUpperCase())){
						clearAllPanels();
						timerPart.timer.stop();
						WordleGameDD.score=1000;
						WordleGameDD.score = WordleGameDD.score- (timerPart.minute*60)- timerPart.second - (count*10);

						//JOptionPane.showMessageDialog(null, "You WON !!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
						
						System.out.println(WordleGameDD.score);
						try {
							String scoreDirectory = System.getProperty("user.dir");
							Path scorePath=Paths.get(scoreDirectory+"/src/Scores.txt");
							FileWriter scoreWriter = new FileWriter (String.valueOf(scorePath) , true);
							scoreWriter.write(String.valueOf(WordleGameDD.score));
							scoreWriter.write(System.lineSeparator());
							scoreWriter.close();
						}
						catch(IOException s) {
							s.printStackTrace();

						}
						try {
							String highScoreDirectory = System.getProperty("user.dir");
							Path highScorePath=Paths.get(highScoreDirectory+"/src/HighScore.txt");
					      File highScore = new File(String.valueOf(highScorePath));
						      Scanner scoreReader = new Scanner(highScore);
						      String hScore = scoreReader.nextLine();
						      
						      scoreReader.close();
						      if(WordleGameDD.score>Integer.valueOf(hScore)) {
						    	  try {
						    		 
									FileWriter hsw = new FileWriter (String.valueOf(highScorePath));
									PrintWriter pw = new PrintWriter(hsw);
									pw.write("");
									pw.flush();
									pw.close();
									hsw.close();
									FileWriter hSWriter= new FileWriter(String.valueOf(highScorePath), true);
									hSWriter.write(String.valueOf(WordleGameDD.score));
									hSWriter.close();
								} catch (IOException hsw) {
									hsw.printStackTrace();
								}
						      }
						      
						    } catch (FileNotFoundException hs) {
						      System.out.println("An error occurred.");
						      hs.printStackTrace();
						    }
						try {
							animationPart = new AnimationPart();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						gameFrame.dispose();
						if(visitorPage>0) {
							VisitorPage.gameFrame.dispose();
						}
						return;
					}
				}
				if(userWord.length()<5) {
					textPanel.text.setText("");
					userPanel.buffer="";
					JOptionPane.showMessageDialog(null, "You cant enter less than 5 letters", "Warning !!", JOptionPane.INFORMATION_MESSAGE);
					count--;
						
					
				}
				if(userWord.length()>5) {
					textPanel.text.setText("");
					userPanel.buffer="";
					JOptionPane.showMessageDialog(null, "You cant enter more than 5 letters", "Warning !!", JOptionPane.INFORMATION_MESSAGE);
					count--;
					
				}

				if(count>=4) {
					timerPart.timer.stop();
					JOptionPane.showMessageDialog(null, "You Lost!! Better Luck Next Time", "OOPS", JOptionPane.INFORMATION_MESSAGE);
					
					gameFrame.dispose();
					if(visitorPage>0) {
						VisitorPage.gameFrame.dispose();
					}
					return;			
				}
				count++;
				textPanel.text.setText("");
				userPanel.buffer="";
			}
			
			else if(e.getSource()==userPanel.getBackspace()) {
				userPanel.buffer=userPanel.buffer.substring(0,userPanel.buffer.length()-1);
				textPanel.text.setText(""+userPanel.buffer);
			}
			//else if(e.getSource()==userPanel.getPlayButton()) {
			//	try {
			//		timerPart.timer.stop();
			//		JOptionPane.showMessageDialog(null, "Game will start in a few seconds...", "You picked player mode", JOptionPane.INFORMATION_MESSAGE);
			//		Thread.sleep(3000);  
			//		gameFrame.getContentPane().removeAll();
//			//		gameFrame.dispose();
			//		new WordleGameK();
			//	}
			//	catch(InterruptedException ex)
			   //   {
			      //    ex.printStackTrace();
			   //   }
				


			//}
			
			else if(e.getSource()==userPanel.getVisButton() ) {
				try {
					JOptionPane.showMessageDialog(null, "You can watch other players", "You picked visitor mode", JOptionPane.INFORMATION_MESSAGE);
					Thread.sleep(1000);  
					new VisitorPage();
					visitorPage=1;
					VisitorPage.getTimerValues(timerPart.minute, timerPart.second);
					VisitorPage.previousWords();
				}
				catch(InterruptedException ex)
			      {
			          ex.printStackTrace();
			      }
			}
		

			else {
				
					for(int i=0;i<n;i++) {
						if(e.getSource()==userPanel.buttonList[i]) {
							userPanel.buffer+=userPanel.st[i];
							textPanel.text.setText(""+userPanel.buffer);
							
							break;
						}
					}					
				

			}
		}


	}
	
	private void clearAllPanels() {
		for(int i=0;i<count;i++) {
			WordPanelArray[i].clearWordPanel();
		}
	}
	private boolean isWordleWordEqualTo(String userWord ) {
		List<String> wordleWordsList=Arrays.asList(wordleString.split(""));
		String[] userWordsArray= userWord.split("");
		List<Boolean> wordMatchList= new ArrayList<>();
		
		for(int i=0; i<5;i++) {
			if(wordleWordsList.contains(userWordsArray[i])) {
				if(wordleWordsList.get(i).equals(userWordsArray[i])) {
					getActivePanel().setPanelText(userWordsArray[i], i, myGreen);
					wordMatchList.add(true);
					for(int j=0; j<26; j++) {
//						System.out.println(userPanel.buttonList[j].getText());
						if(userPanel.buttonList[j].getText().equals(userWordsArray[i])) {
//							System.out.println(242);
							userPanel.buttonList[j].setBackground(myGreen);
						}
					}
				}
				else {
					getActivePanel().setPanelText(userWordsArray[i], i, myYellow);
					wordMatchList.add(false);
					for(int j=0; j<26; j++) {
						if(userPanel.buttonList[j].getText().equals(userWordsArray[i])) {
							userPanel.buttonList[j].setBackground(myYellow);
						}
					}
				}
			}
			else {
				getActivePanel().setPanelText(userWordsArray[i], i, myGray);

				wordMatchList.add(false);
				for(int j=0; j<26; j++) {
					if(userPanel.buttonList[j].getText().equals(userWordsArray[i])) {	
						userPanel.buttonList[j].setBackground(myGray);
					}
				}
			}
		}
		return !wordMatchList.contains(false);
	}
	public WordPanelKeyboard getActivePanel() {
		return this.WordPanelArray[count];
	}
	public String getWordleString() {
		String userDirectory = System.getProperty("user.dir");
        Path path=Paths.get(userDirectory+"/src/wordleWords.txt");
		List<String> wordList=new ArrayList<>();
		try {
			wordList=Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random random= new Random();
		int position = random.nextInt(wordList.size() ); 
		return wordList.get(position).trim().toUpperCase();
	}

	
}