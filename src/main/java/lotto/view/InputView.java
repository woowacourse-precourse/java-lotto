package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumberValidator;

public class InputView {
	private final MoneyInputValidator moneyInputValidator;
	private final WinningNumberValidator winningNumberValidator;
	private final BonusNumberValidator bonusNumberValidator;
	private static List<Integer> winningNumbers;

	public InputView(MoneyInputValidator moneyInputValidator, WinningNumberValidator winningNumberValidator,
		BonusNumberValidator bonusNumberValidator) {
		this.moneyInputValidator = moneyInputValidator;
		this.winningNumberValidator = winningNumberValidator;
		this.bonusNumberValidator = bonusNumberValidator;
	}

	public Integer inputMoney() {
		String data = readLine();
		return moneyInputValidator.runMoneyInputValidator(data);
	}

	public List<Integer> inputWinningNumbers() {
		String data = readLine();
		winningNumbers = winningNumberValidator.runWinningNumberValidator(data);
		return winningNumbers;
	}

	public Integer inputBonusNumber() {
		String data = readLine();
		return bonusNumberValidator.runBonusNumberValidator(data, winningNumbers);
	}
}
