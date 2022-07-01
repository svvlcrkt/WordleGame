

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Statistics extends JFrame{
	JPanel Player1=new JPanel();
	JPanel Player2= new JPanel();
	JPanel Info1= new JPanel();
	JPanel Info2= new JPanel();
	JLabel title = new JLabel("Most Frequently used 5 letters for Player 1");
	JLabel title2 = new JLabel("Most Frequently used 5 letters for Player 2");
	String Player1data = System.getProperty("user.dir");
	String Player1csv=Player1data+"/src/Player1.csv";
	String Player2data = System.getProperty("user.dir");
	String Player2csv=Player2data+"/src/Player2.csv";
	MyComponent FirstPlayer=new MyComponent(TwoPlayerIntro.FirstPlayer,Player1csv);
	MyComponent SecondPlayer =new MyComponent(TwoPlayerIntro.SecondPlayer,Player2csv);
	JLabel First[]= new JLabel[10];
	JLabel Second[]= new JLabel[5];
	JPanel center= new JPanel();
	
	public Statistics() {
		// TODO Auto-generated constructor stub
		super("Statistics");
		//setLayout(new BorderLayout());
		setLayout(new GridLayout(4,1));
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		Player1.setLayout(new GridLayout(1,2));
		Player2.setLayout(new GridLayout(1,2));
		add(title);
		//add(center,BorderLayout.CENTER);
		//center.setLayout(new GridLayout(2,1));
		add(Player1);
		add(title2);
		add(Player2);
		//center.add(Player1);
		//center.add(Player2);
		Info1.setLayout(new GridLayout(5,1));
		Info2.setLayout(new GridLayout(5,1));
		String Player1data = System.getProperty("user.dir");
		String Player1csv=Player1data+"/src/Player1.csv";
		String Player2data = System.getProperty("user.dir");
		String Player2csv=Player2data+"/src/Player2.csv";
		Player1.add(FirstPlayer);
		Player1.add(Info1);
		for (int i = 0; i < 5; i++) {
			First[i]= new JLabel(String.valueOf(FirstPlayer.letters[i])+"    "+String.format("%.2f", FirstPlayer.percentage[i])+"%");
			First[i].setBackground(FirstPlayer.colors[i]);
			First[i].setOpaque(true);
			Info1.add(First[i]);

			
		}
		Player2.add(SecondPlayer);
		Player2.add(Info2);
		for (int i = 0; i < 5; i++) {
			Second[i]= new JLabel(String.valueOf(SecondPlayer.letters[i])+"    "+String.format("%.2f", SecondPlayer.percentage[i])+"%");
			Second[i].setBackground(SecondPlayer.colors[i]);
			Second[i].setOpaque(true);
			Info2.add(Second[i]);

			
		}
		
	}
	public static void main(String[] args) {
		Statistics i = new Statistics();
	}

}
