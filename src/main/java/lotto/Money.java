package lotto;

public class Money {
	private final int MONEY;
	private int lottoCount;
	
	public Money(int money) {
		validate(money);
		MONEY = money;
		lottoCount = MONEY / 1_000;
	}
	
	private void validate(int money) {
		if (money % 1_000 != 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public int getLottoCount() {
		return lottoCount;
	}
}
