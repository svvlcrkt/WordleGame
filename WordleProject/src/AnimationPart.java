import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimationPart {

	static Color myColor = new Color(35, 145, 45, 127);

	public static void main(String[] args) throws IOException {
		AnimationPart animation = new AnimationPart();
	}
	
	public AnimationPart() throws IOException 
	{
		JFrame frame = new JFrame("CONGRATS! YOU WON THE GAME!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new Balls());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public class Balls extends JPanel
	{
		public Balls() throws IOException 
		{
			
			setLayout(null);
            add(new Ball(15, 5));
            add(new Ball(20, 15));
            add(new Ball(15, 25));
            add(new Ball(10, 10));
            add(new Ball(10, 5));
            add(new Ball(12, 10));
            add(new Ball(6, 8));
            add(new Ball(14, 11));
            add(new Ball(10, 30));
            add(new Ball(15, 15));
            add(new Ball(20, 22));
            add(new Ball(12, 5));
            add(new Ball(11, 11));
            add(new Ball(25, 23));
            add(new Ball(4, 10));
            add(new Ball(7, 12));
            add(new Ball(14, 25));
            add(new Ball(2, 10));
            String highScoreDirectory = System.getProperty("user.dir");
			Path highScorePath=Paths.get(highScoreDirectory+"/src/HighScore.txt");
            JLabel jHigh = new JLabel("High score is: " + Files.readString(highScorePath));
            JLabel jScore = new JLabel("Your score is: " + WordleGameDD.score);
            jHigh.setBounds(200,100,200,100);
            jScore.setBounds(200,120,200,100);
            add(jHigh);
            add(jScore);
		}
	}
	
	public class Ball extends JComponent implements Runnable{
		Color color;
		int diameter;
		long delay;
		private int x, y;
		Random rand = new Random();
		int r = (int) Math.round(Math.random() * 255);
		int g = (int) Math.round(Math.random() * 255);
		int b = (int) Math.round(Math.random() * 255);
		Color randomColor = new Color(r, g, b, 127);

		
		public Ball(int xV, int yV) {
			
			diameter = 40;
			delay = 100;
			x = xV;
			y = yV;
			color = randomColor;
			new Thread(this).start();
		}
		
		
		@Override
        public Dimension getPreferredSize() {
            return new Dimension(40, 40);
        }
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(color);
            g.fillArc(0, 0, 40, 40, 0, 360); 
            
		}

		public void run() {

            while (isVisible()) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("");
                }

                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            moveBalls();
                            repaint();
                        }
                    });
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                } catch (InvocationTargetException exp) {
                    exp.printStackTrace();
                }
            }
        }
		public void moveBalls() {

            int xP = getX();
            int yP = getY();
//          System.out.println(xP);
//          System.out.println(yP);

            if ((xP + diameter + x) > getParent().getWidth() || (xP + x) < 0) {
                x = x * -1;
            }
            if ((yP + y) < 0 || (yP + diameter + y) > getParent().getHeight()) {
                y = y * -1;
            }
            xP += x;
            yP += y;

            // Update the size and location
            setSize(getPreferredSize());
            setLocation(xP, yP);
        }
	}
}
