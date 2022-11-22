package lotto.status;

public enum LottoNumberStatus {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    TOTAL_NUMBER_OF_LOTTO(6),
    BASE_PRICE_OF_LOTTO(1000);

    private int number;

    LottoNumberStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
