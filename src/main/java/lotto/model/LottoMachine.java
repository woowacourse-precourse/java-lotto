package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public final int LottoCost = 1000;
	public final int LottoMinRange = 1;
	public final int LottoMaxRange = 45;
	public final int LottoMaxNumber = 6;
	public final static String ERROR_PAY = "[ERROR] 지불 금액이 1000원 이하입니다.";

	private final List<Lotto> lottoBundle = new ArrayList<>();
	private final int purchaseAmount;

	public LottoMachine(int Money) {
		int purchaseCount = countPurchasesLotto(Money);
		this.purchaseAmount = purchaseCount * LottoCost;
		createLottoBundle(purchaseCount);
	}

	private int countPurchasesLotto(int payMoney) {
		if (payMoney < LottoCost) {
			throw new IllegalArgumentException(ERROR_PAY);
		}
		return payMoney / LottoCost;
	}

	private void createLottoBundle(int PurchasesNumber) {
		for (int lottoCount = 0; lottoCount < PurchasesNumber; lottoCount++) {
			lottoBundle.add(new Lotto(createLottoNumber()));
		}
	}

	private List<Integer> createLottoNumber() {
		return IntStream.generate(
				() -> Randoms.pickNumberInRange(LottoMinRange, LottoMaxRange))
			.distinct()
			.limit(LottoMaxNumber)
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
