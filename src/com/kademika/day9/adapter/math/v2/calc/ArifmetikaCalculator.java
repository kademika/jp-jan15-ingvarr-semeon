package com.kademika.day9.adapter.math.v2.calc;

import com.kademika.day9.adapter.math.Arifmetika;

public class ArifmetikaCalculator implements Calculator  {

	@Override
	public int summa(int a, int b) {
		return Arifmetika.summa(new int[] { a, b });
	}

	@Override
	public int multiply(int a, int b) {
		int result = a;
		for (int i = 0; i < b; i++) {
			result =  Arifmetika.summa(new int[] {result, a});
		}
		return result;
	}

}
