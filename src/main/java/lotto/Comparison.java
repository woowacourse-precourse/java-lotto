package lotto;

import java.util.List;

public class Comparison {
	public static int matchLottoCount(List<Integer> winningLotto, List<Integer> myLotto) {
		return (int) winningLotto.stream()
			.filter(myLotto::contains).count();
	}

	public static boolean isMatchBonusNumber (int bonusNumber, List<Integer> myLotto) {
		return myLotto.contains(bonusNumber);
	}
}
