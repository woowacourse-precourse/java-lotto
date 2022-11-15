package lotto.constant;

public enum ErrorMessage {

    LENGTH_OF_LOTTO_NUMBERS_SHOULD_BE_SIX("로또 번호들은 6개의 숫자로 구성되어야 합니다."),
    LOTTO_NUMBERS_SHOULD_BE_UNIQUE("로또 번호들은 서로 다른 수여야 합니다."),
    PAYMENT_UNIT_SHOULD_BE_1000("구입 금액은 1,000원 단위의 수여야 합니다."),
    FORM_OF_WINNING_NUMBERS_IS_WRONG("당첨 번호들의 형태가 잘못되었습니다."),
    VALUES_OF_WINNING_NUMBERS_ARE_WRONG("당첨 번호들의 값들이 잘못되었습니다."),
    FORM_OF_BONUS_NUMBER_IS_WRONG("보너스 번호 형태가 잘못되었습니다."),
    BONUS_NUMBER_AND_WINNING_NUMBER_IS_DUPLICATED("보너스 번호가 당첨 번호와 중복되었습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
