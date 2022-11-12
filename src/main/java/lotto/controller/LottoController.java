package lotto.controller;

import lotto.Util;
import lotto.model.Cash;
import lotto.model.NumberValidator;
import lotto.view.InputView;

public class LottoController {
	private Cash cash;
	public void start(){
		NumberValidator cashValidator = new NumberValidator(InputView.buyInput());
		cash = new Cash(Util.toLong(cashValidator.INPUT_VALUE));
	}
}
