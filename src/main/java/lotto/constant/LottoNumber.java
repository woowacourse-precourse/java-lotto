package lotto.constant;

public enum LottoNumber {
    START_NUMBER_OF_LOTTO(1),
    END_NUMBER_OF_LOTTO(45);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
