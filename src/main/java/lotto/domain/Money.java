package lotto.domain;

public class Money {
	private int value;

    public Money(final Money money) {
        this(money.value);
    }

    public Money(final int value) {
        this.value = value;
        validateOverThousand(this.value);
        validateDivideThousand(this.value);
    }

    private void validateOverThousand(final int value) {
        if (value < 1000) {
            throw new IllegalArgumentException("[ERROR] 돈 입력은 1000원 이상이어야 합니다.");
        }
    }
    private void validateDivideThousand(final int value) {
    	if (value % 1000 != 0) {
    		throw new IllegalArgumentException("[ERROR] 돈 입력은 1000원으로 나누어 떨어져야합니다.");
    	}
    }
}
