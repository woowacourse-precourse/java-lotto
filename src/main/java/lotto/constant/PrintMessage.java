package lotto.constant;

public enum PrintMessage {
    LOTTO_MATCH_COUNT("%d개 일치"),
    LOTTO_MATCH_BONUS(", 보너스 볼 일치"),
    LOTTO_MATCH_RESULT(" (%s원) - %%d개"),
    LOTTO_RESULT_STATISTIC("당첨 통계\n---"),
    LOTTO_RESULT_YIELD("총 수익률은 %s%%입니다."),
    LOTTO_BUY("%d개를 구매했습니다."),
    INPUT_PRICE("구입금액을 입력해 주세요.\n"),
    INPUT_ANSWER("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS("보너스 번호를 입력해 주세요.\n");


    private final String message;

    private PrintMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}