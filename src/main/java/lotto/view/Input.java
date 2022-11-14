package lotto.view;

import static lotto.validator.CommonValidator.validateIsNumber;
import static lotto.validator.PurchasePriceValidator.validatePurchasePrice;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;


public class Input {
	private static final String PRINT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
	private static final String PRINT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
	private static final String PRINT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public static int purchasePriceInput() {
		System.out.println(PRINT_PURCHASE_PRICE);
		String input = Console.readLine();
		validatePurchasePrice(input);

		return Integer.parseInt(input);
	}

	public static Lotto winningNumbersInput() {
		System.out.println(PRINT_WINNING_NUMBERS);
		String input = Console.readLine();
		String[] splitInput = input.split(",");

		List<Integer> winningNumbers = new ArrayList<>();
		for (String str : splitInput) {
			validateIsNumber(str);
			int number = Integer.parseInt(str);
			winningNumbers.add(number);
		}

		return new Lotto(winningNumbers);
	}

	public static int bonusNumberInput() {
		System.out.println(PRINT_BONUS_NUMBER);
		String input = Console.readLine();

		validateIsNumber(input);
		int bonusNumber = Integer.parseInt(input);

		return bonusNumber;
	}
}
