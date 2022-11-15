package lotto;

public enum GameMessage {
    START_GAME("구입금액을 입력해 주세요."),
    BUY_COUNT("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_SCORE("당첨 통계");


    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
