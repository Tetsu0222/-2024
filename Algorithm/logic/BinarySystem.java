package logic;


//y進数のxを10進数に変換
public class BinarySystem {
	
	
	public int numberChange(int i , int y) {
		
		String targetNumber = String.valueOf(i);
		int countLength = targetNumber.length() - 1;
		int keta = 1;
		int returnNumber = 0;
		
		
		for( int x = countLength ; x >= 0 ; x-- ) {
			String numbnerSauce = String.valueOf(targetNumber.charAt(x));
			int number = Integer.parseInt(numbnerSauce);
			
			returnNumber += number * keta;
			
			keta = keta * y;
			
			
		}
		
		return returnNumber;
	}

}
