package lotto.controller;

import java.util.List;

import lotto.service.InputService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

	private final InputService inputService;
	private final InputView inputView;
	private final OutputView outputView;

	public InputController(InputService inputService, InputView inputView, OutputView outputView) {
		this.inputService = inputService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public Integer getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		Integer userMoneyNumber;
		try {
			userMoneyNumber = inputService.validateUserMoney(userMoney);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return userMoneyNumber;
	}

	public List<Integer> getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		List<Integer> answerNumber;
		try {
			answerNumber = inputService.validAnswer(answer);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return answerNumber;
	}

	public Integer getBonusNumber() {
		String bonus = inputView.bonusNumber();
		Integer bonusNumber;
		try {
			bonusNumber = inputService.validateBonus(bonus);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return bonusNumber;
	}

}
