package logic;

import java.util.List;

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
	
	//戻り値を返すタイプ
	public int exec2( int x , int y ) {
		
		//メインロジック
		//大きい数値を小さい数値で割った余りを求める。
		while( x >= 1 && y >= 1 ) {
			if( x > y ){
				x = x % y;
			}else{
				y = y % x;
			}
		}
		
		int bigNumber = x > y ? x : y;
		
		return bigNumber;
	}
	
	//リファクタリング 再帰関数による繰り返し処理
	//xが割られる数、yが割る数
	public int exec4( int x , int y ) {
		
		if(y == 0){
			return x;
		}
		
		//xとyの大きさ関係なく、xをyで割った後の値の方が小さくなる。
		//そのため、xとyの数値の大小比較が冗長となる。
		//前者の引数が大きい数値、後者が小さい数値⇒再帰される際は、変数が入れ替わることに注意
		//「%」は割る方の数値yの方が割られる数xよりも大きい場合、xをそのまま返す。
		return exec4( y , x % y); 
		
	}
	
//	public void exec3( int x , int y ) {
//		
//		System.out.println( x % y );
//		
//	}

	
	//複数の数の最大公約数
	public void exec( List<Integer> numberList ){
		int result = numberList.stream().reduce(0,(x,y) -> this.exec2(x, y));
		System.out.println( result );
	}
}
