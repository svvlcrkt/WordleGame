import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
	public String line="";
	public String dataLine;
	public CsvReader(String path) {
		

		try {
			BufferedReader br= new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				dataLine=line;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
