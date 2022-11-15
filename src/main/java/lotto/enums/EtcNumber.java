package lotto.enums;

public enum EtcNumber {
    ZERO(0), FIRST_RANK(1), RANK_SIZE(5), LOTTO_SIZE(6), NUMBER_MIN(1), NUMBER_MAX(45);

    private int number;

    EtcNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
