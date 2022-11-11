package lotto;

public enum Sentences {
    PRICE("구입금액을 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    LUCKY("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    STATS("당첨 통계"),
    LINE("---"),
    FIRST("6개 일치 (2,000,000,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THRID("5개 일치 (1,500,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    FIFTH("3개 일치 (5,000원) - "),
    UNIT("개"),
    RATE_START("총 수익률은 "),
    RATE_END("%입니다.");

    private final String sentence;

    Sentences(String sentence) {
        this.sentence = sentence;
    }

    public String value() {
        return sentence;
    }

    static String getPurchase(int amount) {
        return amount + PURCHASE.value();
    }

    static String getResult(Sentences no, int amount) {
        return no.value() + amount + UNIT.value();
    }

    static String getRate(float number) {
        return RATE_START.value() + number + RATE_END.value();
    }


}
