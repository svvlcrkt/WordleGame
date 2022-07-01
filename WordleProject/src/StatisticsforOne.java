

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsforOne extends JFrame{
	JPanel Player1=new JPanel();

	JPanel Info1= new JPanel();

	JLabel title = new JLabel("Most Frequently used 5 letters for Player");

	String Player1data = System.getProperty("user.dir");
	String Player1csv=Player1data+"/src/Player.csv";

	MyComponent FirstPlayer=new MyComponent(IntroPart.Player,Player1csv);

	JLabel First[]= new JLabel[10];
	JLabel Second[]= new JLabel[5];
	JPanel center= new JPanel();
	
	public StatisticsforOne() {
		// TODO Auto-generated constructor stub
		super("Statistics");
		//setLayout(new BorderLayout());
		setLayout(new GridLayout(2,1));
		setSize(400, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		Player1.setLayout(new GridLayout(1,2));

		add(title);
		//add(center,BorderLayout.CENTER);
		//center.setLayout(new GridLayout(2,1));
		add(Player1);

		//center.add(Player1);
		//center.add(Player2);
		Info1.setLayout(new GridLayout(5,1));

		String Player1data = System.getProperty("user.dir");
		String Player1csv=Player1data+"/src/Player1.csv";

		Player1.add(FirstPlayer);
		Player1.add(Info1);
		for (int i = 0; i < 5; i++) {
			First[i]= new JLabel(String.valueOf(FirstPlayer.letters[i])+"    "+String.format("%.2f", FirstPlayer.percentage[i])+"%");
			First[i].setBackground(FirstPlayer.colors[i]);
			First[i].setOpaque(true);
			Info1.add(First[i]);

			
		}

		
	}
	public static void main(String[] args) {
		Statistics i = new Statistics();
	}

}
