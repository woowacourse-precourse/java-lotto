package lotto.controller;

import java.util.List;

import lotto.service.InputService;
import lotto.view.InputView;

public class InputController {

	private final InputService inputService;
	private final InputView inputView;

	public InputController(InputService inputService, InputView inputView) {
		this.inputService = inputService;
		this.inputView = inputView;
	}

	public Integer getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		return inputService.validateUserMoney(userMoney);
	}

	public List<Integer> getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		return inputService.validAnswer(answer);
	}

	public Integer getBonusNumber() {
		String bonus = inputView.bonusNumber();
		return inputService.validateBonus(bonus);
	}

}
