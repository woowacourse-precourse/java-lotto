package lotto;

public enum Error {
    ERROR_GAME_MONEY_AVAILABLE("[ERROR] 로또 1매 가격은 1000원입니다. 1000원 단위를 맞춰주세요."),
    ERROR_INPUT_PARSING_INT("[ERROR] 해당 입력 값은 숫자형이 아닙니다.");

    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return this.errorMessage;
    }
}
