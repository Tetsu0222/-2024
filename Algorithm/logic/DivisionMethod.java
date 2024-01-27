package logic;

public class DivisionMethod {
	
	//ユーグリッドの互除法 初期案
	public void test( int x , int y ) {
		
		int bigNumber = 0;
		int smallNumber = 0;
		
		//両方が同じ数値の場合は、処理終了
		if( x == y ) {
			System.out.println("最大公約数は" + x + "です。");
			return;
		}
		
		if( x == 1 || y == 1) {
			System.out.println("最大公約数は1です。");
			return;
		}
		
		//移行の処理でユーグリッドの互除法を実施
		if( x > y ) {
			bigNumber = x;
			smallNumber = y;
		}else{
			bigNumber = y;
			smallNumber = x;
		}
		
		while( bigNumber > smallNumber ) {
			
			//割り切れたら処理終了
			if( smallNumber == 0) {
				System.out.println("最大公約数は" + bigNumber + "です。");
				return;
			}
			
			//メイン処理、大きい数を小さい数で割った余りを、一時的に大きい数へ代入
			bigNumber = bigNumber % smallNumber;
			
			//大きい数と小さい数の大小関係を整理
			if( bigNumber < smallNumber ) {
				int samllChangeNumber = bigNumber;
				bigNumber = smallNumber;
				smallNumber = samllChangeNumber;
			}
		}
	}
	
	//リファクタリング後
	public void exec( int x , int y ) {
		
		//両方が同じ数値の場合は、処理終了
		if( x == y ) {
			System.out.println("最大公約数は" + x + "です。");
			return;
		}
		
		if( x == 1 || y == 1) {
			System.out.println("最大公約数は1です。");
			return;
		}
		
		//メインロジック
		while( x >= 1 && y >= 1 ) {
			if( x > y ){
				x = x % y;
			}else{
				y = y % x;
			}
		}
		
		String bigNumber = x > y ? String.valueOf(x) : String.valueOf(y);
		System.out.println("最大公約数は" + bigNumber + "です。");
	}

}
