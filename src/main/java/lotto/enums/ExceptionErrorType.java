package lotto.enums;

public enum ExceptionErrorType {
    INPUT_NUMBER("수를 입력해야합니다."),
    INPUT_POSITIVE_NUMBER("양의 수를 입력해야합니다."),
    INPUT_NUMBER_1000_OR_MORE("최소 1000 이상을 입력해야 합니다."),
    INPUT_NUMBER_MULTIPLE_OF_1000("1000의 배수로 입력해야 합니다."),
    INPUT_NUMBER_SPLIT_BY_COMMA("comma로 수를 구분해야합니다."),
    INPUT_NOT_DUPLICATE_NUMBER("중복되는 수를 입력할 수 없습니다."),
    INPUT_NUMBER_BETWEEN_1_45("숫자는 1에서 45의 값만 입력할 수 있습니다."),
    INPUT_NUMBER_NOT_IN_WINNING_NUMBERS("당첨 번호에 있는 번호는 보너스 번호가 될 수 없습니다.");

    private final String ERROR = "[ERROR]";

    private final String description;

    ExceptionErrorType(String description) {
        this.description = ERROR + " " + description;
    }

    public String getDescription() {
        return description;
    }
}
