package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
public class Input {
	public static int budgetInput() {
		System.out.println("게임을 구매하실 금액을 입력해주세요");
		int budget = Integer.parseInt(Console.readLine());
		validateBudget(budget);
		int numberOfGame = budget/1000;
		System.out.println("구매한 게임횟수는 "+numberOfGame+"회");
		return numberOfGame;
	}
	public static ArrayList<Integer> winningNumberInput() {
		ArrayList<Integer> winningNumber = new ArrayList<>();
		System.out.println("당첨번호 6자리를 ,로 나누어 입력하세요");
		String userInput = Console.readLine();
		String[] array = userInput.split(",");

		for ( int i=0;array.length>i;i++){
			winningNumber.add(Integer.valueOf(array[i]));
		}
		validateArray(winningNumber);
		return winningNumber;

	}

	private static void validateBudget(int budget) {
		if (budget < 1000) {
			throw new IllegalArgumentException();
		}
		if (budget % 1000 != 0) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateArray(ArrayList<Integer> integers) {
		for (int i = 0;integers.size()>i;i++){
			if (integers.get(i) < 1 || integers.get(i) > 45) {
				System.out.println("잘못된 입력"+integers.get(i));
				throw new IllegalArgumentException();
			}
		}
		Set<Integer> hashIntegers = new HashSet<>(integers);
		if (integers.size() != hashIntegers.size()) {
			System.out.println("중복발생"+integers.size()+hashIntegers.size());
			throw new IllegalArgumentException();
		}
		if (integers.size() != 6) {
			System.out.println("입력값개수오류"+integers.size());
			throw new IllegalArgumentException();
		}
	}
}
