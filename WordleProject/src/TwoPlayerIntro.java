import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TwoPlayerIntro extends JFrame implements ActionListener {
	Color myGreen = new Color(119, 170, 95, 255);
	Color myBlue = new Color(30, 129, 176, 255);
	Color myOrange = new Color(226, 135, 67, 255);
	JTextField Player1;
	JTextField Player2;
	JLabel first;
	JLabel second;
	JButton ok;
	public static Player FirstPlayer=new Player();
	public static Player SecondPlayer=new Player();

	public TwoPlayerIntro(){
		super("WORDLE GAME");
		setSize(750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(myGreen);
		first=new JLabel("Player 1 Enter Your Name");
		Player1 = new JTextField();
		second=new JLabel("Player 2 Enter Your Name");
		Player2 = new JTextField();
		ok=new JButton("OK");
		first.setBounds(250, 100, 200, 50);
		Player1.setBounds(250, 150, 200, 50);
		//Player1.setBackground(myOrange);
		//Player1.addActionListener(this);
		second.setBounds(250, 200, 200, 50);
		Player2.setBounds(250, 250, 200, 50);
		ok.setBounds(250, 300, 200, 50);
		ok.addActionListener(this);
		//Player2.setBackground(myBlue);
		//Player2.addActionListener(this);
		add(first);
		add(Player1);
		add(second);
		add(Player2);
		add(ok);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			FirstPlayer.setName(Player1.getText());
			SecondPlayer.setName(Player2.getText());
			IntroPartTwo i = new IntroPartTwo();
			setVisible(false);
		}


	}
}
