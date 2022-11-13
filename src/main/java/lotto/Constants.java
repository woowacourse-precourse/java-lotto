package lotto;

public enum Constants {
    MIN_LOTTO_NUMBER(1), MAX_LOTTO_NUMBER(45), LOTTO_PRICE(1000), LOTTO_NUMBER_COUNT(6);

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
