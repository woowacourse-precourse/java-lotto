package lotto.utils;

public enum ExceptionMessage {
    IS_NOT_NUMBER("숫자를 입력해주세요."),
    LESS_THAN_MINIMUM_AMOUNT("구입한 로또 금액은 %d 이상이어야 합니다."),
    INVALID_CURRENCY_UNIT("구입한 로또 금액은 %d 단위로 입력해야합니다. 1,500과 같은 금액은 입력이 불가합니다."),
    INVALID_COUNT("번호의 개수가 잘못되었습니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("%d에서 %d 사이의 번호를 입력해야합니다."),
    NO_INPUT_VALUE("입력값이 없습니다. 값을 입력해주세요."),
    INVALID_SEPARATOR("구분자가 잘못되었습니다. '1,2,3,4,5,6'과 같이 쉼표(,)를 사용해서 값을 입력해주세요."),
    DUPLICATE_VALUE("입력한 당첨 번호간 중복된 값이 있습니다."),
    DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER("입력한 당첨 번호의 값과 보너스 번호의 값이 중복됩니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }

    public String getMessage(int number) {
        return String.format("[ERROR] " + this.message, number);
    }

    public String getMessage(int firstNumber, int secondNumber) {
        return String.format("[ERROR] " + this.message, firstNumber, secondNumber);
    }
}
