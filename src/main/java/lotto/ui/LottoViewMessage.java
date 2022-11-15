package lotto.ui;

public enum LottoViewMessage {
    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_LOTTO_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTICS_HEAD_LINE("당첨통계\n---"),
    YIELD("총 수익률은 "),
    SUFFIX("%입니다.");

    private final String message;

    LottoViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
