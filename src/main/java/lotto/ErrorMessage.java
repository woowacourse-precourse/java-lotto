package lotto;

public enum ErrorMessage {

    SIZE_NOT_CORRECT("[ERROR] 6자리의 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    IS_NULL_INPUT("[ERROR] 숫자를 입력해주세요."),
    NOT_ONLY_NUMBER("[ERROR] 숫자만 입력할 수 있습니다."),
    NOT_THOUSAND("[ERROR] 1000원 단위로만 입력이 가능합니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
