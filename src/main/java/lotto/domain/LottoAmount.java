package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoAmount {
	private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력하셔야 합니다.";
	private final int purchaseMoney;

	public LottoAmount(int money) {
		validMoney(money);
		this.purchaseMoney = money;
	}

	private static void validMoney(int money) {
		if (isNotDividedInto1000Units(money)) {
			throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
		}
	}

	private static boolean isNotDividedInto1000Units (int money) {
		return money % 1000 != 0;
	}

	public int calculateLottoCount() {
		return purchaseMoney / 1000;
	}

	public double calculatePrizeResult(LottoResult lottoResult) {
		return lottoResult.getLottoResult().entrySet().stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
			.mapToLong(Integer::longValue).sum();
	}

	public int getPurchaseMoney() {
		return purchaseMoney;
	}
}
