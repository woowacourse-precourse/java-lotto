package lotto.constant;

public enum LottoRule {
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    AMOUNT_OF_NUMBER(6),
    AMOUNT_OF_BONUS(1),
    COST(1000);

    private final int valueForRule;

    LottoRule(int valueForRule) {
        this.valueForRule = valueForRule;
    }

    public int getValueForRule() {
        return this.valueForRule;
    }
}
