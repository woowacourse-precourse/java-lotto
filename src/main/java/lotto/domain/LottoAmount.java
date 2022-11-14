package lotto.domain;

import lotto.lottoConstant.errorMessage.InputMoneyError;

public class LottoAmount {
	private static final int MIN_UNIT = 1000;
	private static final int PERCENT_NUMBER = 100;
	private static final int ZERO_NUMBER = 0;
	private final int purchaseMoney;

	public LottoAmount(int money) {
		validMoney(money);
		this.purchaseMoney = money;
	}

	private static void validMoney(int money) {
		if (isNotDividedInto1000Units(money)) {
			throw new IllegalArgumentException(InputMoneyError.INPUT_MONEY_ERROR_MESSAGE);
		}
	}

	private static boolean isNotDividedInto1000Units(int money) {
		return money % MIN_UNIT != ZERO_NUMBER;
	}

	public int calculateLottoCount() {
		return purchaseMoney / MIN_UNIT;
	}

	public double calculatePrizeResult(LottoResult lottoResult) {
		long result = lottoResult.getLottoResult().entrySet().stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
			.mapToLong(Integer::longValue).sum();
		return (double)result / purchaseMoney * PERCENT_NUMBER;
	}
}
