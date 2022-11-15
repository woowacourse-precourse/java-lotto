package lotto;

import lotto.controller.LottoController;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		MoneyInputValidator moneyInputValidator = new MoneyInputValidator();
		WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
		BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
		InputView inputView = new InputView(moneyInputValidator, winningNumberValidator, bonusNumberValidator);

		LottoController lottoController = new LottoController(inputView);
		lottoController.playLotto();
	}
}
