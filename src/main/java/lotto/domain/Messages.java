package lotto.domain;

public enum Messages {
    INPUT_MONEY("구입금액을 입력해 주세요.\n"),
    INPUT_WIN_LOTTO_NUM("당첨 번호를 입력해 주세요.\n"),
    OUTPUT_LOTTO_COUNT("%d개를 구매했습니다.\n");

    final private String message;

    public String get() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}
