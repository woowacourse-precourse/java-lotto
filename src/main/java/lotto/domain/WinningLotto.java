package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

	private final List<Integer> bonusNumbers;

	public WinningLotto(Lotto lotto, List<Integer> bonusNumbers) {
		super(lotto.getNumbers());
		this.bonusNumbers = bonusNumbers;
	}

	public List<Integer> getBonusNumbers() {
		return bonusNumbers;
	}
}
