package lotto.domain;

public enum Request {
    purchaseAmount("구입금액을 입력해 주세요.\n"),
    winNumber("당첨 번호를 입력해 주세요.\n"),
    bonusNumber("보너스 번호를 입력해 주세요.\n");

    private final String value;

    Request(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
