package logic;

import java.util.List;

//動的計画法
public class DynamicProgramming {
	
	/*
	 * 命題
	 * x個の足場があり、左からN番目の足場の高さはy
	 * 1つもしくは2つ先の足場にジャンプできる。
	 * 現在の足場の高さとジャンプした先の足場の高さに高低差がある場合、その差分だけ体力を消費する。
	 * 最後の足場に到達する際の最小の消費体力を求める。
	 */
	
	public Integer test(List<Integer> heightsList) {
		
		if( heightsList.size() <= 1){
			return 0;
		}
		
		if( heightsList.size() == 2){
			return Math.abs(heightsList.get(0) - heightsList.get(1));
		}
		
		int min = Math.abs(heightsList.get(0) - heightsList.get(1));
		
		for(int i = 3 ; i < heightsList.size() ; i++) {
			
			int h1 = min + Math.abs(heightsList.get(i-1) - heightsList.get(i));
			int h2 = min + Math.abs(heightsList.get(i-2) - heightsList.get(i));
			
			if( h1 < h2 ){
				min = h1;
			}else{
				min = h2;
			}
		}
		
		return min;
	}

}
