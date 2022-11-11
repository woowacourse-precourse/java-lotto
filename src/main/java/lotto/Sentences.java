package lotto;

public enum Sentences {
    PRICE("구입금액을 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    LUCKY("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    STATS("당첨 통계"),
    LINE("---"),
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

    static String getRate(String rate) {
        return RATE_START.value() + rate + RATE_END.value();
    }


}
