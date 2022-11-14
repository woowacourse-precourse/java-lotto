package lotto.Domain;

public enum SayMessage {
    BUY("구입금액을 입력해 주세요.\n"),
    ANSWER("당첨 번호를 입력해 주세요.\n"),
    BONUS("보너스 번호를 입력해 주세요.\n");

    private final String sayMessage;

    SayMessage(String sayMessage) {
        this.sayMessage = sayMessage;
    }

    public String getSayMessage() {
        return sayMessage;
    }
}
