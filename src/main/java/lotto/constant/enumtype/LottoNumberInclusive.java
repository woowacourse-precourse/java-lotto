package lotto.constant.enumtype;

public enum LottoNumberInclusive {
    START(1), END(45);

    private Integer value;

    LottoNumberInclusive(Integer value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public Integer getValue() {
        return value;
    }
}
