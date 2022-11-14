package lotto.domain.lotto;

import static lotto.util.constant.Constant.LOTTO_PURCHASE_AMOUNT;

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
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Collections.sort(numbers);
		return new Lotto(numbers);
	}
}
