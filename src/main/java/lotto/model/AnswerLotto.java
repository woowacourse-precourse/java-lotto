package lotto.model;

import lotto.enums.Rank;
import lotto.Util;

import java.util.ArrayList;
import java.util.List;

public class AnswerLotto {
	private final List<Integer> answer;
	private final Integer bonus;

	public AnswerLotto(List<Integer> answer, Integer bonus) {
		isValidate(answer, bonus);
		this.answer = Util.getSortedList(answer);
		this.bonus = bonus;
	}

	private void isValidate(List<Integer> answer, Integer bonus) {
		isAllCorrectRange(answer, bonus);
		LottoValidator.isCorrectSize(answer);
		LottoValidator.isDistinctNumbers(answer, bonus);
	}

	private void isAllCorrectRange(List<Integer> answer, Integer bonus) { // TODO : 수정
		List<Integer> joinNums = new ArrayList<>();
		joinNums.addAll(answer);
		joinNums.add(bonus);
		joinNums.forEach(LottoValidator::isCorrectRange);
	}

	public int getRank(Lotto lotto) {
		final int COMPUTATIONAL_VALUE = 7;
		int matchCount = getMatchCount(lotto.getNumbers());
		if (matchCount < Rank.FIFTH.getMatchCount()) {
			return Rank.SIXTH.getRank();
		}
		if (matchCount < Rank.THIRD.getMatchCount() ||
				(matchCount == Rank.THIRD.getMatchCount() && !lotto.getNumbers().contains(bonus))) {
			matchCount--;
		}
		return Math.abs(COMPUTATIONAL_VALUE - matchCount);
	}

	private int getMatchCount(List<Integer> numbers) {
		return (int) numbers.stream()
				.filter(num -> answer.contains(num) || num.equals(bonus))
				.count();
	}

}
