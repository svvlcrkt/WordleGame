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
import javax.swing.JPanel;

public class IntroPartTwo extends JFrame implements ActionListener {
	Color myGreen = new Color(119, 170, 95, 255);
	Color myBlue = new Color(30, 129, 176, 255);
	Color myOrange = new Color(226, 135, 67, 255);
	JButton jbdragDrop;
	JButton jbkeyboard;
	JButton statistics;
	public IntroPartTwo() {
		super("WORDLE GAME");
		setSize(750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(myGreen);
		jbdragDrop = new JButton("Choose Drag & Drop");
		jbkeyboard = new JButton("Choose Keyboard");
		jbdragDrop.setBounds(250, 200, 200, 50);
		jbdragDrop.setBackground(myOrange);
		jbdragDrop.addActionListener(this);
		jbkeyboard.setBounds(250, 300, 200, 50);
		jbkeyboard.setBackground(myBlue);
		jbkeyboard.addActionListener(this);
		statistics = new JButton("Statistics");
		statistics.setBounds(10, 10, 100, 50);
		statistics.addActionListener(this);
		add(statistics);
		add(jbdragDrop);
		add(jbkeyboard);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbdragDrop) {
			WordleGameDDTwo wd = new WordleGameDDTwo();
			setVisible(false);
		}
		if (e.getSource() == jbkeyboard) {
			WordleGameKTwo wk = new WordleGameKTwo();
			setVisible(false);
		}
		if (e.getSource() == statistics) {
			Statistics s = new Statistics();
		
			
		}

	}
}
