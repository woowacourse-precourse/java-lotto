package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
public class Input {
	public static int budgetInput() {
		System.out.println("게임을 구매하실 금액을 입력해주세요");
		try{
			int budget = Integer.parseInt(Console.readLine());
			validateBudget(budget);
			int numberOfGame = budget/1000;
			return numberOfGame;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자로만 입력되어야 합니다.");
		}
	}
	public static ArrayList<Integer> winningNumberInput() {
		ArrayList<Integer> winningNumber = new ArrayList<>();
		System.out.println("당첨번호 6자리를 ,로 나누어 입력하세요.");
		String userInput = Console.readLine();
		String[] array = userInput.split(",");

		for ( int i=0;array.length>i;i++){
			winningNumber.add(Integer.valueOf(array[i]));
		}
		validateWinningNumber(winningNumber);
		return winningNumber;

	}

	public static int bonusNumberInput(ArrayList<Integer> winningNumber) {
		System.out.println("보너스번호 1자리를 입력하세요");
		int userInput = Integer.parseInt(Console.readLine());

		validateBonusNumber(winningNumber,userInput);
		return userInput;

	}
	private static void validateBudget(int budget) {
		if (budget < 1000) {
			throw new IllegalArgumentException("[ERROR]");
		}
		if (budget % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}

	private static void validateWinningNumber(ArrayList<Integer> integers) {
		for (int i = 0;integers.size()>i;i++){
			if (integers.get(i) < 1 || integers.get(i) > 45) {
				throw new IllegalArgumentException("[ERROR]");
			}
		}
		Set<Integer> hashIntegers = new HashSet<>(integers);
		if (integers.size() != hashIntegers.size()) {
			throw new IllegalArgumentException("[ERROR]");
		}
		if (integers.size() != 6) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}

	private static void validateBonusNumber(ArrayList<Integer> winningNumber,int bonusNumber) {
		if(bonusNumber > 45 || bonusNumber < 1){
			throw new IllegalArgumentException("[ERROR]");
		}
		for(int i=0;winningNumber.size()>i;i++){
			if(winningNumber.get(i) == bonusNumber){
				throw new IllegalArgumentException("[ERROR]");
			}
		}
	}
}
