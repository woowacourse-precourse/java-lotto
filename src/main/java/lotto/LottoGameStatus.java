package lotto;

public enum LottoGameStatus {
    NUMBERS_COUNT_ERROR_MESSAGE("번호의 개수가 6개가 아닙니다."),
    DUPLICATE_NUMBER_ERROR_MESSAGE("중복된 번호가 있습니다."),
    NUMBER_RANGE_ERROR_MESSAGE("1 ~ 45의 번호가 아닙니다."),
    TYPE_ERROR_MESSAGE("숫자가 입력되지 않았습니다."),
    MONEY_INPUT_ERROR_MESSAGE("금액을 1000원 단위로 입력해주세요."),
    BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE("보너스번호와 당첨번호가 중복됩니다."),
    WINNING_NUMBER_ERROR_MESSAGE("당첨번호에 숫자를 입력해주세요.");

    private final String message;

    private LottoGameStatus(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
