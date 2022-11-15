package lotto.constant;

public enum ExceptionConstant {

    PRICE_ERROR("[ERROR] 1000원 단위로 입력해야합니다."),
    NUMBER_INPUT_ERROR("[ERROR] 숫자 입력만 가능합니다."),
    COUNT_ERROR("[ERROR] 6개 숫자 입력만 가능합니다."),
    BONUS_COUNT_ERROR("[ERROR] 보너스 볼은 하나만 추첨 가능합니다."),
    INVALID_FORMAT_ERROR("[ERROR] 잘못된 형식의 입력입니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 수 입력입니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
