package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public final int LOTTO_COST = 1000;
	public final int LOTTO_MIN_RANGE = 1;
	public final int LOTTO_MAX_RANGE = 45;
	public final int LOTTO_MAX_NUMBER = 6;
	public final static String ERROR_PAY = "[ERROR] 지불 금액이 1000원 이하입니다.";

	private final List<Lotto> lottoBundle = new ArrayList<>();
	private final int purchaseAmount;

	public LottoMachine(int Money) {
		int purchaseCount = countPurchasesLotto(Money);
		this.purchaseAmount = purchaseCount * LOTTO_COST;
		createLottoBundle(purchaseCount);
	}

	private int countPurchasesLotto(int payMoney) {
		if (payMoney < LOTTO_COST) {
			throw new IllegalArgumentException(ERROR_PAY);
		}
		return payMoney / LOTTO_COST;
	}

	private void createLottoBundle(int PurchasesNumber) {
		for (int lottoCount = 0; lottoCount < PurchasesNumber; lottoCount++) {
			lottoBundle.add(new Lotto(createLottoNumber()));
		}
	}

	private List<Integer> createLottoNumber() {
		return IntStream.generate(
				() -> Randoms.pickNumberInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE))
			.distinct()
			.limit(LOTTO_MAX_NUMBER)
			.boxed()
			.sorted()
			.collect(Collectors.toList());
	}

	public List<Lotto> getLottoBundle() {
		return lottoBundle;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}
}
