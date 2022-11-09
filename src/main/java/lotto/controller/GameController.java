package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class GameController {

	public void play(){
		Money money = new Money(InputView.inputMoney());
	}
}
