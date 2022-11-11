package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

	public List<Integer> generateLotto() {
		List<Integer> lotto = Randoms.pickUniqueNumbersInRange(Constant.FIRST_NUMBER_IN_LOTTO,
			Constant.LAST_NUMBER_IN_LOTTO,
			Constant.LOTTO_SIZE);
		Collections.sort(lotto);
		return lotto;
	}
}
