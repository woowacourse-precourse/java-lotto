package lotto.domain;

public enum LottoCondition {
    LOTTO_RANGE_MIN(1),
    LOTTO_RANGE_MAX(45),
    LOTTO_RANGE_LENGTH(6),
    LOTTO_BONUS_CNT(1),
    LOTTO_PRICE(1000);

    private final int num;

    LottoCondition(int num){
        this.num = num;
    }
    public int getNum() {
        return num;
    }
}
