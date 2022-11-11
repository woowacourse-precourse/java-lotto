package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(this.numbers);
	}

	public void lottoPrint() {
		System.out.println(getNumbers());
	}

	public Rank getRank(Lotto winnerLotto, int bonusNumber) {
		Set<Integer> winnerLottoNumbers = new TreeSet<>(winnerLotto.getNumbers());
		this.numbers.removeAll(winnerLottoNumbers);
		int count = 6 - this.numbers.size();
		boolean isBonus = false;
		if (isBonusNumber(bonusNumber, count)) {
			isBonus = true;
		}
		return Rank.findRank(count, isBonus);
	}

	private boolean isBonusNumber(int bonusNumber, int count) {
		return count == 1 && this.numbers.contains(bonusNumber);
	}

}
