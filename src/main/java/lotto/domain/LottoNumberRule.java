package lotto.domain;

public enum LottoNumberRule {
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    LOTTO_RANGE_SIZE(6),
    MINIMUM_NUMBER_MATCH(3),
    MAXIMUM_NUMBER_MATCH(6);

    private final int lottoNumberRule;

    LottoNumberRule(int lottoNumberRule) {
	this.lottoNumberRule = lottoNumberRule;
    }

    public int getValue() {
	return lottoNumberRule;
    }
}
