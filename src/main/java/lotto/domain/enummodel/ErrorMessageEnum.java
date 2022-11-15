package lotto.domain.enummodel;

public enum ErrorMessageEnum {

    ERROR_MESSAGE_NOT_MATCH("[ERROR]금액 단위를 일치시켜야 합니다."),
    ERROR_MESSAGE_VALIDATE("[ERROR]잘못된 입력값 입니다."),
    ERROR_MESSAGE_INPUT_SIZE("[ERROR]입력 길이가 다릅니다."),
    ERROR_MESSAGE_NUMBER_RANGE("[ERROR] 입력 숫자의 범위가 다릅니다.");

    private final String value;

    ErrorMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
