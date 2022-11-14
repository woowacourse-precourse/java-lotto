package lotto.view;

public enum LottoNumberRule {
    LOTTO_PRICE(1000),
    LOTTO_MINIMUM_RANK(5);

    private final int value;

    LottoNumberRule (int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }
}
