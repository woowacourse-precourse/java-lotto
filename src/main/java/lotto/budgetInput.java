package lotto;

import camp.nextstep.edu.missionutils.Console;
public class budgetInput {
	public static int budgetInput() {
		System.out.println("게임을 구매하실 금액을 입력해주세요");
		int budget = Integer.parseInt(Console.readLine());
		validate(budget);
		int numberOfGame = budget/1000;
		System.out.println("구매한 게임횟수는 "+numberOfGame+"회");
		return numberOfGame;
	}
	private static void validate(int budget) {
		if (budget < 1000) {
			throw new IllegalArgumentException();
		}
		if (budget % 1000 != 0) {
			throw new IllegalArgumentException();
		}
	}
}
