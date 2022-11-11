package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constant.*;

public class LottoFactory {

	protected List<Integer> createUniqueLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_LENGTH);
	}

	protected Lotto issueLottoNumber() {
		List<Integer> lottoNumber = createUniqueLottoNumber();

		return new Lotto(lottoNumber);
	}

	public List<Lotto> issueLottoNumbersByPurchaseAmount(int purchaseAmount) {
		return IntStream.iterate(purchaseAmount, this::hasEnoughMoney, remainedMoney -> remainedMoney - LOTTO_PRICE)
				.mapToObj(seq -> issueLottoNumber())
				.collect(Collectors.toList());
	}

	private boolean hasEnoughMoney(int remainedMoney) {
		return remainedMoney >= LOTTO_PRICE;
	}
}
