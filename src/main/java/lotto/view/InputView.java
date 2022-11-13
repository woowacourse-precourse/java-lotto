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

	private void printAskingWinningNumbersMessage() {
		System.out.println(OutputMessage.ASKING_WINNING_NUMBERS);
	}
	private void printAskingPurchasingAmountMessage() {
		System.out.println(OutputMessage.ASKING_PURCHASING_AMOUNT.message());
	}


}
