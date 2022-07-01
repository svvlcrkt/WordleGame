
public class PlayerKeyboardData {
	public char letters[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public int numbers[];
	


	public PlayerKeyboardData() {
		numbers= new int[letters.length];
		for (int i = 0; i < letters.length; i++) {
			numbers[i]=0;
		}
	}
}
