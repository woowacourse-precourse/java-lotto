package lotto.status;

public enum NumberStatus {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    TOTAL_NUMBER_OF_LOTTO(6),
    BASE_PRICE_OF_LOTTO(1000),
    FIRST_MATCH_COUNT(6),
    SECOND_OR_THIRD_MATCH_COUNT(5);

    private int number;

    NumberStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
