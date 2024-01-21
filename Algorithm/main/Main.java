package main;

import logic.BinarySystem;

public class Main {
	
	public static void main( String[] args ) {

	//第2引数の進数の数字が第1引数
	BinarySystem testSample = new BinarySystem();
	int i = testSample.numberChange(1011 , 2);
	
	System.out.println(i);
	
	}
}
