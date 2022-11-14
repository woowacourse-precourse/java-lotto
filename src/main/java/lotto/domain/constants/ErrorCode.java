package lotto.domain.constants;

public enum ErrorCode {
    NOT_NUMBER("숫자만 입력 가능합니다."),
    NOT_NEGATIVE_NUMBER("돈은 음수가 될 수 없습니다."),
    NOT_BILL("입력한 금액이 1,000원으로 나누어 떨어지지 않습니다."),

    NOT_HAVE_COMMA("로또 번호 사이에 `,` 를 넣어주세요."),
    NOT_SIX_DIGITS("로또 번호는 6자리 입니다."),
    NOT_IN_RANGE("로또 번호의 범위는 1부터 45가지 입니다."),
    NOT_DUPLICATE("로또 번호는 중복될수없습니다."),

    NOT_ONE_DIGIT("보너스 번호는 1자리 입니다."),
    NOT_CONTAINS_IN_LOTTO("보너스 번호는 로또 번호와 중복될수없습니다.");


    private static final String ERROR_BEGIN = "[ERROR] ";
    private String errorMessage;

    ErrorCode(String message) {
        errorMessage = ERROR_BEGIN + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
