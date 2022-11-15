package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class InputView {

	private static final String ERROR_INPUT_NULL = "[ERROR] 입력이 없습니다.";
	private static final String ERROR_INPUT_INT = "[ERROR] 숫자만 입력하세요";
	static InputView instance;


	private InputView(){}

	public static InputView getInstance(){
		if(instance == null){
			instance = new InputView();
		}
		return instance;
	}

	public List<Integer> winningNumber() {
		String winningNumberInput = Console.readLine();

		validateNull(ERROR_INPUT_NULL);
		List<Integer> lotto = new ArrayList<>();
		for (String number : winningNumberInput.split(",")) {
			lotto.add(Integer.parseInt(number));
		}
		return lotto;
	}

	public int bonusNumber() {
		String bonusNumberInput = Console.readLine();
		validateNull(ERROR_INPUT_NULL);

		return Integer.parseInt(bonusNumberInput);
	}
	public int createPurchaseAmount() {
		String purchaseAmountInput = Console.readLine();
		validateNull(purchaseAmountInput);
		validatePurchaseAmount(purchaseAmountInput);

		return Integer.parseInt(purchaseAmountInput);
	}

	private void validateNull(String input) {
		if(input.isEmpty()) {
			System.out.println(ERROR_INPUT_NULL);
		}
	}
	private void validatePurchaseAmount(String input) {
		if (!(isAllDigit(input))) {
			throw new IllegalArgumentException(ERROR_INPUT_INT);
		}
	}

	private boolean isAllDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
