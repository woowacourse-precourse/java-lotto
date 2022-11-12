package lotto.controller;

import static lotto.util.ValidUtil.*;

import lotto.controller.dto.UserPriceDto;
import lotto.controller.dto.WinnerNumberDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

	private final InputView inputView;
	private final OutputView outputView;

	public InputController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public UserPriceDto getUserMoneyNumber() {
		String userMoney = inputView.printStart();
		UserPriceDto userPriceDto;
		try {
			userPriceDto = new UserPriceDto(validateUserMoney(userMoney));
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
			winnerNumberDto = new WinnerNumberDto(validAnswer(answer));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumberDto;
	}

	public WinnerNumberDto getBonusNumber(WinnerNumberDto winnerNumberDto) {
		String bonus = inputView.bonusNumber();
		try {
			winnerNumberDto.setBonusNumber(validateBonus(bonus));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return null;
		}
		return winnerNumberDto;
	}

}
