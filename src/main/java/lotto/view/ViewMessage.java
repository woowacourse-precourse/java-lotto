package lotto.view;

public enum ViewMessage {
    INPUT_MONEY("구매금액을 입력해 주세요.\n"),
    INPUT_NUMBERS("구입금액을 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n");
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
