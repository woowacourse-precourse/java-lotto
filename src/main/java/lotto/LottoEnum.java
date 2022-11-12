package lotto;

public enum LottoEnum {
    MIN_NUMBER(1), MAX_NUMBER(45), WINNING_NUMBERS(6), BONUS_NUMBERS(1);

    private final int value;
    LottoEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
