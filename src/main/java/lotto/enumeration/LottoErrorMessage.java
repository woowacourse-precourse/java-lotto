package lotto.enumeration;

public enum LottoErrorMessage {
    COMMA_ERROR("[ERROR] 쉼표로 구분된 6개 숫자를 입력해 주시기 바랍니다."),
    DUPLICATION_ERROR("[ERROR] 입력된 숫자에 중복이 있습니다."),
    RANGE_ERROR("[ERROR] 1~45 사이의 수를 입력해 주시기 바랍니다."),
    NUMERIC_ERROR("[ERROR] 숫자를 입력해 주시기 바랍니다."),
    DUPLICATE_WIN_AND_BONUS_ERROR("[ERROR] 당첨 번호와 보너스 번호에 중복된 숫자가 있습니다."),
    UNIT_ERROR("[ERROR] 올바른 단위가 아닙니다.");

    private final String errorMessage;

    LottoErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
