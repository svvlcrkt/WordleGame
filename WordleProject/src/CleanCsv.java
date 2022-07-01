import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CleanCsv {
	public char letters[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','V','Z'};
	public int numbers[];
    public StringBuilder sb = new StringBuilder();
	
	  public CleanCsv() {
			String Player1data = System.getProperty("user.dir");
			String Player1csv=Player1data+"/src/Player2.csv";

	    try (PrintWriter writer = new PrintWriter(Player1csv)) {


	      for (int i = 0; i < letters.length; i++) {
		      sb.append(letters[i]);
		      sb.append(',');
		      
	      }
	      sb.append('\n');
	      for (int i = 0; i < letters.length; i++) {
		      sb.append(0);
		      sb.append(',');
		      
	      }
	      sb.append('\n');

	      writer.write(sb.toString());

	      System.out.println("done!");

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }

	  }
		public static void main(String[] args) {
			CleanCsv i = new CleanCsv();
		}

	  
}