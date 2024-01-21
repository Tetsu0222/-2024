package logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
	
	//全検索と指数時間
	public void calc2(int x , int y) {
		//x枚のカードが並べられている。
		//x枚のカードにはそれぞれ整数が記入されている。
		//カードの中からいくつか選んで、その合計がyとなるパターンはいくつ存在するか。
		
		//プログラミングは後で考えてみる。
		int cardNumber1 = 2;
		int cardNumber2 = 5;
		int cardNumber3 = 9;
		
		//仮定
		x = 3;  //パターンが増えれば増えるほど、計算回数が爆発的に増加する。
		y = 11; //パターンが増えれば増えるほど、計算回数が爆発的に増加する。
				
		
		int count = 0;
		
		System.out.println(count);
			
	}
	
	
	//二分探索法
	public void calcharf(int x , int y) {
		//1以上x以下の数値を設定
		//設定された数値がいくつなのか判定する。
		
		//線形探索法では、1以下かどうか、2以下かどうか…で検索
		//二分探索法では、選択肢を半分に分ける方法で探索していく。
		
		Integer[] testArray = {1,2,3,4,5,6,7,8,9,10}; //抜け漏れがないパターン
		//Integer[] testArray = {1,2,3,4,5,6,7,8,10}; //抜け漏れがないパターン 1個
		//Integer[] testArray = {1,2,5,6,7,8,9,10}; //抜け漏れがないパターン 2個
		
		//最初の番号と最後の番号から抜けている番号がなかった場合の合計値と要素数を算出
		final int sumNumber = IntStream.rangeClosed(x, y).sum(); //

		//取得した項番の配列をリストへ変換、実際の項番の合計値と要素数を算出
		List <Integer> testList = Arrays.asList(testArray);
		final int testSumNumber = testList.stream().mapToInt(number -> number ).sum();
		final int testSumNumberSize = testArray.length;
		
		//期待値と実際の要素数を比較して、差異がなければ抜けている番号はないと判断、処理を終了する。
		if( y == testSumNumberSize ) {
			System.out.println( "項番に抜け漏れはない" );
			return;
		}
		
		final int sizeNumber = y - testSumNumberSize;
		
		//期待値と実際の項番数の合計を比較し、抜けている番号を算出する。
		final int leakingNumber = sumNumber - testSumNumber;
		
		//抜けている番号が1つだけなら、もはやそれのパターン
		if( sizeNumber == 1 ) {
			
			//一応、確認
			if( leakingNumber > 0 ) {
				System.out.println("不正な数値が混入されています。");
				return;
			}
			
			//再確認
			if( !testList.contains(leakingNumber) ) {
				System.out.println("抜けている番号は" + leakingNumber);
				return;
			}
		}
		
		//抜けている番号未満の数値に絞り込む。ここで初めて二分探索法を使用
		final List <Integer> testChaekNumber = testList.stream().filter( number -> leakingNumber > number ).toList();
		final List <Integer> lastList = testList.stream().filter( number -> !testChaekNumber.contains(number)).toList();
		
		System.out.println("抜けている番号は" + lastList);
	}
	
}