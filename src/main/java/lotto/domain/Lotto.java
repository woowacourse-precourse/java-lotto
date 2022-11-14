package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lotto.handler.ExceptionHandler;
import lotto.view.ErrorView;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		isDuplicate(numbers);
		this.numbers = numbers;
	}

	private void isDuplicate(List<Integer> numbers) {
		Set<Integer> numberSet = new TreeSet<>(numbers);
		if (numberSet.size() != 6) {
			ExceptionHandler.raisingException(ErrorView.isNotLottoNumberList());
		}
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 입력된 숫자가 6개가 아닙니다.");
		}
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(this.numbers);
	}

	public void lottoPrint() {
		System.out.println(getNumbers());
	}

	public Rank getRank(Lotto winnerLotto, int bonusNumber) {
		List<Integer> checkCountList = new ArrayList<>(this.numbers);
		checkCountList.removeAll(winnerLotto.getNumbers());
		int count = 6 - checkCountList.size();
		boolean isBonus = false;
		if (isBonusNumber(bonusNumber, count)) {
			isBonus = true;
		}
		return Rank.findRank(count, isBonus);
	}

	private boolean isBonusNumber(int bonusNumber, int count) {
		return count == 5 && this.numbers.contains(bonusNumber);
	}

}
