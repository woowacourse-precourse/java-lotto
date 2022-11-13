package lotto;

public enum Messages {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    HOW_MANY_SOLD("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    final String message;

    Messages(String message) {
        this.message = message;
    }
}
