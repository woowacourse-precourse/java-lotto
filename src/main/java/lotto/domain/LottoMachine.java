package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

	public static List<Integer> issueLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(LottoRule.MIN_NUMBER.getValue(), LottoRule.MAX_NUMBER.getValue(),
			LottoRule.NUMBER_COUNT.getValue());
	}

}
