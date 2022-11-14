package lotto.model;

public enum GameNumber {
    LOTTO_SIZE(6),
    THOUSAND(1000);
    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
