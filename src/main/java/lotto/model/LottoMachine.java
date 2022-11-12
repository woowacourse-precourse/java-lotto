package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

	public final int LOTTO_COST = 1000;
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
			lottoBundle.add(new Lotto(createLotto()));
		}
	}

	private List<Integer> createLotto() {
		return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_MIN,
			Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_MAX_RANGE);
	}

	public Wallet buyLotto() {
		return new Wallet(this.lottoBundle, this.purchaseAmount);
	}
}
