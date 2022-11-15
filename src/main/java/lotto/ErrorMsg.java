package lotto;

public enum ErrorMsg {
    INPUT_AMOUNT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    INPUT_NUMBER("번호의 개수는 6개입니다."),
    INPUT_NUMBER_CONDITION("번호는 1~45 사이의 수로 이루어져 있습니다."),
    INPUT_NUMBER_DUPLICATE("당첨 번호 중에 중복된 숫자가 있습니다."),
    INPUT_BONUS_NUMBER_DUPLICATE("당첨 번호와 중복되지 않는 수를 입력해야 합니다."),
    INPUT_ONLY_NUMBER("숫자만 입력해 주세요."),
    INPUT_NO_SPACE("띄어쓰기가 불가합니다.");
    private final String ERROR_MESSAGE = "[ERROR]";
    private String message;

    ErrorMsg(String message) {
        this.message = ERROR_MESSAGE + " " + message;
    }

    public String getMessage() {
        return message;
    }
}
