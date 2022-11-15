package lotto.util;

public enum Score {
    ZERO(0, "0개 일치"),
    ONE(0, "1개 일치"),
    TWO(0, "2개 일치"),
    THREE(5000,"3개 일치 (5,000원) - "),
    FOUR(50000, "4개 일치 (50,000원) - "),
    FIVE(1500000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(2000000000, "6개 일치 (2,000,000,000원) - ");
    private final int value;
    private final String message;
    Score(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }
    public String getMessage(){
        return message;
    }
}
