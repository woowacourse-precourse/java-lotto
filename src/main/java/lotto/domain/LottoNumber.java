package lotto.domain;

public enum LottoNumber {
    MIN(1),
    MAX(45),
    SIZE(6);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
