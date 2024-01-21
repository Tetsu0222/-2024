package logic;

public class NumberOfCalculations {
	
	//定数時間
	public void calc(int x) {
		
		//2x + 3の数値を求める。
		int result = 2 * x + 3; //計算回数は2回と決まった回数になる。
		
		System.out.println(result);
		
	}
	
	//線形時間
	public void calc(int x , int y , int z) {
		
		//x以下の正の整数の中で、yの倍数またはzの倍数であるものの個数を出力
		
		int count = 0;
		
		for( int i = 1 ; i <= x ; i++) { //計算回数はループ回数と同値になるため、仮にxが7であれば7回ループ、計算回数も7となる。
			if( i % y == 0 || i % z == 0 ) {
				count++; //入力データの大きさが増えると、計算回数が増える。
			}
		}
		
		System.out.println(count);
	}
	
	//全検索
	public void calc(int x , int y ) {
		//xには任意の整数が1つ入る。
		//1～xの値を2つの変数に代入する。
		//2つの変数の合計が整数y以下のパターンはいくつあるか。
		
		int count = 0;
		
		for( int i = 1 ; i <= x ; i++ ) { //2重for文は数が増えるにつれて、計算回数が10倍、100倍と爆発的に増加しやすい。

			for( int j = 1 ; j <= x ; j++ ) {
				
				if( i + j <= y ) {
					count++;
				}
			}
			
		}
		
		System.out.println(count);
			
	}
	
}