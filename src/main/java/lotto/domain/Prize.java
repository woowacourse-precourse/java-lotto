package lotto.domain;

public enum Prize {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    FIFTH("3개 일치 (5,000원)", 5_000),
    NONE("상금 없음", 0),
    UNCHECKED("확인 전", -1);

    private final String attribute;
    private final int value;
    Prize(String attribute, int value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public int getValue() {
        return value;
    }
}
