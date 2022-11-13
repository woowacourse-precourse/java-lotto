package lotto;

public class Money {
	private int MONEY;
	
	public Money(int money) {
		validate(money);
		MONEY = money;
	}
	
	private void validate(int money) {
		if(money % 1_000 != 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public int getMoney() {
		return MONEY;
	}
}
