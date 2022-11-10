package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Buyer {
	private static final int ZERO_COUNT = 0;

	private final Integer amount;
	private final List<Lotto> lottos;

	public Buyer(String inputAmount) {
		amount = Integer.parseInt(inputAmount);
		lottos = new ArrayList<>();

	}

	private void generateLottoNumber() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(ConstValue.MIN_LOTTO_NUMBER,
			ConstValue.MAX_LOTTO_NUMBER, ConstValue.LOTTO_NUMBERS);
	}

}
