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

public class OptionIntro extends JFrame implements ActionListener {
	Color myGreen = new Color(119, 170, 95, 255);
	Color myBlue = new Color(30, 129, 176, 255);
	Color myOrange = new Color(226, 135, 67, 255);
	JButton jbdragDrop;
	JButton jbkeyboard;



	public OptionIntro() {
		super("WORDLE GAME");
		setLayout(null);
		getContentPane().setBackground(myGreen);
		jbdragDrop = new JButton("1 Player");
		jbkeyboard = new JButton("2 Player");
		jbdragDrop.setBounds(250, 200, 200, 50);
		jbdragDrop.setBackground(myOrange);
		jbdragDrop.addActionListener(this);
		jbkeyboard.setBounds(250, 300, 200, 50);
		jbkeyboard.setBackground(myBlue);
		jbkeyboard.addActionListener(this);

		add(jbdragDrop);
		add(jbkeyboard);
	}

	public static void main(String[] args) {

		OptionIntro i = new OptionIntro();
		i.setSize(750, 600);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setVisible(true);
		i.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbdragDrop) {
			IntroPart wd = new IntroPart();
			setVisible(false);
		}
		if (e.getSource() == jbkeyboard) {
			TwoPlayerIntro wk = new TwoPlayerIntro();
			setVisible(false);
		}


	}
}
