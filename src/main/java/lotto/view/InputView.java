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
		return moneyInputValidator.runMoneyInputValidator(data);
	}

	public String inputNumbers() {
		return readLine();
	}
}
