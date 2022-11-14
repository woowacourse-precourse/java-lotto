package lotto.domain;

import java.util.List;

import lotto.service.Lotto;

public class Comparison {
	static List<Integer> winningLotto;
	static int bonusNumber;

	public Comparison(List<Integer> winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public static int matchLottoCount(Lotto myLotto) {
		return (int) winningLotto.stream()
			.filter(myLotto::contains).count();
	}

	public static boolean isMatchBonusNumber (Lotto myLotto) {
		return myLotto.contains(bonusNumber);
	}
}
