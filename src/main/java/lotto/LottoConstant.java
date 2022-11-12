package lotto;

public enum LottoConstant {

    START_NUMBER(1),
    END_NUMBER(45),
    NUMBER_COUNT(6),
    PRICE(1000),
    WINNING_STANDARD(3);

    public int value;

    LottoConstant(int value) {
        this.value = value;
    }
}
