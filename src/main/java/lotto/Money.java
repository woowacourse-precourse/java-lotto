package lotto;

public class Money {
	private final int MONEY;
	private int lottoCount;
	private String errorMessage = "[ERROR] ";
	
	public Money(int money) {
		validate(money);
		MONEY = money;
		lottoCount = MONEY / 1_000;
	}
	
	private void validate(int money) {
		if (money % 1_000 != 0) {
			errorMessage += "구매 후 남는 돈이 없도록 입력해 주세요.";
			throwException();
		}
	}
	
	private void throwException() {
		try {
			throw new IllegalArgumentException();
		} catch(IllegalArgumentException e) {
			System.out.println(errorMessage);
			return;
		}
	}
	
	public int getMoney() {
		return MONEY;
	}
	
	public int getLottoCount() {
		return lottoCount;
	}
}
