package lotto.util;

public enum ErrorMessage {
    NUMBERS_COUNT_ERROR_MESSAGE("로또 번호의 개수가 6개가 아닙니다."),
    DUPLICATE_NUMBER_ERROR_MESSAGE("중복된 번호가 있습니다."),
    NUMBER_RANGE_ERROR_MESSAGE("1 ~ 45의 번호를 입력해주세요."),
    TYPE_ERROR_MESSAGE("숫자를 입력해주세요."),
    MONEY_INPUT_ERROR_MESSAGE("금액을 1000원 단위로 입력해주세요."),
    BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE("보너스 번호와 당첨번호가 중복됩니다.");


    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}