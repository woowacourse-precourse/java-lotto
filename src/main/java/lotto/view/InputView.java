package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;
import lotto.util.Validator;

public class InputView {
	public String getPurchasingAmount() {
		printAskingPurchasingAmountMessage();
		String purchasingAmount = Console.readLine();
		Validator.validateIntegerOrNot(purchasingAmount);
		return purchasingAmount;
	}

	public String getWinningNumbers() {
		printAskingWinningNumbersMessage();
		String winningNumbers = Console.readLine();
		Validator.validateFormOfWinningNumbers(winningNumbers);
		return winningNumbers;
	}

	public String getBonusNumber() {
		printAskingBonusNumberMessage();
		String bonusNumber = Console.readLine();
		Validator.validateIntegerOrNot(bonusNumber);
		return bonusNumber;
	}

	private void printAskingBonusNumberMessage() {
		System.out.println();
		System.out.println(OutputMessage.ASKING_BONUS_NUMBER.message());
	}

	private void printAskingWinningNumbersMessage() {
		System.out.println();
		System.out.println(OutputMessage.ASKING_WINNING_NUMBERS.message());
	}

	private void printAskingPurchasingAmountMessage() {
		System.out.println(OutputMessage.ASKING_PURCHASING_AMOUNT.message());
	}

}
