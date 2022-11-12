package constant;

public enum LottoNumber {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    REQUIRE_LOTTO_NUMBER_COUNT(6),
    AVAIL_BONUS_NUMBER_COUNT(1);

    private final int value;
    LottoNumber(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
