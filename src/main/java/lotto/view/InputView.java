package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

import lotto.validator.MoneyInputValidator;

public class InputView {
	private final MoneyInputValidator moneyInputValidator;

	public InputView(MoneyInputValidator moneyInputValidator) {
		this.moneyInputValidator = moneyInputValidator;
	}

	public int inputMoney() {
		String data = readLine();
		int money = 0;
		try {
			money = moneyInputValidator.runMoneyInputValidator(data);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return money;
	}

	public String inputNumbers() {
		return readLine();
	}
}
