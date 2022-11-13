package lotto.controller;

import lotto.controller.dto.UserInputMoneyDto;
import lotto.controller.dto.WinnerNumberDto;
import lotto.service.InputValidService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

	private final InputView inputView;
	private final OutputView outputView;
	private final InputValidService inputValidService;

	public InputController(InputView inputView, OutputView outputView,
		InputValidService inputValidService) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.inputValidService = inputValidService;
	}

	public UserInputMoneyDto getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		UserInputMoneyDto userInputMoneyDto;
		try {
			userInputMoneyDto = new UserInputMoneyDto(inputValidService.validateUserMoney(userMoney));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return userInputMoneyDto;
	}

	public WinnerNumberDto getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		WinnerNumberDto winnerNumberDto;
		try {
			winnerNumberDto = new WinnerNumberDto(inputValidService.validAnswer(answer));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return winnerNumberDto;
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
