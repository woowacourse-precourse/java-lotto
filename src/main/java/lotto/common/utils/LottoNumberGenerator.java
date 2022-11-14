package lotto.common.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
	private static final int LOTTO_NUMBER_SIZE = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	public static List<Integer> generateLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
	}
}
