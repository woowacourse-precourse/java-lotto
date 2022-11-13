package lotto.domain;

public class LottoAmount {
	private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력하셔야 합니다.";
	private static int MIN_UNIT = 1000;
	private static int ZERO_NUMBER = 0;
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

	private static boolean isNotDividedInto1000Units(int money) {
		return money % MIN_UNIT != ZERO_NUMBER;
	}

	public int calculateLottoCount() {
		return purchaseMoney / MIN_UNIT;
	}

	public double calculatePrizeResult(LottoResult lottoResult) {
		return lottoResult.getLottoResult().entrySet().stream()
			.filter(entry -> LottoRanking.noWin != entry.getKey())
			.map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
			.mapToLong(Integer::longValue).sum();
	}
}
