package lotto.enums;

public enum StatEnum {
    LOTTO_NUMBER(6),
    THREE_CORRECT(3),
    FOUR_CORRECT(4),
    FIVE_CORRECT(5),
    SIX_CORRECT(6),
    INFO("\n당첨 통계\n---"),
    THREE_INFO("3개 일치 (5,000원) - "),
    FOUR_INFO("4개 일치 (50,000원) - "),
    FIVE_INFO("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_INFO("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_INFO("6개 일치 (2,000,000,000원) - "),
    UNIT("개");

    private int number;
    private String message;

    public int getNumber() {
        return number;
    }
    public String getMessage() {
        return message;
    }

    StatEnum(int number) {
        this.number = number;
    }
    StatEnum(String message) {
        this.message = message;
    }
}
