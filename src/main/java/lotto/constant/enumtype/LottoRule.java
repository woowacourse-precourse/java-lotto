package lotto.constant.enumtype;

public enum LottoRule {
    LOTTO_PRICE(1000), LOTTO_MAX_COUNT(6);

    private Integer value;

    LottoRule(Integer value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public Integer getValue() {
        return value;
    }
}
