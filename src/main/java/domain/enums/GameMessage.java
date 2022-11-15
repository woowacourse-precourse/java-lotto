package domain.enums;

public enum GameMessage {
    PROMPT_MESSAGE("구입금액을 입력해 주세요."),
    BUY_MESSAGE("개를 구매하셨습니다.");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }
}
