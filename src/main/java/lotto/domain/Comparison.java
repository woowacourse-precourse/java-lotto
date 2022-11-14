package lotto.domain;

import java.util.List;

public class Comparison {
	static List<Integer> winningLotto;
	static int bonusNumber;

	public Comparison(List<Integer> winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public static int matchLottoCount(List<Integer> myLotto) {
		return (int) winningLotto.stream()
			.filter(myLotto::contains).count();
	}

	public static boolean isMatchBonusNumber (List<Integer> myLotto) {
		return myLotto.contains(bonusNumber);
	}
}
