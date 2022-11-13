package lotto.service;

import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoService {

	public Lotto makeLotto() {
		List<Integer> randomLottoNumbers = new ArrayList<>(makeRandomLottoNumbers());

		Collections.sort(randomLottoNumbers);
		return new Lotto(randomLottoNumbers);
	}

	private List<Integer> makeRandomLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LIMIT_SIZE);
	}
}
