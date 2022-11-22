package lotto.status;

public enum NumberStatus {
    ZERO(0),
    ONE_POINT(1),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MIN_LUCKY_POINT(3),
    TOTAL_NUMBER_OF_LOTTO(6),
    BASE_PRICE_OF_LOTTO(1000),
    FIRST_MATCH_COUNT(6),
    SECOND_OR_THIRD_MATCH_COUNT(5),

    PERCENT(100);

    private int number;

    NumberStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
