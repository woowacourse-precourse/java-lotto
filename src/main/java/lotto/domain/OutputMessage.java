package lotto.domain;

public enum OutputMessage {
    PRINT_LOTTO_QUANTITY("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
