package lotto.utils;

public enum ErrorStatus {
    OUT_OF_RANGE_NUMBER("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    NUMBER_DUPLICATION("로또 번호는 중복된 숫자가 있으면 안됩니다."),
    NUMBERS_SIZE("로또 번호는 개수가 6개여야 합니다."),
    MONEY_RANGE("돈은 1000원 이상이어야 합니다."),
    NOT_NUMBER("구입금액은 숫자여야 합니다."),
    BONUS_DUPLICATION("보너스 번호는 당첨 번호와 중복되면 안됩니다.");

    protected final String ERROR_MESSAGE;

    ErrorStatus(String errorMessage) {
        ERROR_MESSAGE = errorMessage;
    }

    public String printError() {
        return "[ERROR] " + ERROR_MESSAGE;
    }
}
