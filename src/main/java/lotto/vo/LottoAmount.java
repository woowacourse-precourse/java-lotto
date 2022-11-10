package lotto.vo;

public class LottoAmount {
	private final int amount;

	private LottoAmount(int amount) {
		this.amount = amount;
	}

	public static LottoAmount of(int amount) {
		return new LottoAmount(amount);
	}

	public int getAmount() {
		return amount;
	}
}
