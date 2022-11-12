package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoCompany;

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

	public LottoCompany createWinningLotto() {
		String winningNumberInput = Console.readLine();
		String bonusNumberInput = Console.readLine();

		return new LottoCompany(winningNumberInput, bonusNumberInput);
	}

	public int createPurchaseAmount() {
		String purchaseAmountInput;
		do {
			purchaseAmountInput = Console.readLine();
		} while (validatePurchaseAmount(purchaseAmountInput));

		return Integer.parseInt(purchaseAmountInput);
	}

	private boolean validatePurchaseAmount(String input) {
		if (!(isAllDigit(input))) {
			System.out.println(ERROR_INPUT_INT);
			return true;
		}
		if(input.isEmpty()) {
			System.out.println(ERROR_INPUT_NULL);
			return true;
		}
		return false;
	}

	private boolean isAllDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
