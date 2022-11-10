package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int NUMBER_COUNT = 6;
	public static final int LOTTO_COST = 1000;

	public static List<Integer> issueLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
	}

}
