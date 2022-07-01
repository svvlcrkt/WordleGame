


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Slice {
  double value;
  Color color;

  public Slice(double value) {
    this.value = value;

  }
}

class MyComponent extends JComponent {
  Slice[] slices = new Slice[5] ;
  int []array;
  char[]letters;
  Color []colors= new Color[5];
  double []percentage= new double[5];

 
  MyComponent(Player player,String csvPath) {
	  	array=new int[player.getKeyboardData().letters.length];
	  	letters = new char[player.getKeyboardData().letters.length];
		colors[0]=Color.cyan;
		colors[1]=Color.red;
		colors[2]=Color.green;
		colors[3]=Color.lightGray;
		colors[4]=Color.yellow;
		CsvReader Reader1=new CsvReader(csvPath);
		String ReaderArray[]=Reader1.dataLine.split(",");
		int value[]= new int[ReaderArray.length];
		for (int i = 0; i < player.getKeyboardData().letters.length; i++) {
			value[i]=Integer.parseInt(ReaderArray[i]);
			array[i]=value[i];
			letters[i]=player.getKeyboardData().letters[i];
		}
		//Arrays.sort(array, Collections.reverseOrder());
		
		
		
        for (int i = 0; i < array.length; i++) {
        	 
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < array.length; j++) {
 
                // Checking elements
                int temp = 0;
                char tempChar;
                if (array[j] < array[i]) {
 
                    // Swapping
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    
                    tempChar = letters[i];
                    letters[i] = letters[j];
                    letters[j] = tempChar;
                }
            }
 
            // Printing sorted array elements
            //System.out.print(arr[i] + " ");
        }

        reverse(array);
        reverse(letters);
        
        double total=0;
        for (int i = 0; i < 5; i++) {
			total+=array[i];
		}
        
        for(int i=0;i<5;i++) {
        	percentage[i]=((double)array[i]/total)*100.0;
        }
        
        
        for (int i = 0; i < 5; i++) {
			System.out.println(letters[i]+" "+array[i]);
		}

		for (int i = 0; i < 5; i++) {
			slices[i]= new Slice(array[i]);
			slices[i].color=colors[i];

		}
		

		

		
  }
  public void reverse(int[] array)
  {

      // Length of the array
      int n = array.length;

      // Swaping the first half elements with last half
      // elements
      for (int i = 0; i < n / 2; i++) {

          // Storing the first half elements temporarily
          int temp = array[i];

          // Assigning the first half to the last half
          array[i] = array[n - i - 1];

          // Assigning the last half to the first half
          array[n - i - 1] = temp;
      }
  }
  
  public void reverse(char[] array)
  {

      // Length of the array
      int n = array.length;

      // Swaping the first half elements with last half
      // elements
      for (int i = 0; i < n / 2; i++) {

          // Storing the first half elements temporarily
          char temp = array[i];

          // Assigning the first half to the last half
          array[i] = array[n - i - 1];

          // Assigning the last half to the first half
          array[n - i - 1] = temp;
      }
  }
  public void paint(Graphics g) {
    drawPie((Graphics2D) g, getBounds(), slices);
  }

  void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
    double total = 0.0D;
    for (int i = 0; i < slices.length; i++) {
      total += slices[i].value;
    }

    double curValue = 0.0D;
    int startAngle = 0;
    for (int i = 0; i < slices.length; i++) {
      startAngle = (int) (curValue * 360 / total);
      int arcAngle = (int) (slices[i].value * 360 / total);

      g.setColor(slices[i].color);
      g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
      curValue += slices[i].value;
    }
  }
}

public class PieChart {

}