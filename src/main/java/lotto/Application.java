package lotto;

import lotto.controller.LottoController;
import lotto.validator.MoneyInputValidator;
import lotto.view.InputView;

public class Application {
	public static void main(String[] args) {
		MoneyInputValidator moneyInputValidator = new MoneyInputValidator();
		InputView inputView = new InputView(moneyInputValidator);

		LottoController lottoController = new LottoController(inputView);
		lottoController.playLotto();
	}
}
