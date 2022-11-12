package lotto;

public enum ConsoleMessage {
    INVALID_INPUT_PRICE("잘못된 형식의 금액을 입력하셨습니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }

}
