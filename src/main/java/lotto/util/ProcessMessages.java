package lotto.util;

public enum ProcessMessages {
    REQUEST_MONEY_INPUT("구입금액을 입력해 주세요.\n"),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요.\n"),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n"),
    NOTICE_WORD("당첨 통계\n"),
    CONTOUR("---\n"),
    EMPTY_LINE("\n");

    private final String message;

    ProcessMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
