package lotto.enums;

public enum ExceptionErrorType {
    INPUT_POSITIVE_NUMBER("양의 수를 입력해야합니다."),
    INPUT_NUMBER_1000_OR_MORE("최소 1000 이상을 입력해야 합니다."),
    INPUT_NUMBER_MULTIPLE_OF_1000("1000의 배수로 입력해야 합니다.");

    private final String ERROR = "[ERROR]";

    private final String description;

    ExceptionErrorType(String description) {
        this.description = ERROR + " " + description;
    }

    public String getDescription() {
        return description;
    }
}
