package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.Constant.*;

public class LottoFactory {

	protected List<Integer> createUniqueLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_LENGTH);
	}

	protected Lotto issueLottoNumber() {
		List<Integer> lottoNumber = createUniqueLottoNumber();

		return new Lotto(lottoNumber);
	}
}
