package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

	public final int LottoCost = 1000;
	public final int LottoMinRange = 1;
	public final int LottoMaxRange = 45;
	public final int LottoMaxNumber = 6;

	private final List<Lotto> lottoBundle = new ArrayList<>();


	public LottoMachine(int payMoney) {
		createLottoBundle(countPurchasesLotto(payMoney));
	}

	private int countPurchasesLotto(int payMoney) {
		if (payMoney < LottoCost) {
			throw new IllegalArgumentException("지불 금액이 1000원 이하이입니다.");
		}
		return payMoney / LottoCost;
	}

	private void createLottoBundle(int PurchasesNumber) {
		for (int lottoCount = 0; lottoCount < PurchasesNumber; lottoCount++) {
			lottoBundle.add(createLotto());
		}
	}

	private Lotto createLotto() {
		return new Lotto(
			Randoms.pickUniqueNumbersInRange(LottoMinRange, LottoMaxRange, LottoMaxNumber));
	}

	public List<Lotto> getLottoBundle() {
		return lottoBundle;
	}

}
