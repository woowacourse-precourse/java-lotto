package lotto;

public enum GuidePhrase {
    BEFORE_PURCHASE("구입금액을 입력해 주세요."),
    AFTER_PURCHASE("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTIC("당첨 통계\n---"),
    EQUALS("개 일치"),
    UNIT("원"),
    COUNT("개"),
    LEADING_PRICE("총 수익률은 "),
    TRAILING_PRICE("%입니다.");

    private final String phrase;

    GuidePhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return this.phrase;
    }
}
