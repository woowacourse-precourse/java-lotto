package lotto.constant;

public enum LottoNumbers {
    LOTTO_LENGTH(6),
    LOTTO_MIN(0),
    LOTTO_MAX(45);

    private final int number;

    LottoNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
