package lotto.domain;

public class Pay {
	private final Integer pay;

	Pay(int pay) {
		validate(pay);
		this.pay = pay;
	}

	private void validate(int pay) {
		if (pay % 1000 != 0)
			throw new IllegalArgumentException();
	}
}
