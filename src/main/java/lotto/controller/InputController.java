package lotto.controller;

import lotto.controller.dto.UserInputMoneyDto;
import lotto.controller.dto.WinnerNumberDto;
import lotto.service.InputValidService;
import lotto.view.InputView;

public class InputController {

	private final InputView inputView;
	private final InputValidService inputValidService;

	public InputController(InputView inputView, InputValidService inputValidService) {
		this.inputView = inputView;
		this.inputValidService = inputValidService;
	}

	public UserInputMoneyDto getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		try {
			return new UserInputMoneyDto(inputValidService.validateUserMoney(userMoney));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	public WinnerNumberDto getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		try {
			return new WinnerNumberDto(inputValidService.validAnswer(answer));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	public WinnerNumberDto getBonusNumber(WinnerNumberDto winnerNumberDto) {
		String bonus = inputView.printBonusNumber();
		try {
			winnerNumberDto.setBonusNumber(inputValidService.validateBonus(bonus));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return winnerNumberDto;
	}

}
