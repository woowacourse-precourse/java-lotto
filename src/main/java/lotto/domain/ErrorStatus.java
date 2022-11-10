package lotto.domain;

public enum ErrorStatus {
    OUT_OF_RANGE_NUMBER("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    NUMBER_DUPLICATION("로또 번호는 중복된 숫자가 있으면 안됩니다."),
    NUMBERS_SIZE("로또 번호는 개수가 6개여야 합니다."),
    MONEY_RANGE("돈은 1000원 이상이어야 합니다.");

    protected final String ERROR_MESSAGE;

    ErrorStatus(String errorMessage) {
        ERROR_MESSAGE = errorMessage;
    }

    public String printError(){
        return "[ERROR] " + ERROR_MESSAGE;
    };
}
