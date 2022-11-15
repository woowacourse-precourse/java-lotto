package lotto.type;

/**
 * 출력 문구 상수를 모아둔 Enum 클래스
 */
public enum ErrorType {
    NOT_NUMBER_INPUT("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다."),
    INVALID_UNIT("[ERROR] 유효하지 않은 금액 단위입니다.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
