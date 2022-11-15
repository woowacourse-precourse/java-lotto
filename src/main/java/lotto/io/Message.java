package lotto.io;

public enum Message {

    MONEY_INPUT("구입금액을 입력해 주세요.\n"),
    QUANTITY("\n%d개를 구매했습니다."),
    WINNING_INPUT("\n당첨 번호를 입력해 주세요.\n"),
    BONUS_INPUT("\n보너스 번호를 입력해 주세요.\n"),
    STATISTICS("\n당첨 통계\n---\n"),

    FIRST_RESULT("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_RESULT("5개 일치 (1,500,000원) - %d개"),
    FOURTH_RESULT("4개 일치 (50,000원) - %d개"),
    FIFTH_RESULT("3개 일치 (5,000원) - %d개"),

    YIELD("총 수익률은 %s%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

