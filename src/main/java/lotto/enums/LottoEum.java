package lotto.enums;

public enum LottoEum {
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    START_NUMBER(1),
    LAST_NUMBER(45);

    private final int value;

    private LottoEum(int value) {

        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static boolean isRangeIn(int number){
        if(number < START_NUMBER.value || number > LAST_NUMBER.value)return false;
        return true;
    }
}
