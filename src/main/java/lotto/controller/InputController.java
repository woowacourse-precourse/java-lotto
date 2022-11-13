package lotto.controller;

import lotto.controller.dto.UserPriceDto;
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

	public UserPriceDto getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		UserPriceDto userPriceDto;
		try {
			userPriceDto = new UserPriceDto(inputValidService.validateUserMoney(userMoney));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return userPriceDto;
	}

	public WinnerNumberDto getAnswerNumber() {
		String answer = inputView.printWinnerNumber();
		WinnerNumberDto winnerNumberDto;
		try {
			winnerNumberDto = new WinnerNumberDto(inputValidService.validAnswer(answer));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumberDto;
	}

	public WinnerNumberDto getBonusNumber(WinnerNumberDto winnerNumberDto) {
		String bonus = inputView.bonusNumber();
		try {
			winnerNumberDto.setBonusNumber(inputValidService.validateBonus(bonus));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumberDto;
	}

}
