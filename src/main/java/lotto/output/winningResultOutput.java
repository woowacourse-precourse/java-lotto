package lotto.output;

import java.util.HashMap;

public class winningResultOutput {
	public winningResultOutput(HashMap<String, Integer> calculateResult) {
		System.out.println("3개 일치 (5,000원) - " + calculateResult.get("three") + "개");
		System.out.println("4개 일치 (50,000원) - " + calculateResult.get("four") + "개");
		System.out.println("5개 일치 (1,500,000원) - " + calculateResult.get("five") + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + calculateResult.get("bonus") + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + calculateResult.get("six") + "개");
	}
}
