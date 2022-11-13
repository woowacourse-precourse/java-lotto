package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

public class LottoGenerator {
	private List<Integer> numbers;

	private void generateLotto() {
		numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.MINIMUM_LOTTO_NUMBER,
			LottoConstant.MAXIMUM_LOTTO_NUMBER, LottoConstant.COUNT_OF_LOTTO_NUMBERS);
	}

	public List<Integer> getNumbers() {
		generateLotto();
		numbers.sort(null);
		return numbers;
	}
}
