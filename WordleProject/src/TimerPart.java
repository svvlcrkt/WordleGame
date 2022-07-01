
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class TimerPart {

	JFrame window;
	JLabel counterLabel;
	Font font = new Font("Arial", Font.PLAIN, 20);

	Timer timer;
	
	int second, minute;
	
	DecimalFormat dFormat = new DecimalFormat("00");
	String ddSecond, ddMinute;
	
	public TimerPart() {
		//window = new JFrame();
		//window.setSize(200,150);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setLayout(new GridLayout(1,1));
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(50,30,80,50);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		//counterLabel.setVerticalAlignment(JLabel.CENTER);
		counterLabel.setFont(font);
		
		//window.add(counterLabel);
		//window.setVisible(true);

		
		counterLabel.setText("00:00");
		second = 0;
		minute = 0;
		normalTimer();
		timer.start();
		
		
	}
	
	public void normalTimer() 
	{
		timer = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				counterLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==60) 
				{
					second=0;
					minute++;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
				
				int dMinute = Integer.parseInt(ddMinute);
				if(dMinute==50) 
				{
					System.exit(0);
				}
			}
		});
	
	}
}
