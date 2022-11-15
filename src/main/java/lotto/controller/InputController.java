package lotto.controller;

import lotto.controller.dto.UserInputMoneyDto;
import lotto.controller.dto.WinningNumberDto;
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

	public WinningNumberDto getWinningNumber() {
		String answer = inputView.printWinningNumber();
		try {
			return new WinningNumberDto(inputValidService.validWinningNumber(answer));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	public WinningNumberDto getBonusNumber(WinningNumberDto winningNumberDto) {
		String bonus = inputView.printBonusNumber();
		try {
			winningNumberDto.setBonusNumber(
				inputValidService.validateBonus(bonus, winningNumberDto.getWinningNumbers()));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return winningNumberDto;
	}

}
