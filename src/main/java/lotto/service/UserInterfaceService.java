package lotto.service;

import static lotto.restrict.RestrictConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserInterfaceService {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	public String getUserInput() {
		return Console.readLine();
	}

	public String inputUserPurchaseAmount() {
		inputView.printPurchaseAmountMessage();
		return getUserInput();
	}

	public String inputUserWinningNumber() {
		inputView.printWinningNumberMessage();
		return getUserInput();
	}

	public String inputUserBonusNumber() {
		inputView.printBonusNumberMessage();
		return getUserInput();
	}

	public void outputError(Exception e) {
		outputView.printErrorMessage(e);
	}

	public void outputPurchaseCompletion(int purchaseUnitCount) {
		outputView.printPurchaseCompletionMessageFormat(purchaseUnitCount);
	}

	public void outputLottoNumbers(List<Integer> numbers) {
		outputView.printNumbers(numbers);
	}

	public void outputTotalResult(float totalRevenueRate, List<Integer> result) {
		outputView.printTotalTitleMessage();
		outputView.printMatchMessageFormat(FIFTH_RANK_CONDITION, FIFTH_RANK_COMPENSATION, result.get(0));
		outputView.printMatchMessageFormat(FOURTH_RANK_CONDITION, FOURTH_RANK_COMPENSATION, result.get(1));
		outputView.printMatchMessageFormat(THIRD_RANK_CONDITION, THIRD_RANK_COMPENSATION, result.get(2));
		outputView.printBonusMatchMessageFormat(SECOND_RANK_CONDITION, SECOND_RANK_COMPENSATION, result.get(3));
		outputView.printMatchMessageFormat(FIRST_RANK_CONDITION, FIRST_RANK_COMPENSATION, result.get(4));
		outputView.printTotalRevenueMessageFormat(totalRevenueRate);
	}
}
