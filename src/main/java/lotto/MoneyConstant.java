package lotto;

public enum MoneyConstant {
    LOTTO_PRICE(1000)
    ,MAX_LOTTO_PRIC(2_000_000_000)
    ,FIRST_PRIZE(2_000_000_000)
    ,SECOND_PRIZE(30_000_000)
    ,THIRD_PRIZE(1_500_000)
    ,FOURTH_PRIZE(50_000)
    ,FIFTH_PRIZE(5_000);

    private final int value;
    MoneyConstant(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
