package lotto.view;

public enum OutputMessages {
    PAYMENT("구입금액을 입력해 주세요.\n"),
    ORDER("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.\n"),
    STATISTICS_TITLE("당첨 통계\n"),
    DIVIDING_LINE("---\n"),
    STATISTICS_NORMAL_SENTENCE("%s개 일치 (%s원) - %s개\n"),
    STATISTICS_BONUS_SENTENCE("%s개 일치, 보너스 볼 일치 (%s원) - %s개\n"),
    RATE_OF_RETURN("총 수익률은 %s입니다.\n");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
