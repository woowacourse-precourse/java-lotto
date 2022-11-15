package lotto.enums;

public enum ErrorMessage {
    ERROR_NOT_NUMBER("[ERROR] 숫자만 입력해주세요"),
    ERROR_NOT_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_NOT_SAME_NUMBER("같은 숫자를 입력하셨습니다."),
    ERROR_NOT_LENGTH_NUMBER("6개의 숫자를 입력해주세요.");

    final private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
