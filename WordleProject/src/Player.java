import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Player {
	private String name;
	private boolean isMyTurn=false;
	private PlayerKeyboardData keyboardData;
	public int score=0;
	
	public String getName() {
		return name;
	}


	public boolean isMyTurn() {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	public PlayerKeyboardData getKeyboardData() {
		return keyboardData;
	}


	public Player() {
		
		keyboardData= new PlayerKeyboardData();
	}



	public void setName(String name) {
		this.name = name;
	}
	

	
	

	
}
