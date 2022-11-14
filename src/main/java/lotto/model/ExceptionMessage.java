package lotto.model;

public enum ExceptionMessage {
    WRONG_INPUT("잘못된 입력입니다."),
    OUT_OF_BOUNDARY("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복된 숫자가 입력되었습니다."),
    WRONG_PURCHASE_AMOUNT("1000원 단위로 금액을 입력하셔야 합니다."),
    ;

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
