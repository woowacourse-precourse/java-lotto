package lotto.controller;

import lotto.domain.UserPrice;
import lotto.domain.WinnerNumber;
import lotto.util.ValidUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

	private final ValidUtil validUtil;
	private final InputView inputView;
	private final OutputView outputView;

	public InputController(ValidUtil validUtil, InputView inputView, OutputView outputView) {
		this.validUtil = validUtil;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public UserPrice getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		UserPrice userPrice;
		try {
			userPrice = new UserPrice(userMoney);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return userPrice;
	}

	public WinnerNumber getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		WinnerNumber winnerNumber;
		try {
			winnerNumber = new WinnerNumber(answer);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumber;
	}

	public WinnerNumber getBonusNumber(WinnerNumber winnerNumber) {
		String bonus = inputView.bonusNumber();
		try {
			winnerNumber.updateBonusNumber(bonus);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumber;
	}

}
