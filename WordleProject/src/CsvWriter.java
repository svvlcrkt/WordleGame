import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriter {
	public char letters[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','V','Z'};
	public int numbers[];
    public StringBuilder sb = new StringBuilder();
	
	  public CsvWriter(String path) {

	    try (PrintWriter writer = new PrintWriter(path)) {


	      for (int i = 0; i < letters.length; i++) {
		      sb.append(letters[i]);
		      sb.append(',');
		      
	      }
	      sb.append('\n');

	      writer.write(sb.toString());

	      System.out.println("done!");

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }

	  }
	  public void add(String path,int i) {
		    try (PrintWriter writer = new PrintWriter(path)) {
				  sb.append(i);
				  sb.append(',');
				  writer.write(sb.toString());


			    } catch (FileNotFoundException e) {
			      System.out.println(e.getMessage());
			    }

		  
	  }

	  
	}