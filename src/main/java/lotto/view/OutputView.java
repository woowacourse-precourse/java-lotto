package lotto.view;

import static lotto.message.OutputMessageConstants.*;

import java.util.List;

public class OutputView {

	public void printPurchaseCompletionMessageFormat(int purchaseUnitCount) {
		System.out.printf(PURCHASE_COMPLETION_MESSAGE_FORMAT, purchaseUnitCount);
	}

	public void printTotalTitleMessage() {
		System.out.print(TOTAL_TITLE_MESSAGE);
	}

	public void printMatchMessageFormat(int rankCount, int rankCompensation, int matchCount) {
		System.out.printf(MATCH_MESSAGE_FORMAT, rankCount, rankCompensation, matchCount);
	}

	public void printBonusMatchMessageFormat(int rankCount, int rankCompensation, int matchCount) {
		System.out.printf(BONUS_MATCH_MESSAGE_FORMAT, rankCount, rankCompensation, matchCount);
	}

	public void printTotalRevenueMessageFormat(float totalRevenueRate) {
		System.out.printf(TOTAL_REVENUE_MESSAGE_FORMAT, totalRevenueRate);
	}

	public void printErrorMessage(Exception e) {
		System.out.print(e.getMessage());
	}

	public void printNumbers(List<Integer> numbers) {
		System.out.print("[");
		for (int numbersIndex = 0; numbersIndex < numbers.size(); numbersIndex++) {
			System.out.print(numbers.get(numbersIndex));
			if (numbersIndex != numbers.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}
}
