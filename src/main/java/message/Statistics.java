package message;

public enum Statistics {
    MESSAGES("당첨통계\n---"),
    FIVE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    THREE("5개 일치 (1,500,000원) - "),
    TWO("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ONE("6개 일치 (2,000,000,000원) - "),

    COUNT("개"),

    RATE("총 수익률은 "),
    STR("입니다.");

    String str;

    Statistics(String str) {
        this.str = str;
    }

    public String getMessage() {
        return str;
    }
}
