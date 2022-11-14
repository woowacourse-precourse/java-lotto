package lotto.view;

public enum ViewMessage {

    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    String message() {
        return message;
    }
}
