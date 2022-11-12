package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
	public static int getPurchasePrice() {
		String input = Console.readLine();
		validateIsNumber(input);

		int purchasePrice = Integer.parseInt(input);
		validateIsMultipleOfThousand(purchasePrice);

		return purchasePrice;
	}

	public static List<Integer> getWinningNumbers() {
		String input = Console.readLine();
		String[] splitInput = input.split(",");
		List<Integer> winningNumbers = new ArrayList<>();

		for (String str : splitInput) {
			validateIsNumber(str);
			int number = Integer.parseInt(str);

			validateIsInLottoRange(number);
			winningNumbers.add(number);
		}

		validateHasNoDuplication(winningNumbers);

		return winningNumbers;
	}

	public static int getBonusNumber() {
		String input = Console.readLine();
		validateIsNumber(input);

		int bonusNumber = Integer.parseInt(input);
		validateIsInLottoRange(bonusNumber);

		return bonusNumber;
	}

	public static void printWinningStatistics(List<Lotto> lotteries, List<Integer> winningNumbers) {

	}

	private static void validateIsNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
		}
	}

	private static void validateIsMultipleOfThousand(int num) {
		if (num % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원으로 나누어 떨어지지 않습니다.");
		}
	}

	private static void validateIsInLottoRange(int num) {
		if (num < 1 || num > 45) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
		}
	}

	private static void validateHasNoDuplication(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (numbers.lastIndexOf(num) != i) {
				throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 수로 이루어져야 합니다.");
			}
		}
	}


}
