package lotto;

import java.util.List;

public class Compare {

	private int[] compareResult = new int[EnumNumeric.WINNER_COLUMNS.getValue()];
	private int sum;
	private String yield;

	public Compare() {
	}

	public void compareNumbers(List<List<Integer>> myLottos, List<Integer> winningNumbers, int bonusNumber) {
		for (List<Integer> myLotto : myLottos) {
			int hitCount = EnumNumeric.INIT_COUNT.getValue();

			for (int winningNumber : winningNumbers) {
				hitCount += isContains(myLotto, winningNumber);
			}

			setResult(hitCount, myLotto, bonusNumber);
		}
	}

	public int isContains(List<Integer> myLotto, int winningNumber) {
		if (myLotto.contains(winningNumber)) {
			return EnumNumeric.CONTAIN_TRUE.getValue();
		}

		return EnumNumeric.CONTAIN_FALSE.getValue();
	}

	public void setResult(int hitCount, List<Integer> myLotto, int bonusNumber) {
		setFirst(hitCount);
		setSecond(hitCount, myLotto, bonusNumber);
		setThird(hitCount, myLotto, bonusNumber);
		setFourth(hitCount);
		setFifth(hitCount);
		sumWinnings();
	}

	public void setFirst(int hitCount) {
		if (hitCount == EnumNumeric.SIX_HITS.getValue()) {
			compareResult[EnumNumeric.FIRST_PLACE.getValue()]++;
		}
	}

	public void setSecond(int htiCount, List<Integer> myLotto, int bonusNumber) {
		if (htiCount == EnumNumeric.FIVE_HITS.getValue() && myLotto.contains(bonusNumber)) {
			compareResult[EnumNumeric.SECOND_PLACE.getValue()]++;
		}
	}

	public void setThird(int hitCount, List<Integer> myLotto, int bonusNumber) {
		if (hitCount == EnumNumeric.FIVE_HITS.getValue() && !myLotto.contains(bonusNumber)) {
			compareResult[EnumNumeric.THIRD_PLACE.getValue()]++;
		}
	}

	public void setFourth(int hitCount) {
		if (hitCount == EnumNumeric.FOUR_HITS.getValue()) {
			compareResult[EnumNumeric.FOURTH_PLACE.getValue()]++;
		}
	}

	public void setFifth(int hitCount) {
		if (hitCount == EnumNumeric.THREE_HITS.getValue()) {
			compareResult[EnumNumeric.FIFTH_PLACE.getValue()]++;
		}
	}

	public void sumWinnings() {
		sum = (EnumNumeric.FIRST_REWARD.getValue() * compareResult[EnumNumeric.FIRST_PLACE.getValue()]) +
				(EnumNumeric.SECOND_REWARD.getValue() * compareResult[EnumNumeric.SECOND_PLACE.getValue()]) +
				(EnumNumeric.THIRD_REWARD.getValue() * compareResult[EnumNumeric.THIRD_PLACE.getValue()]) +
				(EnumNumeric.FOURTH_REWARD.getValue() * compareResult[EnumNumeric.FOURTH_PLACE.getValue()]) +
				(EnumNumeric.FIFTH_REWARD.getValue() * compareResult[EnumNumeric.FIFTH_PLACE.getValue()]);
	}

	public void figureYield(int bettingMoney) {
		yield = String.format(
				EnumPatterns.FORMAT.getValue(),
				(double) EnumNumeric.TO_PERCENTAGY.getValue() * sum / bettingMoney
		);
	}

	public void printResult() {
		System.out.println(
				EnumResult.COMPARE_RESULT_TITLE.getValue() +
				EnumResult.makeFifth(compareResult[EnumNumeric.FIFTH_PLACE.getValue()]) +
				EnumResult.makeFourth(compareResult[EnumNumeric.FOURTH_PLACE.getValue()]) +
				EnumResult.makeThird(compareResult[EnumNumeric.THIRD_PLACE.getValue()]) +
				EnumResult.makeSecond(compareResult[EnumNumeric.SECOND_PLACE.getValue()]) +
				EnumResult.makeFirst(compareResult[EnumNumeric.FIRST_PLACE.getValue()]) +
				EnumResult.YIELD_RESULT_IS.getValue() + yield + EnumResult.TERMINATION.getValue()
		);
	}
}
