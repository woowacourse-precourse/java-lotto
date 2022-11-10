package lotto.enums;

public enum ResultMessage {

    MATCH6("6개 일치 (2,000,000,000원) - {0}개"),
    MATCH5_WITH_BONUS_BALL("5개 일치, 보너스 볼 일치 (30,000,000원) - {0}개"),
    MATCH5("5개 일치 (1,500,000원) - {0}개"),
    MATCH4("4개 일치 (50,000원) - {0}개"),
    MATCH3("3개 일치 (5,000원) - {0}개");

    private final String value;

    ResultMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
