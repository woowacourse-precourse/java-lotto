package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class InputView {

	private static final String ERROR_INPUT_NULL = "[ERROR] 입력이 없습니다.";
	private static final String ERROR_INPUT_INT = "[ERROR] 숫자만 입력하세요";
	private static final String ERROR_INPUT_FORMAT = "[ERROR] ','와 숫자만 입력 가능합니다";
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
		List<Integer> lotto = new ArrayList<>();

		validateNull(winningNumberInput);
		validateInputFormat(winningNumberInput);
		for (String number : winningNumberInput.split(",")) {
			lotto.add(Integer.parseInt(number));
		}
		return lotto;
	}

	public int bonusNumber() {
		String bonusNumberInput = Console.readLine();
		validateNull(bonusNumberInput);
		validateNumber(bonusNumberInput);

		return Integer.parseInt(bonusNumberInput);
	}
	public int purchaseAmount() {
		String purchaseAmountInput = Console.readLine();
		validateNull(purchaseAmountInput);
		validateNumber(purchaseAmountInput);

		return Integer.parseInt(purchaseAmountInput);
	}

	private void validateNull(String input) {
		if(input.isEmpty()) {
			throw new IllegalArgumentException(ERROR_INPUT_NULL);
		}
	}
	private void validateInputFormat(String input) {
		if(!(isCorrectFormat(input))) {
			throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
		}
	}

	private boolean isCorrectFormat(String input) {
		return input.chars().allMatch(c -> Character.isDigit(c) || c == ',');
	}

	private void validateNumber(String input) {
		if (!(isAllDigit(input))) {
			throw new IllegalArgumentException(ERROR_INPUT_INT);
		}
	}

	private boolean isAllDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
