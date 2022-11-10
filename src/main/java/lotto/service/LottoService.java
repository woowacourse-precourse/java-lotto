package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.vo.LottoAmount;

public class LottoService {
	public List<Lotto> createLottos(LottoAmount lottoAmount) {
		List<Lotto> result = new ArrayList<>();
		for (int count = 0; count < lottoAmount.getAmount(); count++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			result.add(Lotto.of(numbers));
		}

		return result;
	}
}
