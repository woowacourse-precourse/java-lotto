package lotto.domain.lotto;

import static lotto.util.constant.Constant.LOTTO_END_NUMBER;
import static lotto.util.constant.Constant.LOTTO_LENGTH;
import static lotto.util.constant.Constant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.money.Money;

public class LottoAutoGenerator {

	public List<Lotto> createLottoAccordingToTheAmount(Money money) {
		List<Lotto> lottos = new ArrayList<>();
		int count = money.getLottoPurchaseCount();
		while (count > 0) {
			lottos.add(createLottoByAuto());
			count--;
		}
		return lottos;
	}

	public Lotto createLottoByAuto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,
				LOTTO_END_NUMBER, LOTTO_LENGTH);
		Collections.sort(numbers);
		return new Lotto(numbers);
	}
}
